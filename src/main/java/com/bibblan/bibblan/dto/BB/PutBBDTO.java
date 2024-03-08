package com.bibblan.bibblan.dto.BB;

import com.bibblan.bibblan.models.Books;

import java.util.ArrayList;
import java.util.List;

public class PutBBDTO {
    private String id;
    private String userId;
    private List<Books> bookList = new ArrayList<>();



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Books> getBookList() {
        return bookList;
    }

    public void setBookList(List<Books> bookList) {
        this.bookList = bookList;
    }
}
