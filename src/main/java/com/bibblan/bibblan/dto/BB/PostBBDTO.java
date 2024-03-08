package com.bibblan.bibblan.dto.BB;

import com.bibblan.bibblan.models.Books;

import java.util.ArrayList;
import java.util.List;

public class PostBBDTO {
    private String userId;
    private List<Books> bookList = new ArrayList<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public List<Books> getBookList() {
        return bookList;
    }

    public void setBookList(List<Books> bookList) {
        this.bookList = bookList;
    }
}
