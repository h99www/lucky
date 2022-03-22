package com.greedy.lucky.member.model.dao;

import com.greedy.lucky.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MemberDAO {
    MemberDTO findMemberById(String memberId);
}
