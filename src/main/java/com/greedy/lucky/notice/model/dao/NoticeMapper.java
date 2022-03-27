package com.greedy.lucky.notice.model.dao;

import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.paging.SelectCriteria;
import com.greedy.lucky.notice.model.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    int findNoticeListCount(SearchInfoDTO info);

    List<NoticeDTO> findNoticeList(SelectCriteria selectCriteria);

    NoticeDTO findNoticeDetail(int noticeNo);

    boolean increaseNoticeCount(int noticeNo);

    boolean modifyNotice(NoticeDTO notice);

    boolean removeNotice(int noticeNo);

    boolean registNoitce(NoticeDTO notice);
}
