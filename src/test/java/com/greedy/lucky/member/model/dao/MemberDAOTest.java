package com.greedy.lucky.member.model.dao;

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

    @Test
    public void 회원정보_수정_테스트() {
        MemberDTO member = memberDAO.findMemberById("h9w");
        System.out.println("member = " + member);
        member.setNickname("안녕");

        boolean result = memberDAO.modifyMember(member);
        
        assertTrue(result);
        MemberDTO modifiedMember = memberDAO.findMemberById("h9w");

        assertEquals("안녕", modifiedMember.getNickname());
    }

    @Test
    public void 비밀번호_조회_테스트() {

    }

    @Test
    @DisplayName("회원번호 중복 테스트")
    public void duplicatonCheckId_test() {
        Integer memberNo1 = memberDAO.duplicatonCheckId("admin");
        Integer memberNo2 = memberDAO.duplicatonCheckId("h9w");
        Integer memberNo3 = memberDAO.duplicatonCheckId("h9ww");

        assertNotNull(memberNo1);
        assertNotNull(memberNo2);
        assertNull(memberNo3);

    }
}





















