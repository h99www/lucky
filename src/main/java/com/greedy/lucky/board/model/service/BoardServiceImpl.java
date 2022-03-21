package com.greedy.lucky.board.model.service;

import com.greedy.lucky.board.model.dao.BoardMapper;
import com.greedy.lucky.board.model.dto.BoardDTO;
import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.paging.Pagenation;
import com.greedy.lucky.common.paging.SelectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper mapper;

    public BoardServiceImpl(BoardMapper mapper) {

        this.mapper = mapper;
    }

    @Override
    public List<BoardDTO> findBoardList(SearchInfoDTO info) {
        /* 현재페이지 처리 >> currentPage null일때 1로 처리 */
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

        return mapper.findBoardList(selectCriteria);
    }
}
