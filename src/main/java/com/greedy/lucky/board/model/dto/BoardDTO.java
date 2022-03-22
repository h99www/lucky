package com.greedy.lucky.board.model.dto;

import com.greedy.lucky.member.model.dto.MemberDTO;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

public class BoardDTO {

    private int boardNo;
    private int boardType;
    private int categoryCode;
    private String boardTitle;
    private String boardBody;
    private int boardWriterMemberNo;
    private int boardCount;
    private java.sql.Date createdDate;
    private java.sql.Date modifiedDate;
    private String boardStatus;

    private MemberDTO member;
    private CategoryDTO category;

    public BoardDTO() {
    }

    public BoardDTO(int boardNo, int boardType, int categoryCode, String boardTitle, String boardBody, int boardWriterMemberNo, int boardCount, Date createdDate, Date modifiedDate, String boardStatus, MemberDTO member, CategoryDTO category) {
        this.boardNo = boardNo;
        this.boardType = boardType;
        this.categoryCode = categoryCode;
        this.boardTitle = boardTitle;
        this.boardBody = boardBody;
        this.boardWriterMemberNo = boardWriterMemberNo;
        this.boardCount = boardCount;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.boardStatus = boardStatus;
        this.member = member;
        this.category = category;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public int getBoardType() {
        return boardType;
    }

    public void setBoardType(int boardType) {
        this.boardType = boardType;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardBody() {
        return boardBody;
    }

    public void setBoardBody(String boardBody) {
        this.boardBody = boardBody;
    }

    public int getBoardWriterMemberNo() {
        return boardWriterMemberNo;
    }

    public void setBoardWriterMemberNo(int boardWriterMemberNo) {
        this.boardWriterMemberNo = boardWriterMemberNo;
    }

    public int getBoardCount() {
        return boardCount;
    }

    public void setBoardCount(int boardCount) {
        this.boardCount = boardCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getBoardStatus() {
        return boardStatus;
    }

    public void setBoardStatus(String boardStatus) {
        this.boardStatus = boardStatus;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "boardNo=" + boardNo +
                ", boardType=" + boardType +
                ", categoryCode=" + categoryCode +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardBody='" + boardBody + '\'' +
                ", boardWriterMemberNo=" + boardWriterMemberNo +
                ", boardCount=" + boardCount +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", boardStatus='" + boardStatus + '\'' +
                ", member=" + member +
                ", category=" + category +
                '}';
    }
}