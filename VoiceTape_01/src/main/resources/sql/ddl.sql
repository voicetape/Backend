USE voicetape;

CREATE TABLE `role` (
                        `id`	INT                 NOT NULL    AUTO_INCREMENT      COMMENT 'PK (auto increment)',
                        `code`	VARCHAR(20)         NOT NULL	                    COMMENT '역할 코드(unique)',
                        `name`	VARCHAR(20)         NOT NULL	                    COMMENT '역할 이름',

                        PRIMARY KEY (`id`),
                        CONSTRAINT UK_role_code     UNIQUE  KEY (`code`)
) DEFAULT CHARSET=utf8mb4;


CREATE TABLE `user` (
                        `id`	    INT	            NOT NULL	AUTO_INCREMENT                  COMMENT 'PK (auto increment)',
                        `username`	VARCHAR(20)	    NOT NULL	                                COMMENT 'ID (unique)',
                        `nickname`	VARCHAR(20)	    NOT NULL	                                COMMENT '닉네임',
                        `role_id`	INT	            NOT NULL	                                COMMENT '역할 id',
                        `reg_dttm`	TIMESTAMP	    NOT NULL	DEFAULT CURRENT_TIMESTAMP       COMMENT '등록일',
                        `mod_dttm`	TIMESTAMP	    NOT NULL	DEFAULT CURRENT_TIMESTAMP
                                                                ON UPDATE CURRENT_TIMESTAMP     COMMENT '최근 수정일',

                        PRIMARY KEY (`id`),
                        CONSTRAINT UK_user_username     UNIQUE  KEY (`username`),
                        CONSTRAINT FK_user_role_id      FOREIGN KEY (`role_id`)     REFERENCES `role` (`id`)
) DEFAULT CHARSET=utf8mb4;



CREATE TABLE `bgm` (
                       `id` 	INT	                NOT NULL    AUTO_INCREMENT	    COMMENT 'PK (auto increment)',
                       `code`	VARCHAR(20)	        NOT NULL	                    COMMENT 'BGM 코드(unique)',
                       `name`	VARCHAR(20)	        NOT NULL	                    COMMENT 'BGM 이름',

                       PRIMARY KEY (`id`),
                       CONSTRAINT UK_bgm_code      UNIQUE  KEY (`code`)
) DEFAULT CHARSET=utf8mb4;


CREATE TABLE `voice` (
                         `id` 	INT	                NOT NULL    AUTO_INCREMENT	    COMMENT 'PK (auto increment)',
                         `code`	VARCHAR(20)	        NOT NULL	                    COMMENT '변조음성 코드(unique)',
                         `name`	VARCHAR(20)	        NOT NULL	                    COMMENT '변조음성 이름',

                         PRIMARY KEY (`id`),
                         CONSTRAINT UK_voice_code  UNIQUE  KEY (`code`)
) DEFAULT CHARSET=utf8mb4;


CREATE TABLE `record` (
                          `id`	        INT	            NOT NULL	AUTO_INCREMENT              COMMENT 'PK (auto increment)',
                          `user_id`	    INT	            NOT NULL	                            COMMENT '사용자 ID',
                          `voice_id`	INT	            NULL	                                COMMENT '변조음성 ID',
                          `bgm_id`	    INT	            NULL	                                COMMENT 'BGM ID',
                          `duration`	INT	            NOT NULL	                            COMMENT '녹음 길이 (단위: 초)',
                          `url`	        VARCHAR(1000)	NOT NULL	                            COMMENT 's3 URL(unique)',
                          `reg_dttm`	TIMESTAMP	    NOT NULL	DEFAULT CURRENT_TIMESTAMP   COMMENT '등록일',

                          PRIMARY KEY (`id`),
                          CONSTRAINT UK_record_url        UNIQUE  KEY (`url`),
                          CONSTRAINT FK_record_user_id    FOREIGN KEY (`user_id`)     REFERENCES `user` (`id`),
                          CONSTRAINT FK_record_voice_id   FOREIGN KEY (`voice_id`)    REFERENCES `voice` (`id`),
                          CONSTRAINT FK_record_bgm_id     FOREIGN KEY (`bgm_id`)      REFERENCES `bgm` (`id`)
) DEFAULT CHARSET=utf8mb4;