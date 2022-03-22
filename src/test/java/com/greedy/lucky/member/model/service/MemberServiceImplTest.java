package com.greedy.lucky.member.model.service;

import com.greedy.lucky.config.LuckyApplication;
import com.greedy.lucky.config.MybatisConfig;
import com.greedy.lucky.config.SpringSecurityConfiguration;
import com.greedy.lucky.member.model.dto.MemberDTO;
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


}