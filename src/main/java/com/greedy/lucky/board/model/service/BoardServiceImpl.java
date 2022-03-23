package com.greedy.lucky.board.model.service;

import com.greedy.lucky.board.model.dao.BoardMapper;
import com.greedy.lucky.board.model.dto.BoardDTO;
import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.paging.Pagenation;
import com.greedy.lucky.common.paging.SelectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper mapper;

    public BoardServiceImpl(BoardMapper mapper) {

        this.mapper = mapper;
    }

    @Override
    public Map<String, Object> findBoardList(SearchInfoDTO info) {
        Map<String, Object> boardListInfo = new HashMap<>();

        int currentPage= Integer.parseInt(info.getCurrentPage());
        String searchCondition = info.getSearchCondition();
        String searchValue = info.getSearchValue();

        int pageNo = 1;
        int limit = 10;
        int buttonAmount = 5;
        int totalCount = mapper.findBoardListCount(info);
        if(currentPage > 0) {
            pageNo = currentPage;
        }
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(pageNo,totalCount,limit,buttonAmount,searchCondition,searchValue);
        List<BoardDTO> boardList = mapper.findBoardList(selectCriteria);
        boardListInfo.put("boardList", boardList);
        boardListInfo.put("selectCriteria", selectCriteria);

        return boardListInfo;
    }

    @Override
    public boolean registBoard(BoardDTO registBoard) {
        int memberNo = mapper.findMemberNoById(registBoard.getMember().getMemberId());
        registBoard.setBoardWriterMemberNo(memberNo);

        return mapper.registBoard(registBoard);
    }

    @Transactional
    @Override
    public BoardDTO findBoardInfoByNo(int boardNo) {

        mapper.increaseBoardCount(boardNo);

        return mapper.findBoardInfoByNo(boardNo);
    }

    @Override
    public boolean removeBoard(int boardNo) {

        return mapper.removeBoard(boardNo);
    }

    @Override
    public boolean modifyBoard(BoardDTO board) {

        return mapper.modifyBoard(board);
    }


}
