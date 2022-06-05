package com.xkkj;

import com.xkkj.controller.Emailcontroller;
import com.xkkj.dao.UserDao;
import com.xkkj.pojo.User;
import com.xkkj.service.SendEmailService;
import com.xkkj.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.Random;

@SpringBootTest
class Test1 {
    public static int num=1;
    @Autowired
    UserDao userDao;

@Autowired
UserServiceImpl userService;
    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private Emailcontroller emailcontroller;


  @Test
    void findName1() {
      List<User> all = userDao.findAll();
//      for (int i = 0; i < all.size();i++ ) {
//          BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//          bCryptPasswordEncoder.encode(userDao.)
//          all.set(i,)
//      }
      System.out.println(all);
    }

    @Test
   void text(){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
        boolean xzd = bCryptPasswordEncoder.matches("123", "$2a$10$F2kBRyRMWV.8UDTq8BlsV.T53K7uxWmIt04P98.r9Np9j78xuY50q");
        System.out.println(xzd);
//        System.out.println(encode);
    }
    @Test
    public void sendTemplateEmailTest() {
        String to="1733537193@qq.com";
        String subject="【模板邮件】标题";
        // 使用模板邮件定制邮件正文内容
        Context context = new Context();
        context.setVariable("username", "石头");
        context.setVariable("code", "456123");
//        String rscId = "img";
//        context.setVariable("img001", "cid:"+rscId);

//        String rscPath = "E:\\Desktop\\文档\\我的文档\\个人资料\\证书\\大一\\1.jpg";
        // 使用TemplateEngine设置要处理的模板页面
        String emailContent = templateEngine.process("emailTemplate_vercode", context);
        // 发送模板邮件
        sendEmailService.sendTemplateEmail(to,subject,emailContent);
    }

    @Test
    public void numTest(){
        Random random = new Random();
        num =  (random.nextInt(10000 - 1000) + 1000 + 1);
        System.out.println(num);
        System.out.println("++++++++++++++++++++++"+num());
    }

    public int num(){
        return emailcontroller.num;
    }

}
