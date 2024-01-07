package com.stable.bookrentalsystem.client.book.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookInfo(
        String no,
        @JsonProperty("bk_nm")
        String title,
        @JsonProperty("aut_nm")
        String author,
        @JsonProperty("pblshr")
        String publisher,
        @JsonProperty("pblcn_yr")
        String publishYear
) {
}
