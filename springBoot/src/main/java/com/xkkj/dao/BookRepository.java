package com.xkkj.dao;

import com.xkkj.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository<实体类，组件类型>
public interface BookRepository extends JpaRepository<Book,Integer> {

}
