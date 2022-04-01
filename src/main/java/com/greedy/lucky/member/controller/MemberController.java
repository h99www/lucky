package com.greedy.lucky.member.controller;

import com.greedy.lucky.Authentication.model.dto.CustomUser;
import com.greedy.lucky.common.view.View;
import com.greedy.lucky.member.model.dto.MemberDTO;
import com.greedy.lucky.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    private MemberService service;
    
    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }
        
    @RequestMapping("/session")
    public String loginMainView(@AuthenticationPrincipal CustomUser user, HttpSession session) {
        MemberDTO loginMember = service.findMemberById(user.getUsername());
        session.setAttribute("loginMember", loginMember);

        return "redirect:/";
    }

    @GetMapping("/regist")
    public ModelAndView sendRegistView() {

        return new ModelAndView("/member/regist");
    }

    @PostMapping("/regist")
    public String registMember(@ModelAttribute MemberDTO member) {
        service.registMember(member);

        return "redirect:/";
    }

    @GetMapping("/modify")
    public ModelAndView sendModifyView() {

        return new ModelAndView("/member/modifyForm");
    }
    @PostMapping("/modify")
    public ModelAndView modifyMember() {

        return new ModelAndView("/member/modifyForm");
    }

    @GetMapping(value = "/duplication/{memberId}", produces="text/plain; charset=UTF-8")
    @ResponseBody
    public String duplicationIdCheck(ModelAndView mv, @PathVariable String memberId) {

        String resultMessage = "중복아님";

        /* 아이디가 조회되면 true 반환 > 중복이라는 의미 */
        if(service.duplicationCheckId(memberId)) {
            resultMessage = "중복";
        }

        return resultMessage;
    }

}
