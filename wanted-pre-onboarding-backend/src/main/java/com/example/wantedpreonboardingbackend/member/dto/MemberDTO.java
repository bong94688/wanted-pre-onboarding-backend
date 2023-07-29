package com.example.wantedpreonboardingbackend.member.dto;

import com.example.wantedpreonboardingbackend.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
    private Long id;

    private String username;

    private String password;

    private String role;

    private String token;
    public Member toMemberEntity(){
        return Member.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .role(this.role)
                .build();
    }
}
