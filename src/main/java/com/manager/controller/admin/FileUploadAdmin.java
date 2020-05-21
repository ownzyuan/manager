package com.manager.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadAdmin {

    /**
     * 前往文件上传页面
     * @return
     */
    @RequestMapping("/")
    public String toSingleFileupload(){
        return "admin/AdminUploadFile";
    }

    /**
     * 单文件上传
     * @param file
     * @param model
     * @return
     */
    @PostMapping("/singleFile")
    public String SingleFileUpLoad(@RequestParam("myfile") MultipartFile file, Model model) {
        //判断文件是否为空
        if(file.isEmpty()){
            model.addAttribute("result_singlefile", "文件为空");
            return "admin/AdminUploadFile";
        }

        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            //指定上传的位置为 d:/upload/
            String path = "d:/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            //获取上传时的文件名
            String fileName = file.getOriginalFilename();
            //注意是路径+文件名
            File targetFile = new File(path + fileName);
            //如果之前的 String path = "d:/upload/" 没有在最后加 / ，那就要在 path 后面 + "/"

            //判断文件父目录是否存在
            if(!targetFile.getParentFile().exists()){
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }

            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
            FileCopyUtils.copy(inputStream, outputStream);
            /*参数是通过源码
                public static int copy(InputStream in, OutputStream out) throws IOException {
                    ......
                }
           而得知的*/

            //告诉页面上传成功了
            model.addAttribute("result_singlefile", "上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉页面失败
            model.addAttribute("result_singlefile", "上传失败");
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "admin/AdminUploadFile";
    }

    /**
     * 多文件上传
     * @param model
     * @param request
     * @return
     */
    @PostMapping("/multiFile")
    public String MultiFileUpload(Model model, HttpServletRequest request) {

        List<MultipartFile> list_files=((MultipartHttpServletRequest)request).getFiles("myfile");

        if(list_files.isEmpty()){
            model.addAttribute("result_multifile", "文件为空");
            return "admin/AdminUploadFile";
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String path = "d:/upload/";
        for (MultipartFile file : list_files) {
            try {
                inputStream = file.getInputStream();
                String fileName = file.getOriginalFilename();
                File targetFile = new File(path + fileName);

                if(!targetFile.getParentFile().exists()){
                    targetFile.getParentFile().mkdir();
                }

                outputStream = new FileOutputStream(targetFile);
                FileCopyUtils.copy(inputStream, outputStream);
                model.addAttribute("result_multifile", "上传成功");
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("result_multifile", "上传失败");
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "admin/AdminUploadFile";
    }

    /*@RequestMapping("/upload")
    public String fileUpload(@RequestParam("myfile") MultipartFile file,Model model){
        if(file.isEmpty()){
            model.addAttribute("result", "文件为空");
            return "index";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = "D:/upload" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            model.addAttribute("result", "上传成功");
            return "index";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            model.addAttribute("result", "上传失败");
            return "index";
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("result", "上传失败");
            return "index";
        }
    }*/

}
