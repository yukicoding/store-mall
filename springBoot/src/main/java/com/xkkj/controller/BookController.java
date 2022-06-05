package com.xkkj.controller;


import com.xkkj.dao.AddressDao;
import com.xkkj.dao.BookRepository;
import com.xkkj.dao.CommentDao;
import com.xkkj.pojo.Address;
import com.xkkj.pojo.Book;
import com.xkkj.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    HttpServletRequest req;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private AddressDao addressDao;

    //评论
    @GetMapping("/set/{comment}/{id}")
    public void setComment(@PathVariable("comment") String comment, @PathVariable("id") Integer id) {
        Comment comment1 = new Comment();
        comment1.setBId(id);
        comment1.setComments(comment);
        commentDao.savaCommentDao(comment1);
    }

    @GetMapping("/get/{id}")
    public List<Comment> setComment(@PathVariable("id") Integer id) {
        Comment comment1 = new Comment();
        comment1.setBId(id);
        return commentDao.getComment(comment1);
    }

    @GetMapping("/findAll/{page}/{size}")
    //@PathVariable("page") Integer page, @PathVariable("size") Integer size
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable request = PageRequest.of(page - 1, size);
        return bookRepository.findAll(request);
    }

    @GetMapping("/findAlls/{page}/{size}/{username}")
    //@PathVariable("page") Integer page, @PathVariable("size") Integer size
    public Page<Book> findAlls(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("username") String username) {

        //判断是否为管理员用户
        if ("admin".equals(username)) {
            Pageable request = PageRequest.of(page - 1, size);
            return bookRepository.findAll(request);
        }
        return null;
    }

    //订单
    @GetMapping("/getAddress")
    public List<Address> getAddress() {
        return addressDao.getAddress();
    }

    //删除订单
    @GetMapping("/deleteByIdAddress/{id}")
    public void delete(@PathVariable("id") Integer id) {
        addressDao.deleteById(id);
    }

    @PostMapping("/save")
    public String save1(@RequestBody Book book) {
        System.out.println("++++++++++++++++++++++++" + book.getAuthor());
        System.out.println("++++++++++++++++++++++++" + book.getName());
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id).get();
    }

    //修改
    @PutMapping("/update")
    public String update(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    //删除
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookRepository.deleteById(id);
    }
}
