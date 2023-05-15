package com.kbstar.controller;

import com.kbstar.dto.Product;
import com.kbstar.dto.User;
import com.kbstar.service.ProductService;
import com.kbstar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    String dir = "user/";

    @Value("${uploadimgdir}")  // application properties 안에서 설정해준 imgdir 경로를 가져옴
    String imgdir;

    @RequestMapping("/all")
    public String main(Model model) throws Exception {
        List<User> list = null;
        list = userService.get();
        model.addAttribute("clist", list);
        model.addAttribute("center", dir + "all");
        return "index";
    }
}
