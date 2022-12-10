package com.example.demo.handler;

import com.example.demo.entity.Role;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(Role.class)
public class RoleTypeHandler extends CodeEnumTypeHandler<Role> {

    public RoleTypeHandler() {
        super(Role.class);
    }

}
