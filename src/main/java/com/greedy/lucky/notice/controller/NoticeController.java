package com.greedy.lucky.notice.controller;

import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.view.View;
import com.greedy.lucky.member.model.dto.MemberDTO;
import com.greedy.lucky.notice.model.dto.NoticeDTO;
import com.greedy.lucky.notice.model.dto.NoticeListDTO;
import com.greedy.lucky.notice.model.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/notice")
public class NoticeController implements View {

    private final NoticeService service;

    @Autowired
    public NoticeController(NoticeService service) {

        this.service = service;
    }

    @GetMapping("/list")
    public ModelAndView sendNOticeListView(ModelAndView mv, HttpServletRequest request) {
        SearchInfoDTO info = new SearchInfoDTO();
        info.setCurrentPage(request.getParameter("currentPage"));
        info.setSearchValue(request.getParameter("searchValue"));
        info.setSearchCondition(request.getParameter("searchCondition"));

        NoticeListDTO listInfo = service.findNoticeList(info);

        mv.addObject("listInfo", listInfo);
        mv.addObject("selectCriteria", listInfo.getSelectCriteria());
        mv.addObject("intent", "/notice/list");
        mv.setViewName(NOTICE_LIST_VIEW);

        return mv;
    }

    @GetMapping("/detail/{noticeNo}")
    public ModelAndView sendNoticeDetailView(ModelAndView mv, @PathVariable int noticeNo) {

        NoticeDTO notice = service.findNoticeDetail(noticeNo);

        mv.addObject("notice", notice);
        mv.setViewName(NOTICE_DETAIL_VIEW);

        return mv;
    }

    @GetMapping("/remove/{noticeNo}")
    public String removeNotice(@PathVariable int noticeNo){

        service.removeNotice(noticeNo);

        return REDIRECT_NOTICE_LIST_VIEW;
    }

    @GetMapping("/modify/{noticeNo}")
    public ModelAndView sendModifyView(ModelAndView mv, @PathVariable int noticeNo) {

        NoticeDTO notice = service.findNoticeDetail(noticeNo);

        mv.addObject("notice", notice);
        mv.setViewName(NOTICE_MODIFY_VIEW);
        System.out.println("get");System.out.println("get");System.out.println("get");System.out.println("get");
        return mv;
    }

    @PostMapping("/modify")
    public String modifyNotice(@ModelAttribute NoticeDTO notice) {

        service.modifyNotice(notice);
        return REDIRECT_NOTICE_DETAIL_VIEW + notice.getNoticeNo();
    }

    @GetMapping("/regist")
    public String sendToRegistView() {

        return NOTICE_REGIST_VIEW;
    }

    @PostMapping("/regist")
    public String registNotice(@ModelAttribute NoticeDTO notice, @ModelAttribute MemberDTO member) {

        notice.setMember(member);
        /* notice regist  */
        service.registNotice(notice);
        

        return REDIRECT_NOTICE_LIST_VIEW;
    }
}
