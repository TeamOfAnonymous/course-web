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

    @ApiOperation(value = "跳转到首页")
    @GetMapping(value = "goIndex")
    public String goIndex(){
        return "index";
    }

    @ApiOperation(value = "跳转到文章页面")
    @GetMapping(value = "goContent")
    public String goContent(){
        return "content";
    }

    @ApiOperation(value = "跳转到列表页面")
    @GetMapping(value = "goList")
    public String goList(){
        return "list";
    }

    @ApiOperation(value = "跳转到后台编辑页面")
    @GetMapping(value = "goWriter")
    public String goLogin() {
        return "writer";
    }


    @ApiOperation(value = "跳转到后台内容页面")
    @GetMapping(value = "goAdminContent")
    public String goAdminContent() {
        return "content_admin";
    }

    @ApiOperation(value = "跳转到后台登陆页面")
    @GetMapping(value = "goAdminLogin")
    public String goAdminLogin() {
        return "login_admin";
    }

    @ApiOperation(value = "跳转到后台用户页面")
    @GetMapping(value = "goAdminUser")
    public String goAdminUser() {
        return "user_admin";
    }


    @ApiOperation(value = "跳转到后台课程页面")
    @GetMapping(value = "goAdminCourse")
    public String goAdminCourse() {
        return "course_admin";
    }

    @ApiOperation(value = "跳转到后台课时页面")
    @GetMapping(value = "goAdminSession")
    public String goAdminSession() {
        return "session_admin";
    }

    @ApiOperation(value = "跳转到后台首页")
    @GetMapping(value = "goAdminIndex")
    public String goAdminIndex() {
        return "index_admin";
    }




}
