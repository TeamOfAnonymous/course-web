package com.gcc.course.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;

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

    @ApiOperation(value = "跳转到前台首页")
    @GetMapping(value = "goHomePage")
    public String goHomePage() {
        return "homePage";
    }

    @ApiOperation(value = "跳转到前台课程页面")
    @GetMapping(value = "goCourse/{id}")
    public String goCourse(ModelMap modelMap, @PathVariable String id) {
        modelMap.addAttribute("course_id", id);
        return "course";
    }

    @ApiOperation(value = "跳转到前台文章页面")
    @GetMapping(value = "goArticle/{id}")
    public String goArticle(ModelMap modelMap, @PathVariable String id) {
        modelMap.addAttribute("article_id", id);
        return "article";
    }

    @ApiOperation(value = "跳转到文章列表页")
    @GetMapping(value = "goArticlesList")
    public String goArticlesList() {
        return "articlesList";
    }


}
