package com.example.demo.service;

import com.example.demo.entity.Record;
import com.example.demo.mapper.RecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final FileUploadService fileUploadService;
    private final RecordMapper recordMapper;

    public URL getUploadUrl(String username) {
        return fileUploadService.getUploadUrl(username);
    }

    public void createRecord(Record record) {
        recordMapper.createRecord(record);
    }

    public List<Record> getRecords(int userId) {
        return recordMapper.getRecordsByUserId(userId);
    }
}
