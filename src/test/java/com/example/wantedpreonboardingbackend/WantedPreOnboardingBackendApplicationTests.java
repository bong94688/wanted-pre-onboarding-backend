package com.example.wantedpreonboardingbackend;

import com.example.wantedpreonboardingbackend.board.entity.Board;
import com.example.wantedpreonboardingbackend.board.entity.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class WantedPreOnboardingBackendApplicationTests {

    //   생성자 주입
    @Autowired
    EntityManager entityManager;

    @Test
    void contextLoads() {
        Board test = new Board();
        entityManager.persist(test);

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        QBoard qBoard = new QBoard("q");

//        persist 저장이후 DB에서 찾아와서 같은지 검사
        Board memberJPAQuery =
                queryFactory.selectFrom(qBoard).fetchOne();


//        검증
        assertThat(memberJPAQuery.getId()).isEqualTo(test.getId());
//        assertThat(memberJPAQuery.getId()).isEqualTo(test.getId());

    }
}
