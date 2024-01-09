package com.stable.bookrentalsystem.book.client;

import com.stable.bookrentalsystem.book.client.dto.BookInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "book-info", url = "${client.book.url}")
public interface BookInfoFeignClient {

    @GetMapping
    BookInfoResponse getBookInfo(
            @RequestParam("serviceKey") String serviceKey,
            @RequestParam("pageNo") String pageNo,
            @RequestParam("numOfRows") String numOfRows
    );
}
