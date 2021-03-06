package com.greedy.lucky.member.model.service;

import com.greedy.lucky.config.LuckyApplication;
import com.greedy.lucky.config.MybatisConfig;
import com.greedy.lucky.config.SpringSecurityConfiguration;
import com.greedy.lucky.member.model.dto.MemberDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        ContextConfiguration.class,
        LuckyApplication.class,
        MybatisConfig.class,
        SpringSecurityConfiguration.class
})
class MemberServiceImplTest {

    @Autowired
    MemberServiceImpl service;

    @Test
    public void 회원_아이디로_회원정보를_잘_조회하는지_테스트() {

        MemberDTO member = service.findMemberById("admin");
        System.out.println(member);

        assertNotNull(member);
    }

    @Test
    @DisplayName("아이디 중복 확인 테스트")
    public void duplicationCheckId_test() {

        boolean result1 = service.duplicationCheckId("admin");
        boolean result2 = service.duplicationCheckId("h9w");
        boolean result3 = service.duplicationCheckId("h9ww");

        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);


    }

}