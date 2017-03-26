package com.gcc.course.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by WangZK on 2017/3/13.
 * 文件上传的工具类
 */
public class FileUploadUtil {

    /**
     * 获取文件的后缀名
     *
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 删除文件
     *
     * @param fileName
     * @return
     */
    public static boolean deletedFile(String fileName) {
        File file = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath() + fileName);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            return true;
        }
        return false;
    }

    /**
     * 上传文件
     *
     * @param multipartFile
     * @param newName       新的文件名称
     * @param imageUrl      图片的相对路径
     * @return
     */
    public static String uploadFile(MultipartFile multipartFile, String newName, String imageUrl) throws IOException {

        File newFile = null;

        newFile = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + imageUrl);

        //创建文件夹
        mkdir(newFile);

        //文件上传的相对路径
        String uploadPath = imageUrl + newName + getSuffix(multipartFile.getOriginalFilename());

        //创建新的文件
        newFile = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + uploadPath);

        multipartFile.transferTo(newFile);

        return uploadPath;
    }

    /**
     * 创建文件夹
     *
     * @param file
     */
    public static void mkdir(File file) {
        if (!file.isDirectory()) {
            file.mkdir();
        }
    }


}
