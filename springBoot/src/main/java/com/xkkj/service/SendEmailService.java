package com.xkkj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Value("${spring.mail.username}")
    private String from;
//
//    public void sendSimpleEmail(String to,String subject,String text){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        try {
//            mailSender.send(message);
//        }catch (MailException e){
//            System.out.println("纯文本邮件发送失败"+e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    public void sendComplexEmail(String to,String subject,
//                                 String text,String filePath,
//                                 String rscId,String rscPath) throws Exception {
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setFrom(from);
//        helper.setTo(to);
//        helper.setText(text,true);
//        helper.setSubject(subject);
//        //设置静态资源
//        FileSystemResource res = new FileSystemResource(new File(rscPath));
//        helper.addInline(rscId,res);
//        //设置邮件附件
//        FileSystemResource file = new FileSystemResource(new File(filePath));
//        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
//        helper.addAttachment(fileName,file);
//
//        //发送邮件
//        mailSender.send(message);
//        System.out.println("send successsful!");
//
//    }

    public String sendTemplateEmail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // 使用MimeMessageHelper帮助类，并设置multipart多部件使用为true
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

//            FileSystemResource res = new FileSystemResource(new File(rscPath));
//            helper.addInline(rscId,res);
            // 发送邮件
            mailSender.send(message);
            System.out.println("模板邮件发送成功");
            return "success";
        } catch (MessagingException e) {
            System.out.println("模板邮件发送失败 "+e.getMessage());
            e.printStackTrace();
            return "error";
        }
    }
}
