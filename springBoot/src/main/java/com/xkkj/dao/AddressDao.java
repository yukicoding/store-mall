package com.xkkj.dao;

import com.xkkj.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressDao {

    List<Address> getAddress();

    void deleteById(Integer id);
}
