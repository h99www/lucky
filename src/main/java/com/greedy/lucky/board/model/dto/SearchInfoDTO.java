package com.greedy.lucky.board.model.dto;

public class SearchInfoDTO {
    private String currentPage;
    private String searchCondition;
    private String searchValue;

    public SearchInfoDTO() {}

    public SearchInfoDTO(String currentPage, String searchCondition, String searchValue) {
        this.currentPage = currentPage;
        this.searchCondition = searchCondition;
        this.searchValue = searchValue;
    }

    public String getCurrentPage() {
        notNullPage();

        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        if(currentPage == null || "".equals(currentPage)) {
            this.currentPage = "1";
        } else {
            this.currentPage = currentPage;
        }
    }

    public String getSearchCondition() {
        notNullCondition();

        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public String getSearchValue() {
        notNullValue();

        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    @Override
    public String toString() {
        return "SearchInfoDTO{" +
                "currentPage='" + currentPage + '\'' +
                ", searchCondition='" + searchCondition + '\'' +
                ", searchValue='" + searchValue + '\'' +
                '}';
    }

    private void notNullPage(){
        if(this.currentPage == null) {
            this.currentPage = "";
        }
    }

    private void notNullValue(){
        if(this.searchValue == null) {
            this.searchValue = "";
        }
    }

    private void notNullCondition(){
        if(this.searchCondition == null) {
            this.searchCondition = "";
        }
    }

}
