package com.greedy.lucky.member.model.dao;

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
@ContextConfiguration(classes = {LuckyApplication.class, MybatisConfig.class, ContextConfiguration.class, SpringSecurityConfiguration.class})
class MemberDAOTest {

    @Autowired
    MemberDAO memberDAO;

    @Test
    public void 회원_번호로_회원을_조회하는지_테스트() {

        MemberDTO member = memberDAO.findMemberById("admin");
        System.out.println(member);
        assertNotNull(member);

    }
}