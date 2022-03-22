package com.greedy.lucky.member.model.service;

import com.greedy.lucky.member.model.dto.MemberDTO;

public interface MemberService {

    MemberDTO findMemberById(String memberId);
}
