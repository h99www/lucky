package com.greedy.lucky.notice.model.dao;

import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.paging.SelectCriteria;
import com.greedy.lucky.config.LuckyApplication;
import com.greedy.lucky.config.MybatisConfig;
import com.greedy.lucky.notice.model.dto.NoticeDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {LuckyApplication.class, MybatisConfig.class, ContextConfiguration.class})
class NoticeMapperTests {

    @Autowired NoticeMapper mapper;
    private NoticeDTO notice;
    private SelectCriteria selectCriteria;

    @BeforeEach
    public void setUp() {

        notice = new NoticeDTO();
        notice.setNoticeNo(1);
        notice.setNoticeTitle("안녕?");
        notice.setNoticeBody("안녕?안녕?");
        notice.setNoticeWriterMemberNo(1);
        selectCriteria = new SelectCriteria();
        selectCriteria.setStartRow(1);
        selectCriteria.setEndRow(100);
    }

    @Test
    public void initTest() {
        assertNotNull(mapper);
    }

    @Test
    public void 전체_공시사항_갯수_테스트() {

        SearchInfoDTO info = new SearchInfoDTO();

        int result = mapper.findNoticeListCount(info);

        assertTrue(result >= 0);

    }

    @Test
    public void 조회_테스트() {
        List<NoticeDTO> noticeList = mapper.findNoticeList(selectCriteria);

        assertNotNull(noticeList);
        assertTrue(noticeList.size() >= 0);


    }

    @Test
    public void 상세_조회_테스트() {
        NoticeDTO notice = mapper.findNoticeDetail(1);

        assertNotNull(notice);

    }

    @Test
    public void 조회수_증가_테스트() {
        NoticeDTO firstResult = mapper.findNoticeDetail(1);
        boolean result = mapper.increaseNoticeCount(1);
        NoticeDTO secondResult = mapper.findNoticeDetail(1);
        assertTrue(result);
        assertEquals(1, secondResult.getNoticeCount() - firstResult.getNoticeCount());
    }

    @Test
    public void 수정_테스트() {
        /* 수정 성공 boolean true 여부 확인 */
        /* 수정값 확인 */
        notice.setNoticeNo(1);
        notice.setNoticeTitle("안녕복돌아");
        boolean result = mapper.modifyNotice(notice);

        assertTrue(result);

        NoticeDTO foundNotice = mapper.findNoticeDetail(notice.getNoticeNo());

        assertEquals("안녕복돌아", foundNotice.getNoticeTitle());
    }

    @Test
    public void 공지사항_삭제_테스트() {

        boolean resultRegist = mapper.registNoitce(notice);
        assertTrue(resultRegist);

        NoticeDTO findNotice = mapper.findNoticeDetail(notice.getNoticeNo());
        assertNotNull(findNotice);

        boolean removeResult = mapper.removeNotice(notice.getNoticeNo());
        assertTrue(removeResult);

        NoticeDTO removeNotice = mapper.findNoticeDetail(notice.getNoticeNo());
        assertNull(removeNotice);
    }

    @Test
    public void 등록_테스트() {
        boolean result = mapper.registNoitce(notice);
        assertTrue(result);
    }


}























