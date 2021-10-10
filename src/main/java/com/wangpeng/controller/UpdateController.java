package com.wangpeng.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/update")
public class UpdateController {

    @RequestMapping("updateImg.do")
    @ResponseBody
    public Map<String,Object> updateImg(HttpServletRequest req, HttpServletResponse resp){

        String picPath = req.getSession().getServletContext().getRealPath("pictures");

        String resPath = null;

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
                        // 加个时间戳防止重名
                        String newFileName = System.currentTimeMillis() + fileItem.getName();
                        resPath = "http://localhost:8080/StudentManager/pictures/" + newFileName;
                        fileItem.write(new File(picPath + "\\" + newFileName));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Map<String,Object> res = new HashMap<>();
        res.put("code",0);
        res.put("msg","");
        Map<String,String> tmp = new HashMap<>();
        tmp.put("src",resPath);
        res.put("data", tmp);

        return res;
    }

}
