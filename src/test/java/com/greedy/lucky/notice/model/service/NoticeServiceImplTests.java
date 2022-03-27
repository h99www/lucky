package com.greedy.lucky.notice.model.service;

import com.greedy.lucky.common.paging.SelectCriteria;
import com.greedy.lucky.config.LuckyApplication;
import com.greedy.lucky.config.MybatisConfig;
import com.greedy.lucky.notice.model.dao.NoticeMapper;
import com.greedy.lucky.notice.model.dto.NoticeDTO;
import com.greedy.lucky.notice.model.dto.NoticeListDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        MybatisConfig.class,
        LuckyApplication.class,
        com.greedy.lucky.config.ContextConfiguration.class
})
class NoticeServiceImplTests {
    private NoticeService service;
    private SelectCriteria selectCriteria;

    @Autowired
    public NoticeServiceImplTests(NoticeService service) {
        this.service = service;
        selectCriteria = new SelectCriteria();
        selectCriteria.setEndRow(100);
        selectCriteria.setStartRow(1);

    }

    @Test
    public void initTest() {
        assertNotNull(service);
        assertNotNull(selectCriteria);
        assertEquals(1, selectCriteria.getStartRow());
        assertEquals(100, selectCriteria.getEndRow());

    }
    @Test
    public void 공지사항_전체_조회_테스트() {
        NoticeListDTO noticeInfo = service.findNoticeList(null);
        List<NoticeDTO> noticeList = noticeInfo.getNoticeList();
        
        assertNotNull(noticeList);
        noticeList.forEach(System.out::println);
    }
    
    @Test
    public void 공지사항_상세_조회_테스트() {
        NoticeDTO notice = service.findNoticeDetail(1);
        
        assertNotNull(notice);
        System.out.println("notice = " + notice);
        
    }


    @Test
    public void 공지사항_등록_테스트() {
        NoticeDTO registNotice = new NoticeDTO();
        registNotice.setNoticeTitle("공지사항제목");
        registNotice.setNoticeBody("공지사항내용");
        registNotice.setNoticeWriterMemberNo(1);

        boolean registResult = service.registNotice(registNotice);

        assertTrue(registResult);
    }

    /*수정*/
    @Test
    public void 공지사항_수정_테스트() {
        NoticeDTO modifyNotice = new NoticeDTO();
        modifyNotice.setNoticeTitle("공지사항제목");
        modifyNotice.setNoticeBody("공지사항내용");
        modifyNotice.setNoticeWriterMemberNo(1);

        service.registNotice(modifyNotice);

        NoticeDTO firstResult = service.findNoticeDetail(modifyNotice.getNoticeNo());

        modifyNotice.setNoticeTitle("안녕안녕");
        modifyNotice.setNoticeBody("졸리다");

        boolean result = service.modifyNotice(modifyNotice);

        assertTrue(result);

        NoticeDTO secondResult = service.findNoticeDetail(modifyNotice.getNoticeNo());

        assertNotEquals(firstResult.getNoticeTitle(), secondResult.getNoticeTitle());
        assertNotEquals(firstResult.getNoticeBody(), secondResult.getNoticeBody());
    }



    /*삭제*/
    @Test
    public void 공지사항_삭제_테스트() {
        NoticeDTO registNotice = new NoticeDTO();
        registNotice.setNoticeTitle("공지사항제목");
        registNotice.setNoticeBody("공지사항내용");
        registNotice.setNoticeWriterMemberNo(1);
        service.registNotice(registNotice);

        NoticeDTO findNotice = service.findNoticeDetail(registNotice.getNoticeNo());
        assertNotNull(findNotice);

        boolean result = service.removeNotice(registNotice.getNoticeNo());
        assertTrue(result);

        findNotice = service.findNoticeDetail(registNotice.getNoticeNo());
        assertNull(findNotice);

    }
}



















































