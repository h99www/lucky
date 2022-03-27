package com.greedy.lucky.notice.model.dto;

import com.greedy.lucky.member.model.dto.MemberDTO;

import java.sql.Date;

public class NoticeDTO {
    private int noticeNo;
    private String noticeTitle;
    private String noticeBody;
    private int noticeWriterMemberNo;
    private int noticeCount;
    private java.sql.Date createdDate;
    private String noticeStatus;

    private MemberDTO member;

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeNo=" + noticeNo +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeBody='" + noticeBody + '\'' +
                ", noticeWriterMemberNo=" + noticeWriterMemberNo +
                ", noticeCount=" + noticeCount +
                ", createdDate=" + createdDate +
                ", noticeStatus='" + noticeStatus + '\'' +
                ", member=" + member +
                '}';
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public NoticeDTO() {
    }

    public NoticeDTO(int noticeNo, String noticeTitle, String noticeBody, int noticeWriterMemberNo, int noticeCount, Date createdDate, String noticeStatus, MemberDTO member) {
        this.noticeNo = noticeNo;
        this.noticeTitle = noticeTitle;
        this.noticeBody = noticeBody;
        this.noticeWriterMemberNo = noticeWriterMemberNo;
        this.noticeCount = noticeCount;
        this.createdDate = createdDate;
        this.noticeStatus = noticeStatus;
        this.member = member;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeBody() {
        return noticeBody;
    }

    public void setNoticeBody(String noticeBody) {
        this.noticeBody = noticeBody;
    }

    public int getNoticeWriterMemberNo() {
        return noticeWriterMemberNo;
    }

    public void setNoticeWriterMemberNo(int noticeWriterMemberNo) {
        this.noticeWriterMemberNo = noticeWriterMemberNo;
    }

    public int getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        this.noticeCount = noticeCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

}
