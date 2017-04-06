package com.gcc.course.service;

import com.gcc.course.utils.EditerImageResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by WangZK on 2017/3/24.
 */
public interface FileUploadService {

    EditerImageResult imageUpload(MultipartFile multipartFile);

    EditerImageResult imageUploadAgain(MultipartFile multipartFile);

}
