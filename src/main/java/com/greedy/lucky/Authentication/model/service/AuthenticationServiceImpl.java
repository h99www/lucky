package com.greedy.lucky.Authentication.model.service;

import com.greedy.lucky.Authentication.model.dto.CustomUser;
import com.greedy.lucky.member.model.dao.MemberDAO;
import com.greedy.lucky.member.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    private final MemberDAO memberDAO;

    @Autowired
    public AuthenticationServiceImpl(MemberDAO memberDAO) {

        this.memberDAO = memberDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberDTO member = memberDAO.findMemberById(username);

        if(member == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(member.getMemberRole()));


        return new CustomUser(member, authorities);
    }
}

















