package com.example.demo.Service;

import com.example.demo.Entity.Role;
import com.example.demo.Mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

        @Autowired
        RoleMapper roleMapper;
        public List<Role> selectAll() {
            return roleMapper.selectAll();
        }


}
