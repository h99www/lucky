package com.greedy.lucky.board.model.dao;

import com.greedy.lucky.board.model.dto.BoardDTO;
import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> findBoardList(SelectCriteria selectCriteria);

    int findBoardListCount(SearchInfoDTO info);

    boolean registBoard(BoardDTO registBoard);

    int findMemberNoById(String memberId);

    BoardDTO findBoardInfoByNo(int boardNo);
}
