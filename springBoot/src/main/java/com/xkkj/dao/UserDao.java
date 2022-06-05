package com.xkkj.dao;

import com.xkkj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    @Query(value="SELECT * FROM t_user u WHERE u.username = :username",nativeQuery = true)
    User findName(@Param("username") String username);

    @Override
    List<User> findAll();
}
