package com.greedy.lucky.board.model.service;

import com.greedy.lucky.board.model.dao.BoardMapper;
import com.greedy.lucky.board.model.dto.BoardDTO;
import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.paging.SelectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {

    List<BoardDTO> findBoardList(SearchInfoDTO selectCriteria);


}
