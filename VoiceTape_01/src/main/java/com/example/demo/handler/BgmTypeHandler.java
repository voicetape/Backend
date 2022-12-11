package com.example.demo.handler;

import com.example.demo.entity.Bgm;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(Bgm.class)
public class BgmTypeHandler extends CodeEnumTypeHandler<Bgm> {

    public BgmTypeHandler() {
        super(Bgm.class);
    }

}
