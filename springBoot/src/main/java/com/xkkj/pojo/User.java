package com.xkkj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {
    @Id
    @Column(name = "id",unique = true,nullable = false)
    private int id;
    @Column(name = "username",nullable = false)
    private  String username;
    @Column(name = "password",nullable = false)
    private String  password;
    @Column(name = "email",nullable = false)
    private String  email;
    @Column(name = "created",nullable = false)
    private String  created;
    @Column(name = "yz",nullable = false)
    private Integer  yz;
}
