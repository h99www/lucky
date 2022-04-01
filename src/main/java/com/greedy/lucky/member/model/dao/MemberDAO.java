package com.greedy.lucky.member.model.dao;

import com.greedy.lucky.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MemberDAO {
    MemberDTO findMemberById(String memberId);

    boolean modifyMember(MemberDTO member);

    boolean registMember(MemberDTO member);

    String findPwdByMemberId(String memberId);

    Integer duplicatonCheckId(String memberId);
}
