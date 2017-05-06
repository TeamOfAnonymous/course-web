package com.gcc.course.web.controller.admin;

import com.gcc.course.domain.User;
import com.gcc.course.service.UserService;
import com.gcc.course.utils.WebResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by WangZK on 2017/3/20.
 */
@RestController
@RequestMapping("admin/user")
@Api(value = "用户服务" , description ="提供用户的 增删该查 功能" )
public class UserAdminController {

    @Autowired
    private UserService userServiceImpl;

    @PostMapping
    private WebResult add(@RequestBody User user){
        //return userServiceImpl.save(user);
        return null;
    }


}
