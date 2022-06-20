package com.wangpeng.controller;

import com.wangpeng.utils.UploadResult;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadController {

    /**
     * 我的上传
     * @param req HttpServletResponse
     * @param dirName 文件夹名
     * @return
     */
    private Map<String,String> myUpload(HttpServletRequest req, String dirName) {
        String resPath = null;
        String fileName = null;

        try {
            // 获取web服务器项目的真实物理路径加上dirName的文件夹
            String localDir = req.getSession().getServletContext().getRealPath(dirName);

            // 如果目录不存在，则创建目录
            File resDirFile = new File(localDir);
            if(!resDirFile.exists()) {
                boolean flag = resDirFile.mkdirs();
                if(!flag) throw new RuntimeException("创建目录失败");
            }

            //先判断上传的数据是否多段数据（只有是多段的数据，才是文件上传的）
            if (ServletFileUpload.isMultipartContent(req)) {
                // 创建 FileItemFactory 工厂实现类
                FileItemFactory fileItemFactory = new DiskFileItemFactory();
                // 创建用于解析上传数据的工具类 ServletFileUpload 类
                ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
                // 解析上传的数据，得到每一个表单项 FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                // 循环判断，每一个表单项，是普通类型，还是上传的文件
                for (FileItem fileItem : list) {
                    if (!fileItem.isFormField()) {  // 是上传的文件
                        // 上传的文件
                        System.out.println("表单项的 name 属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        fileName = fileItem.getName();
                        // 加个时间戳防止重名
                        String newFileName = System.currentTimeMillis() + fileName;
                        resPath =  dirName + "/" + newFileName;
                        fileItem.write(new File(localDir + "/" + newFileName));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String,String> resMap = new HashMap<>();
        resMap.put("resPath", resPath);
        resMap.put("fileName", fileName);

        return resMap;
    }

    /**
     * 上传图片
     * @param req HttpServletRequest
     * @return 按要求
     */
    @RequestMapping("uploadImg.do")
    public UploadResult uploadImg(HttpServletRequest req){
        String resPath = myUpload(req, "pictures").get("resPath");
        return UploadResult.success(resPath, null);
    }

    /**
     * 上传附件
     * @param req HttpServletRequest
     * @return 按要求
     */
    @RequestMapping({"uploadAttachment.do", "student/uploadAttachment.do"})
    public UploadResult uploadAttachment(HttpServletRequest req){
        Map<String, String> map = myUpload(req, "attachment");
        String resPath = map.get("resPath");
        String fileName = map.get("fileName");
        return UploadResult.success(resPath, fileName);
    }

    /**
     * 上传文章
     * @param req HttpServletRequest
     * @return 按要求
     */
    @RequestMapping("uploadArticle.do")
    public UploadResult uploadArticle(HttpServletRequest req){
        Map<String, String> map = myUpload(req, "article");
        String resPath = map.get("resPath");
        String fileName = map.get("fileName");
        return UploadResult.success(resPath, fileName);
    }
}
