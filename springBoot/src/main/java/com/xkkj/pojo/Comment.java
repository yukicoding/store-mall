package com.xkkj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer id;
    private Integer bId;//书籍id
    private String comments;//评论内容
    private String createdName;//创建人
}
