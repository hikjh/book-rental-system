package com.stable.bookrentalsystem.book.client.dto;


import java.util.List;

public record BookInfoResponse(
        String resultCode,
        String resultMsg,
        String numOfRows,
        String pageNo,
        String totalCount,
        List<BookInfo> items
) {}
