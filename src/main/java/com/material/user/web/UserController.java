package com.material.user.web;

import com.material.user.entity.User;
import com.material.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.Result;

import java.util.List;

/**
 * Created by Doing on 2016/12/16 0016.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> addUser(User user){
        int result = userService.addUser(user);
        if (result == 1){
            String msg = "添加成功！";
            return new Result<String>(true, msg);
        }else {
            String msg = "添加失败！";
            return new Result<String>(false, msg);
        }
    }

    @RequestMapping(value = "/{accountId}/",
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> deleteUser(@PathVariable("accountId")long accountId){
        int result = userService.deleteUser(accountId);
        if (result == 1){
            String msg = "删除成功！";
            return new Result<String>(true, msg);
        }else {
            String msg = "用户不存在！";
            return new Result<String>(false, msg);
        }
    }

    @RequestMapping(value = "/{accountId}/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<User> getUser(@PathVariable("accountId") long accountId){
        User user = userService.getUser(accountId);
        if (user != null){
            return new Result<User>(true, user);
        }else {
            return new Result<User>(false, null);
        }
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
            return new Result< List<User>>(true, users);
    }

    @RequestMapping(value = "/{accountId}/",
            method = RequestMethod.PUT,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> updateUser( User user){
        int  result = userService.updateUser(user);
        if (result == 1){
            String msg = "更新成功！";
            return new Result<String>(true, msg );
        }else {
            String msg = "更新失败！";
            return new Result<String>(false, msg);
        }
    }
}
