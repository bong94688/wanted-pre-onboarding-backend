<<<<<<< HEAD
package com.example.wantedpreonboardingbackend.member.entity;

import com.example.wantedpreonboardingbackend.board.entity.Board;
import com.example.wantedpreonboardingbackend.member.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
=======
package com.example.bitcamptiger.member.entity;

<<<<<<<< HEAD:bitcamptiger/src/main/java/com/example/bitcamptiger/member/entity/Member.java
import com.example.bitcamptiger.member.dto.MemberDTO;
========
import com.example.wantedpreonboardingbackend.board.entity.Board;
import com.example.wantedpreonboardingbackend.member.dto.MemberDTO;
>>>>>>>> 365d2d9dcc418522926789802695e8665737de00:src/main/java/com/example/wantedpreonboardingbackend/member/entity/Member.java
import jakarta.persistence.*;
import lombok.*;
>>>>>>> 365d2d9dcc418522926789802695e8665737de00

import java.util.List;

@Getter
@Setter
@Table(name = "T_MEMBER", // 테이블 이름을 대문자로 지정
        uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
@SequenceGenerator(
        name = "MemberSeqGenerator",
        sequenceName = "T_MEMBER_SEQ", // 시퀀스 이름을 대문자로 지정
        initialValue = 1,
        allocationSize = 1
)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MemberSeqGenerator"
    )
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

<<<<<<< HEAD
<<<<<<< HEAD:wanted-pre-onboarding-backend/src/main/java/com/example/wantedpreonboardingbackend/member/entity/Member.java
    private String userEmail;
=======
//    @OneToMany(mappedBy = "board")
//    private List<Board> board;
>>>>>>> 365d2d9dcc418522926789802695e8665737de00:src/main/java/com/example/wantedpreonboardingbackend/member/entity/Member.java

    private String userTel;

    @Column(name = "create_date")
    private LocalDateTime userRegdate = LocalDateTime.now();

    @Column
    @ColumnDefault("'ROLE_USER'")
=======
//    @OneToMany(mappedBy = "board")
//    private List<Board> board;

>>>>>>> 365d2d9dcc418522926789802695e8665737de00
    private String role;

    public MemberDTO toMemberDTO() {
        return MemberDTO.builder()
                .id(this.id)
                .username(this.username)
                .password("") // 비밀번호는 빈 문자열로 설정 (DTO에 비밀번호를 담지 않기 위함)
                .role(this.role)
                .build();
    }
}
