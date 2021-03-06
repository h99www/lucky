package com.greedy.lucky.common.view;

public interface View {
    public static final String REDIRECT = "redirect:";
    public static final String REDIRECT_MAIN_VIEW = REDIRECT + "/";



    /* notice view */
    public static final String NOTICE_REGIST_VIEW = "/notice/regist";
    public static final String NOTICE_LIST_VIEW = "/notice/list";
    public static final String NOTICE_DETAIL_VIEW = "/notice/detail";
    public static final String NOTICE_MODIFY_VIEW = "/notice/modify";
    public static final String REDIRECT_NOTICE_LIST_VIEW = REDIRECT +  NOTICE_LIST_VIEW;
    public static final String REDIRECT_NOTICE_DETAIL_VIEW = REDIRECT + NOTICE_DETAIL_VIEW + "/";
    public static final String NOTICE_INTENT = "/notice/list";


}
