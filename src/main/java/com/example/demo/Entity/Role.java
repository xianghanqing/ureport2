package com.example.demo.Entity;

import lombok.Data;

@Data
public class Role {
    private String roleId;
    private String name;
    private String lvl;

    public Role(String roleId,String name,String lvl)
    {
        this.roleId = roleId;
        this.name = name;
        this.lvl = lvl;
    }

}
