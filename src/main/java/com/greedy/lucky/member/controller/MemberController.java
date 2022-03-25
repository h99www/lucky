package com.greedy.lucky.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {

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
