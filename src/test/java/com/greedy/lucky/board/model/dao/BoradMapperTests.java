package com.greedy.lucky.board.model.dao;

import com.greedy.lucky.board.model.dto.BoardDTO;
import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.paging.SelectCriteria;
import com.greedy.lucky.config.LuckyApplication;
import com.greedy.lucky.config.MybatisConfig;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {LuckyApplication.class, MybatisConfig.class, ContextConfiguration.class})
public class BoradMapperTests {

    @Autowired
    private BoardMapper mapper;

    @Test
    public void 매퍼_의존성주입_테스트() {
        assertNotNull(mapper);
    }


    @Test
    public void 게시판_게시글_조회_테스트() {
        SelectCriteria selectCriteria = new SelectCriteria();
        selectCriteria.setStartRow(1);
        selectCriteria.setEndRow(10);
        selectCriteria.setSearchCondition("title");
        selectCriteria.setSearchValue("12");

        System.out.println(selectCriteria);System.out.println(selectCriteria);System.out.println(selectCriteria);
        List<BoardDTO> boardList = mapper.findBoardList(selectCriteria);
        boardList.stream().forEach(System.out::println);

        assertNotNull(boardList);
    }

    @Test
    public void 게시글_갯수_조회_테스트() {
        SearchInfoDTO info = new SearchInfoDTO();
        info.getSearchCondition();
        info.getSearchValue();

        int result = mapper.findBoardListCount(info);

        assertEquals(123, result);

    }








}