package com.greedy.lucky.board.model.service;

import com.greedy.lucky.board.model.dto.BoardDTO;
import com.greedy.lucky.common.paging.SelectCriteria;
import com.greedy.lucky.config.LuckyApplication;
import com.greedy.lucky.config.MybatisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {LuckyApplication.class, MybatisConfig.class, ContextConfiguration.class})
public class BoardServiceTests {

    @Autowired private BoardService boardService;

    @Test
    public void testInit() {
        assertNotNull(boardService);
    }

    @Test
    public void 게시판_등록_테슽트() {
        BoardDTO registBoard = new BoardDTO();
        registBoard.setBoardType(1);
        registBoard.setCategoryCode(10);
        registBoard.setBoardTitle("안ㄴ여?");
        registBoard.setBoardBody("안ㄴ여사에ㅛ");
        registBoard.setBoardWriterMemberNo(1);

        boolean result = boardService.registBoard(registBoard);

        assertNotNull(result);

    }



}
