package com.kbstar.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private String user_id;
    private String user_pwd;
    private String user_name;
    private String user_gender;
    private String user_contact;
    private String user_address;
    private Date user_birthday;
    private String admin_check; // 0:고객 / 1:관리자
}
