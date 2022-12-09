package com.example.demo.dto.Config;

import lombok.Data;

public class KakaoProfile { // 이게 일단 무슨용도인지 잘 모르겠음

    public int id;
    public String connectedAt;
    public Properties properties;
    public KakaoAccount kakaoAccount;

    @Data
    public class Properties {
        private String nickname;
    }

    @Data
    public class KakaoAccount { // private class --> 안이면 그 내부 변수들도 private 인지 public 인지 --> 아님 또 따로 지정을 해줘야 하는 것인지

        Boolean profileNicknameNeedsAgreement;
        Boolean profileImageNeedsAgreement;
        Profile profile;
        Boolean hasEmail;
        Boolean emailNeedsAgreement;
        Boolean isEmailValid;
        Boolean isEmailVerified;
        String email;
    }

    @Data
    public class Profile {
        String nickname;
        String thumbnailImageUrl;
        String profileImageUrl;
        Boolean isDefaultImage;
    }

}