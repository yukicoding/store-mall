package com.xkkj.pojo;


import lombok.Data;

import javax.persistence.Id;

@Data
public class Order {
    @Id

    private Integer o_id;
    private String o_price;
    private String o_isPaid;
    private String o_user;
    private String o_createAt;
    private String o_deliver;
    private String o_order;
    private Integer o_bookId;
    private String o_book;
}
