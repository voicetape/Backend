package com.example.demo.controller;

import com.example.demo.entity.Bgm;
import com.example.demo.entity.Record;
import com.example.demo.entity.User;
import com.example.demo.entity.Voice;
import com.example.demo.service.RecordService;
import com.example.demo.service.UserService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/record")
public class RecordController {

    private final RecordService recordService;
    private final UserService userService;

    @GetMapping("/url/{username}")
    public ResponseEntity<UploadUrlResponse> getUploadUrl(@PathVariable String username) {
        String uploadUrl = recordService.getUploadUrl(username).toString();

        UploadUrlResponse response = UploadUrlResponse.builder()
                .url(uploadUrl)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> createRecord(@Valid @RequestBody CreateRecordRequest request) {
        User user = userService.getUserByUsername(request.getUsername());
        Record record = Record.builder()
                .userId(user.getId())
                .voice(request.getVoice())
                .bgm(request.getBgm())
                .duration(request.getDuration())
                .url(request.getUploadUrl())
                .build();

        recordService.createRecord(record);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<GetRecordsResponse> getRecords(@PathVariable String username) {
        int userId = userService.getUserByUsername(username).getId();

        GetRecordsResponse response = GetRecordsResponse.builder()
                .records(GetRecordsResponse.from(recordService.getRecords(userId)))
                .build();
        return ResponseEntity.ok(response);
    }


    @Data
    @Builder
    static class UploadUrlResponse {
        private String url;
    }

    @Data
    static class CreateRecordRequest {

        @NotNull
        @Size(min = 1, max = 20)
        private String username;

        private Voice voice;

        private Bgm bgm;

        @NotNull
        private Integer duration;

        @NotNull
        @Size(min = 1, max = 1000)
        private String uploadUrl;
    }

    @Data
    @Builder
    static class GetRecordsResponse {

        private List<RecordItem> records;

        @Data
        @Builder
        static class RecordItem {
            private Integer duration;
            private String url;
            private Voice voice;
            private Bgm bgm;
        }

        protected static List<RecordItem> from(List<Record> records) {
            return records.stream().map(GetRecordsResponse::of)
                    .collect(Collectors.toList());
        }

        private static RecordItem of(Record record) {
            return RecordItem.builder()
                    .duration(record.getDuration())
                    .url(record.getUrl())
                    .voice(record.getVoice())
                    .bgm(record.getBgm())
                    .build();
        }
    }
}
