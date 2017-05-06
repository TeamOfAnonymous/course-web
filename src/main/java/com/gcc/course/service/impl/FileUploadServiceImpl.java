package com.gcc.course.service.impl;

import com.gcc.course.domain.Image;
import com.gcc.course.repository.ImageRepository;
import com.gcc.course.service.FileUploadService;
import com.gcc.course.utils.FileUploadUtil;
import com.gcc.course.utils.Md5Util;
import com.gcc.course.utils.UuidUtil;
import com.gcc.course.web.dto.EditorImageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by WangZK on 2017/3/24.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    //文章图片的相对路径文件夹
    @Value("${imageUrl}")
    private String imageUrl;

    @Autowired
    private ImageRepository imageRepository;

    /**
     * 文件上传
     *
     * @param multipartFile
     * @return
     */
    @Override
    public EditorImageResult imageUpload(MultipartFile multipartFile) {
        EditorImageResult editorImageResult = new EditorImageResult();
        String url = findByMd5Str(multipartFile);
        if (url == null || "".equals(url)) {
            editorImageResult = imageUpload(multipartFile, editorImageResult);
        } else {
            editorImageResult.setSuccess(0);
            editorImageResult.setMessage("图片已存在,是否使用已存在的照片？");
            editorImageResult.setUrl(url);
        }
        return editorImageResult;
    }

    /**
     * 再次上传文件
     *
     * @param multipartFile
     * @return
     */
    @Override
    public EditorImageResult imageUploadAgain(MultipartFile multipartFile) {
        EditorImageResult editorImageResult = new EditorImageResult();
        editorImageResult = imageUpload(multipartFile, editorImageResult);
        return editorImageResult;
    }

    /**
     * 判断文件是否已经存在
     *
     * @param multipartFile
     * @return
     */
    private String findByMd5Str(MultipartFile multipartFile) {
        try {
            String md5_string = Md5Util.getMd5(multipartFile);
            List<Image> images = imageRepository.findByMd5Str(md5_string);
            if (images.size() > 0) {
                return images.get(0).getImageUrl();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对文件进行删除并保存相应的信息
     *
     * @param multipartFile
     * @param editorImageResult
     * @return
     */
    private EditorImageResult imageUpload(MultipartFile multipartFile, EditorImageResult editorImageResult) {
        String newName = UuidUtil.get32UUID();
        String url = null;
        String md5_string = null;
        try {
            md5_string = Md5Util.getMd5(multipartFile);
            url = FileUploadUtil.uploadFile(multipartFile, newName, imageUrl);
            Image image = new Image();
            image.setImageUrl(url);
            image.setMd5Str(md5_string);
            imageRepository.save(image);
            editorImageResult.setSuccess(1);
            editorImageResult.setMessage("上传成功");
            editorImageResult.setUrl(url);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return editorImageResult;
    }
}
