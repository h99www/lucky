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
    public void 전체_게시판_게시글_조회용_서비스_메소드_테스드() {

        SelectCriteria selectCriteria = new SelectCriteria();
        selectCriteria.setStartRow(1);
        selectCriteria.setEndRow(10);

//        List<BoardDTO> boardList = boardService.findBoardList(selectCriteria);

    }

    @Test
    public void test() {

        String testString = null;
        if(testString != null) {
            Integer result = Integer.parseInt(testString);
        }
        System.out.println("endTest");



    }




}
