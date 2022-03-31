package com.greedy.lucky.member.controller;

import com.greedy.lucky.Authentication.model.dto.CustomUser;
import com.greedy.lucky.member.model.dto.MemberDTO;
import com.greedy.lucky.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

    private MemberService service;
    
    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }
        
    @RequestMapping("/session")
    public ModelAndView loginMainView(ModelAndView mv, @AuthenticationPrincipal CustomUser user, HttpSession session) {
        MemberDTO loginMember = service.findMemberById(user.getUsername());
        session.setAttribute("loginMember", loginMember);
        mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping("/regist")
    public ModelAndView sendRegistView() {

        return new ModelAndView("/member/registForm");
    }

    @PostMapping("/regist")
    public ModelAndView registMember(ModelAndView mv) {

        mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping("/modify")
    public ModelAndView sendModifyView() {

        return new ModelAndView("/member/modifyForm");
    }
    @PostMapping("/modify")
    public ModelAndView modifyMember() {

        return new ModelAndView("/member/modifyForm");
    }



}
