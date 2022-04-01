package com.greedy.lucky.member.model.service;

import com.greedy.lucky.member.model.dto.MemberDTO;

public interface MemberService {

    MemberDTO findMemberById(String memberId);

    boolean registMember(MemberDTO member);

    boolean modifyMember(MemberDTO member);

    boolean duplicationCheckId(String memberId);
}
