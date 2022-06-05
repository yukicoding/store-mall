package com.xkkj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Service
public class TaskService {
    @Autowired
    private RedisTemplate redisTemplate;

    private static SimpleDateFormat deteFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer count1 = 1;
    private Integer count2 = 1;
    private Integer count3 = 1;
//
//    @Scheduled(cron="0,5 * * * * *")//秒 分 时 天 月 周
//    public  void taskcron() throws Exception{
//        System.out.println(String.format("cron 第%s次执行任务，当前时间为:%s",count1++,deteFormat.format(new Date())));
//        Thread.sleep(6000);//执行一次之后的睡眠时间
//    }

//    @Scheduled(fixedDelay = 8640000) //执行一次的时间时睡眠时间+fixedDelay的时间 （下一个任务在上一个任务结束后一定的时间内执行）
//    public  void taskfixedDelay() throws Exception{
//        System.out.println(String.format("cron 第%s次执行任务，当前时间为:%s",count2++,deteFormat.format(new Date())));
//        Set<String> keys = redisTemplate.keys("*");
//        redisTemplate.delete(keys);
////        for (String key : keys) {
////            redisTemplate.delete(key);
////        }
//
//        Thread.sleep(1000);//
//    }

@Scheduled(fixedRate = 8640000) //每隔一天执行一次
public  void taskfixedDelay() throws Exception{
    System.out.println(String.format("cron 第%s次执行任务，当前时间为:%s",count2++,deteFormat.format(new Date())));
    //采用redisTemplate.keys获取所有的String类型，用集合存起来s
    Set<String> keys = redisTemplate.keys("*");
    redisTemplate.delete(keys);
    }
}
