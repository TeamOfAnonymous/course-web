package com.gcc.course.service;

import com.gcc.course.utils.RequestResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by WangZK on 2017/3/24.
 */
public interface FileUploadService {

    RequestResult imageUpload(MultipartFile multipartFile);

    RequestResult imageUploadAgain(MultipartFile multipartFile);

}
