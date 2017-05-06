package com.gcc.course.service;

import com.gcc.course.web.dto.EditorImageResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by WangZK on 2017/3/24.
 */
public interface FileUploadService {

    EditorImageResult imageUpload(MultipartFile multipartFile);

    EditorImageResult imageUploadAgain(MultipartFile multipartFile);

}
