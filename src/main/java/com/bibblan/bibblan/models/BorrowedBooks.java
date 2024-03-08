package com.bibblan.bibblan.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BorrowedBooks {

    @Id
    private String id; //Vårt id som vi sedan kan använda som reference
    @DBRef
    private Users userId;  //userId reference

    private List<Books> bookId = new ArrayList<>(); //Should be able to borrow multiple books per list, valde därför att lägga dessa i en ArrayList
    @CreatedDate
    private Date createdAt = new Date();

    private String returningDate = addToCurrentDate(); //se rad 29



    public BorrowedBooks() {
        createdAt = getCreatedAt();//lägger in createdAt i kontruktorn för den ska sättas automatiskt. Samma med returningDate
        returningDate = getReturningDate();
    }

    //jag ville ha att en låningsperiod som standard är 1 månad, metoden nedan hämtar nuvarande datum i calendar och lägger på en månad.
    //detta blir sedan returningDate. MEN man kan ändra returningdate via en update i Postman om man vill ha något annat än 30 dagar
    public static String addToCurrentDate(){

        DateFormat dateFormat = new SimpleDateFormat();

        Calendar calendarInstance = Calendar.getInstance();
        calendarInstance.add(Calendar.MONTH, 1);
        return dateFormat.format(calendarInstance.getTime());
    }




    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
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

    public List<Books> getBookId() {
        return bookId;
    }

    public void setBookId(List<Books> bookId) {
        this.bookId = bookId;
    }
}
