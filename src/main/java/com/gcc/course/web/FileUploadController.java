package com.gcc.course.web;

import com.gcc.course.service.FileUploadService;
import com.gcc.course.utils.Md5Util;
import com.gcc.course.utils.EditerImageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by WangZK on 2017/3/24.
 */
@RestController
@RequestMapping("fileUpload")
@Api(value = "文件上传Controller")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadServiceImpl;

    @PostMapping
    @ApiOperation(value = "上传单个图片")
    public MappingJacksonValue imageUpload(@RequestParam("editormd-image-file") MultipartFile multipartFile) {
        EditerImageResult editerImageResult = fileUploadServiceImpl.imageUpload(multipartFile);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(editerImageResult);
        return mappingJacksonValue;
    }

    @PostMapping("again")
    @ApiOperation(value = "再次上传单个图片")
    public MappingJacksonValue imageUploadAgain(@RequestParam("editormd-image-file") MultipartFile multipartFile) {
        EditerImageResult editerImageResult = fileUploadServiceImpl.imageUploadAgain(multipartFile);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(editerImageResult);
        return mappingJacksonValue;
    }

}
