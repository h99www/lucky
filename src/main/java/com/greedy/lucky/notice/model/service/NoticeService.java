package com.greedy.lucky.notice.model.service;

import com.greedy.lucky.board.model.dto.SearchInfoDTO;
import com.greedy.lucky.common.paging.SelectCriteria;
import com.greedy.lucky.notice.model.dto.NoticeDTO;
import com.greedy.lucky.notice.model.dto.NoticeListDTO;

import java.util.List;

public interface NoticeService {

    NoticeListDTO findNoticeList(SearchInfoDTO info);

    NoticeDTO findNoticeDetail(int noticeNo);

    boolean registNotice(NoticeDTO registNotice);

    boolean modifyNotice(NoticeDTO modifyNotice);

    boolean removeNotice(int noticeNo);
}
