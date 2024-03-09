package com.bibblan.bibblan.dto.BB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostBBDTO {
    private String userId;
    private List<String> bookList = new ArrayList<>();
    private Date createdAt = new Date();

    private String returningDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public List<String> getBookList() {
        return bookList;
    }

    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(String returningDate) {
        this.returningDate = returningDate;
    }
}
