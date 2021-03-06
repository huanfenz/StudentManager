package com.wangpeng.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/update")
public class UpdateController {

    /**
     * 我的上传
     * @param req HttpServletResponse
     * @param resp HttpServletResponse
     * @param dirName 文件夹名
     * @return
     */
    private Map<String,String> myUpdate(HttpServletRequest req, HttpServletResponse resp, String dirName) {
        String picPath = req.getSession().getServletContext().getRealPath(dirName);

        String resPath = null;
        String fileName = null;

        //先判断上传的数据是否多段数据（只有是多段的数据，才是文件上传的）
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建 FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类 ServletFileUpload 类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // 解析上传的数据，得到每一个表单项 FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                // 循环判断，每一个表单项，是普通类型，还是上传的文件
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        // 普通表单项
                        System.out.println("表单项的 name 属性值：" + fileItem.getFieldName());
                        // 参数 UTF-8.解决乱码问题
                        System.out.println("表单项的 value 属性值：" + fileItem.getString("UTF-8"));
                    } else {
                        // 上传的文件
                        System.out.println("表单项的 name 属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        fileName = fileItem.getName();
                        // 加个时间戳防止重名
                        String newFileName = System.currentTimeMillis() + fileName;
                        resPath =  dirName + "/" + newFileName;
                        fileItem.write(new File(picPath + "/" + newFileName));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Map<String,String> resMap = new HashMap<>();
        resMap.put("resPath", resPath);
        resMap.put("fileName", fileName);

        return resMap;
    }

    /**
     * 上传图片
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @return 按要求
     */
    @RequestMapping("updateImg.do")
    public Map<String,Object> updateImg(HttpServletRequest req, HttpServletResponse resp){
        String resPath = myUpdate(req, resp, "pictures").get("resPath");

        Map<String,Object> res = new HashMap<>();
        res.put("code",0);
        res.put("msg","");
        Map<String,String> tmp = new HashMap<>();
        tmp.put("src",resPath);
        res.put("data", tmp);

        return res;
    }

    /**
     * 上传附件
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @return 按要求
     */
    @RequestMapping({"updateAttachment.do", "student/updateAttachment.do"})
    public Map<String,Object> updateAttachment(HttpServletRequest req, HttpServletResponse resp){

        Map<String, String> map = myUpdate(req, resp, "attachment");
        String resPath = map.get("resPath");
        String fileName = map.get("fileName");

        Map<String,Object> res = new HashMap<>();
        res.put("code",0);
        res.put("msg","");
        Map<String,String> tmp = new HashMap<>();
        tmp.put("src",resPath);
        res.put("data", tmp);
        res.put("fileName", fileName);

        return res;
    }

    /**
     * 上传文章
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @return 按要求
     */
    @RequestMapping("updateArticle.do")
    public Map<String,Object> updateArticle(HttpServletRequest req, HttpServletResponse resp){

        Map<String, String> map = myUpdate(req, resp, "article");
        String resPath = map.get("resPath");
        String fileName = map.get("fileName");

        Map<String,Object> res = new HashMap<>();
        res.put("code",0);
        res.put("msg","");
        Map<String,String> tmp = new HashMap<>();
        tmp.put("src",resPath);
        res.put("data", tmp);
        res.put("fileName", fileName);

        return res;
    }
}
