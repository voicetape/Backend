package com.example.demo.service;

import com.example.demo.entity.Record;
import com.example.demo.mapper.RecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordMapper recordMapper;

    public String getUploadUrl() {
        return null;
    }

    public void uploadRecord(Record record) {
        recordMapper.createRecord(record);
    }

    public List<Record> getRecords(int userId) {
        return recordMapper.getRecordsByUserId(userId);
    }
}
