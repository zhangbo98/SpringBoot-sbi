package com.hp.controller;

import com.hp.entity.User;
import com.hp.serevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("word")
    @ResponseBody
    public String sayHello() {
        System.out.println("0000");
        return "success";
    }


    @GetMapping("{id}")
    @ResponseBody
    //@RequestMapping(value = "user/{id}",method = "")
    public User queryUserBdyId(@PathVariable("id") Long i) {
       User user = userService.queryUserBdyId(i);
       return user;
    }

    @GetMapping("/del/{ids}")
    @ResponseBody
    //@RequestMapping(value = "user/{id}",method = "")
    public String deleteUserBdyId(@PathVariable("ids") Long id) {
       userService.deleteUserBdyId(id);
        return "删除成功";
    }

    /*查看所有*/
    @GetMapping("list")
    @PatchMapping
    public String queryAllUser(Model model){
        List<User> userList=userService.queryAllUser();
        model.addAttribute("users",userList);
        return "item";
    }

    @RequestMapping("userAdd")
    public String toAdd() {
        return "userAdd";
    }

    /*添加*/
    @RequestMapping("/ add")
    public String add(User user) {
        userService.saveUser(user);
        return "redirect:/list";
    }
}
