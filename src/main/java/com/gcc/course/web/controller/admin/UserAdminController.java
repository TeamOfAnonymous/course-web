package com.gcc.course.web.controller.admin;

import com.gcc.course.domain.User;
import com.gcc.course.service.UserService;
import com.gcc.course.web.dto.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by WangZK on 2017/3/20.
 */
@RestController
@RequestMapping({"admin/user"})
@Api(value = "后台-用户服务" , description ="提供用户的 增删该查 功能" )
public class UserAdminController {

    @Autowired
    private UserService userServiceImpl;

    @PostMapping
    @ApiOperation(value = "注册用户")
    public WebResult add(@RequestBody User user){
        return userServiceImpl.save(user);
    }

    @PutMapping
    @ApiOperation(value = "更新用户信息")
    public WebResult update(@RequestBody User user){
        return userServiceImpl.update(user);
    }

    @PutMapping("password")
    @ApiOperation(value = "修改用户密码")
    public WebResult updatePassword( @RequestParam String username , @RequestParam String oldPassword , @RequestParam String newPassword){
        return userServiceImpl.updatePassword( username , oldPassword,newPassword);
    }

}
