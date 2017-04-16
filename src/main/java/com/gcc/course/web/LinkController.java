package com.gcc.course.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WangZK on 2017/3/13.
 */
@Controller
@Api(value = "课程系统的链接管理Controller")
public class LinkController {

    @ApiOperation(value = "跳转到后台登陆页面")
    @GetMapping(value = "goAdminLogin")
    public String goAdminLogin() {
        return "index";
    }

}
