package com.example.demo.Mapper;

import com.example.demo.Entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleMapper {
    List<Role> selectAll();

}
