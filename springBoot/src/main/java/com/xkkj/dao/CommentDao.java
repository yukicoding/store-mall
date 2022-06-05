package com.xkkj.dao;

import com.xkkj.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {

    //新增评论
    void savaCommentDao(Comment comment);

    //根据父级ID查询评论
    List<Comment> getComment(Comment comment);
}
