package com.kbstar.controller;

import com.kbstar.dto.User;
import com.kbstar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MainController {

    @Value("${adminserver}")
    String adminserver;

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("adminserver", adminserver);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String user_id, String user_pwd,
                            HttpSession session) throws Exception {

        User user = null;
        String nextPage = "loginfail";

        user = userService.get(user_id);
        // db에 정보가 있고, 비밀번호가 일치한 경우 로그인 성공
        if(user != null && encoder.matches(user_id, user.getUser_id())){
            nextPage = "loginsuccess";
            session.setMaxInactiveInterval(10000);
            session.setAttribute("loginadm", user);
        }

        model.addAttribute("center", nextPage);
        return "index";
    }


}
