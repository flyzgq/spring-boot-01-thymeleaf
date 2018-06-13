package com.fly.springboot.controller;

import com.fly.springboot.entity.User;
import com.fly.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: fly
 * @Description:
 * @Date: 2018/5/5 16:56
 * @Modified By:
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ModelAndView insertUser(String name,String email, Model model){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setBirth(new Date());
        user.setCreatTime(new Date());
        model.addAttribute("user", userRepository.save(user));
        return new ModelAndView("redirect:/users");
    }


    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
       userRepository.saveAndFlush(user);
        return "redirect:/users";
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model){
        model.addAttribute("userList", userRepository.getById(id));
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 获取用户列表
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView getUserList(Model model){
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查看用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userRepository.getById(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取创建表单界面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView form(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
