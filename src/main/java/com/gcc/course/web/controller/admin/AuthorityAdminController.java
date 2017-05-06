package com.gcc.course.web.controller.admin;

import com.gcc.course.domain.Authority;
import com.gcc.course.domain.AuthorityName;
import com.gcc.course.service.AuthorityService;
import com.gcc.course.web.dto.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huangMP on 2017/5/6.
 * decription :
 */
@RestController
@RequestMapping({"admin/authority"})
@Api(value = "后台-权限服务",description = "提供权限的 增删改查 功能")
public class AuthorityAdminController {

    @Autowired
    private AuthorityService authorityService;

    @PostMapping
    @ApiOperation(value = "根据名称创建权限 可用名称:ROLE_USER, ROLE_ADMIN")
    WebResult save(@RequestBody Authority authority){
        return authorityService.save(authority);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查找权限")
    WebResult get(@PathVariable String id){
        return authorityService.get(id);
    }

    WebResult update(Authority authority){
        return authorityService.update(authority);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据id删除权限")
    WebResult remove(@PathVariable String id){
        return authorityService.remove(id);
    }

    @GetMapping
    @ApiOperation(value = "查找所有权限")
    WebResult findAll(){
        return authorityService.findAll();
    }

    @GetMapping("name")
    @ApiOperation(value = "根据名称创建权限 可用名称:ROLE_USER, ROLE_ADMIN")
    WebResult fingByName(@RequestParam String name) {
        return authorityService.fingByName(name);
    }
}
