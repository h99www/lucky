package com.greedy.lucky.board.controller;

import com.greedy.lucky.board.model.dto.BoardDTO;
import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.board.model.service.BoardService;
import com.greedy.lucky.common.paging.SelectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ModelAndView findBoardList(ModelAndView mv, HttpServletRequest request) {
        SearchInfoDTO info = new SearchInfoDTO();
        info.setCurrentPage(request.getParameter("currentPage"));
        info.setSearchValue(request.getParameter("searchValue"));
        info.setSearchCondition(request.getParameter("searchCondition"));

        Map<String, Object> boardListInfo = service.findBoardList(info);

        List<BoardDTO> boardList = (List<BoardDTO>) boardListInfo.get("boardList");
        SelectCriteria selectCriteria = (SelectCriteria) boardListInfo.get("selectCriteria");
        System.out.println(selectCriteria);System.out.println(selectCriteria);System.out.println(selectCriteria);System.out.println(selectCriteria);System.out.println(selectCriteria);System.out.println(selectCriteria);System.out.println(selectCriteria);System.out.println(selectCriteria);

        mv.addObject("intent", "/board/list");
        mv.addObject("boardList", (List<BoardDTO>) boardListInfo.get("boardList"));
        mv.addObject("selectCriteria", (SelectCriteria) boardListInfo.get("selectCriteria"));
        mv.setViewName("board/boardlist");

        return mv;
    }


}
