package com.xkkj.controller;

import com.xkkj.dao.UserDao;
import com.xkkj.pojo.User;
import com.xkkj.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Random;

@RestController
public class Emailcontroller {
    public static int num=1;
    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private UserDao userDao;

    @PostMapping("/email")
    public String email(@RequestBody User user){
        if(user.getUsername()==""||user.getEmail()==""||user.getPassword()==""){
            return "error";
        }
        else {
            if (userDao.findName(user.getUsername())!=null){
                return "error1";
            }
            else {
                Context context = new Context();
                Random random = new Random();
                num =  (random.nextInt(10000 - 1000) + 1000 + 1);
                context.setVariable("username", user.getUsername());
                context.setVariable("code", num);
                String emailContent = templateEngine.process("emailTemplate_vercode", context);
                String yzm = sendEmailService.sendTemplateEmail(user.getEmail(), "请查收验证码", emailContent);
                return yzm;
            }
        }

        }
}
