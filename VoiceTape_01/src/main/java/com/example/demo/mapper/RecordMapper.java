package com.example.demo.mapper;

import com.example.demo.entity.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {

    List<Record> getRecordsByUserId(int userId);

    void createRecord(Record record);
}
