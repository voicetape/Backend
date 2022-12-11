package com.example.demo.handler;

import com.example.demo.entity.Voice;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(Voice.class)
public class VoiceTypeHandler extends CodeEnumTypeHandler<Voice> {

    public VoiceTypeHandler() {
        super(Voice.class);
    }

}
