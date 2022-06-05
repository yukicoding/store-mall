package com.xkkj.service;

import com.xkkj.controller.Emailcontroller;
import com.xkkj.dao.UserDao;
import com.xkkj.pojo.User;
import com.xkkj.util.CookieUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private Emailcontroller emailcontroller;
    @Value("${REDIS_KEY}")   //从配置文件中取值
    private String KEY;

    private Map<Integer,String> UserLogin = new HashMap<>();

    public User userlogin(HttpServletRequest request, HttpServletResponse response, User u){
        //查询登录是否成功
        User user = userDao.findName(u.getUsername());
        if(user==null){
            return null;
        }
        String password =user.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(u.getPassword(), (password)) || u.getPassword().equals(password)){
            //生成token
            String token="user_"+ UUID.randomUUID().toString();
            //从map中获得redis中的key
            String oldToken = UserLogin.get(user.getId());
            //判断map中是否存在该id
            if(!StringUtils.isEmpty(oldToken)){
                //删除redis中老的值
                redisTemplate.delete(oldToken);
            }
            //将新的的key保存到map中
            UserLogin.put(user.getId(),token);
            //将信息存入redis
            redisTemplate.opsForValue().set(token, user);
            //将token放入cookie中
            CookieUtils.setCookie(request,response,KEY,token,5*60,true);
            return user;
        }else{
            return null;
        }
    }

    /**
     * 判断是否登录
     */
    public String getUserByToken(HttpServletResponse response, HttpServletRequest request) {
        //从cookie中取出用户token
        String token=CookieUtils.getCookieValue(request,KEY);
        //从redis中取出用户信息
        String user= (String) redisTemplate.opsForValue().get(token);
        System.out.println("++++++++user:"+user);
        return user;
    }

    public User registersave(User user1){
        if (userDao.findName(user1.getUsername())==null&&Integer.valueOf(user1.getYz()).intValue()==emailcontroller.num){
            BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
            user1.setPassword(bCryptPasswordEncoder.encode(user1.getPassword()));
            return  userDao.save(user1);
        }else {
            return null;
        }
    }
}
