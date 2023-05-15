package com.example.cloneinstagram.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {
    private String nickName;

    private String email;

    private String password;
}
