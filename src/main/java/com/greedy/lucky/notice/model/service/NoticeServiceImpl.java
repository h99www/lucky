package com.greedy.lucky.notice.model.service;

import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.paging.Pagenation;
import com.greedy.lucky.common.paging.SelectCriteria;
import com.greedy.lucky.notice.model.dao.NoticeMapper;
import com.greedy.lucky.notice.model.dto.NoticeDTO;
import com.greedy.lucky.notice.model.dto.NoticeListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper mapper;

    @Autowired
    public NoticeServiceImpl(NoticeMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public NoticeListDTO findNoticeList(SearchInfoDTO info) {

        NoticeListDTO listInfo = new NoticeListDTO();

        int currentPage= Integer.parseInt(info.getCurrentPage());
        String searchCondition = info.getSearchCondition();
        String searchValue = info.getSearchValue();

        int pageNo = 1;
        int limit = 10;
        int buttonAmount = 5;
        int totalCount = mapper.findNoticeListCount(info);
        if(currentPage > 0) {
            pageNo = currentPage;
        }
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(pageNo,totalCount,limit,buttonAmount,searchCondition,searchValue);

        List<NoticeDTO> noticeList = mapper.findNoticeList(selectCriteria);
        listInfo.setNoticeList(noticeList);
        listInfo.setSelectCriteria(selectCriteria);

        return listInfo;
    }

    @Override
    public NoticeDTO findNoticeDetail(int noticeNo) {

        return mapper.findNoticeDetail(noticeNo);
    }

    @Override
    public boolean registNotice(NoticeDTO registNotice) {

        return mapper.registNoitce(registNotice);
    }

    @Override
    public boolean modifyNotice(NoticeDTO modifyNotice) {

        return mapper.modifyNotice(modifyNotice);
    }

    @Override
    public boolean removeNotice(int noticeNo) {

        return mapper.removeNotice(noticeNo);
    }
}
