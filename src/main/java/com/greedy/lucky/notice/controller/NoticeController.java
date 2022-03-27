package com.greedy.lucky.notice.controller;

import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.notice.model.dto.NoticeListDTO;
import com.greedy.lucky.notice.model.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/notice")
public class NoticeController {

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
        mv.setViewName("/notice/list");

        return mv;
    }


}
