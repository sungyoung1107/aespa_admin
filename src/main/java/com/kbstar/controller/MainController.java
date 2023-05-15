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

        try {
            user = userService.get(user_id);
            logger.info(user_id);
            // db에 정보가 있고, 비밀번호가 일치한 경우 로그인 성공
//            if (user != null && encoder.matches(user_id, user.getUser_id())) {
//                nextPage = "loginsuccess";
//                session.setMaxInactiveInterval(10000);
//                session.setAttribute("loginadm", user);
//            }
            // 암호화 이전 (나중에 지우기)
            if (user != null && user_pwd.equals(user.getUser_pwd())) {
                nextPage = "loginsuccess";
                session.setMaxInactiveInterval(10000);
                session.setAttribute("loginadm", user);
            }
        } catch(Exception e){
            throw new Exception("잠시 후에 다시 시도해 주시기 바랍니다.");
        }
        model.addAttribute("center", nextPage);
        return "index";
    }


    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        if(session!=null){
            session.invalidate();
        }
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("center", "register");
        return "index";
    }




}
