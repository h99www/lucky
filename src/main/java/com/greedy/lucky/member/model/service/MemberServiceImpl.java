package com.greedy.lucky.member.model.service;

import com.greedy.lucky.member.model.dao.MemberDAO;
import com.greedy.lucky.member.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {

        this.memberDAO = memberDAO;
    }

    @Override
    public MemberDTO findMemberById(String memberId) {

        return memberDAO.findMemberById(memberId);
    }

    @Override
    public boolean registMember(MemberDTO registMember) {

        return memberDAO.registMember(registMember);
    }

    @Override
    public boolean modifyMember(MemberDTO member) {

        return memberDAO.modifyMember(member);
    }

    @Override
    public boolean duplicationCheckId(String memberId) {

        return memberDAO.duplicatonCheckId(memberId) != null;
    }


}























