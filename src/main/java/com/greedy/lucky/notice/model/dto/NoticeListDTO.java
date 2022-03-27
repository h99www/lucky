package com.greedy.lucky.notice.model.dto;

import com.greedy.lucky.common.paging.SelectCriteria;

import java.util.List;

public class NoticeListDTO {
    private List<NoticeDTO> noticeList;
    private SelectCriteria selectCriteria;

    public NoticeListDTO() {
    }

    public NoticeListDTO(List<NoticeDTO> noticeList, SelectCriteria selectCriteria) {
        this.noticeList = noticeList;
        this.selectCriteria = selectCriteria;
    }

    public List<NoticeDTO> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<NoticeDTO> noticeList) {
        this.noticeList = noticeList;
    }

    public SelectCriteria getSelectCriteria() {
        return selectCriteria;
    }

    public void setSelectCriteria(SelectCriteria selectCriteria) {
        this.selectCriteria = selectCriteria;
    }

    @Override
    public String toString() {
        return "NoticeListDTO{" +
                "noticeList=" + noticeList +
                ", selectCriteria=" + selectCriteria +
                '}';
    }
}
