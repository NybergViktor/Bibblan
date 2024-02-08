package com.bibblan.bibblan.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BorrowedBooks {

    @Id
    private String id;
    private String userId;

    private List<String> bookId = new ArrayList<>();
    @CreatedDate
    private Date createdAt = new Date();

    private String returningDate = addToCurrentDate();


    public BorrowedBooks() {
        createdAt = getCreatedAt();
        returningDate = getReturningDate();
    }
    public static String addToCurrentDate(){

        DateFormat dateFormat = new SimpleDateFormat();

        Calendar calendarInstance = Calendar.getInstance();
        calendarInstance.add(Calendar.MONTH, 1);
        return dateFormat.format(calendarInstance.getTime());
    }




    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(String returningDate) {
        this.returningDate = returningDate;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getBookId() {
        return bookId;
    }

    public void setBookId(List<String> bookId) {
        this.bookId = bookId;
    }
}
