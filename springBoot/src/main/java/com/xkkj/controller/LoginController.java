package com.xkkj.controller;

import com.xkkj.config.ResponseResult;
import com.xkkj.pojo.User;
import com.xkkj.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private Emailcontroller emailcontroller;

    /*
    登录模块
     */
    @PostMapping("/login")
    public ResponseResult Login(HttpServletResponse response , HttpServletRequest request, @RequestBody User user, Model model){
        ResponseResult responseResult=new ResponseResult();
        try {
            User user2 = userService.userlogin(request, response, user);
            HttpSession session = request.getSession();
            if (user2!=null){
                responseResult.setState(200);
                session.setAttribute("success",user2);
//                sessions.setAttribute("user",user);
                responseResult.setMsg("登录成功！");
                return responseResult;
            }else{
                responseResult.setState(202);
                responseResult.setMsg("用户名或密码错误！");
                return responseResult;
            }
        }catch (Exception e) {
            responseResult.setState(500);
            responseResult.setMsg("发生错误，登录失败！");
            return responseResult;
        }
    }

    /*
    注册模块
     */
    @PostMapping("/register")
    public String save1(@RequestBody User user){
        System.out.println("++++++++++++++++++++++++"+user.getUsername());  //输出账号
        System.out.println("++++++++++++++++++++++++"+user.getPassword());  //输出密码
        System.out.println("++++++++++++++++++++++++"+user.getEmail());     //输出邮箱
        System.out.println("avb"+emailcontroller.num);                       //输出发送的验证码
        System.out.println(Integer.valueOf(user.getYz()).intValue() == (emailcontroller.num));

        User registersave = userService.registersave(user);
        System.out.println("+++++++++++++++++++++"+registersave);
        if(registersave!=null){
            emailcontroller.num = 0;
            return "success";
        }else{
            return "error";
        }
    }
}
