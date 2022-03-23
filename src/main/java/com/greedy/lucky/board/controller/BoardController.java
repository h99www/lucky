package com.greedy.lucky.board.controller;

import com.greedy.lucky.Authentication.model.dto.CustomUser;
import com.greedy.lucky.board.model.dto.BoardDTO;
import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.board.model.service.BoardService;
import com.greedy.lucky.common.paging.SelectCriteria;
import com.greedy.lucky.member.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

        mv.addObject("intent", "/board/list");
        mv.addObject("boardList", (List<BoardDTO>) boardListInfo.get("boardList"));
        mv.addObject("selectCriteria", (SelectCriteria) boardListInfo.get("selectCriteria"));
        mv.setViewName("board/boardlist");

        return mv;
    }

    @GetMapping("/regist")
    public ModelAndView sendRegistForm(ModelAndView mv) {
        mv.setViewName("board/boardRegist");

        return mv;
    }

    @PostMapping("/regist")
    public ModelAndView registBoard(ModelAndView mv, @ModelAttribute BoardDTO board, @AuthenticationPrincipal CustomUser user) {
        MemberDTO member = new MemberDTO();
        member.setMemberId(user.getUsername());
        board.setMember(member);

        if(service.registBoard(board)) {
            System.out.println("등록 성공");
        } else {
            System.out.println("등록 실패");
        }

        mv.setViewName("redirect:/board/list");

        return mv;
    }

    @GetMapping("/detail/{boardNo}")
    public ModelAndView findBoardDetail(ModelAndView mv, @PathVariable int boardNo) {

        BoardDTO board = service.findBoardInfoByNo(boardNo);

        mv.addObject("board", board);
        mv.setViewName("board/detail");

        return mv;
    }


}
