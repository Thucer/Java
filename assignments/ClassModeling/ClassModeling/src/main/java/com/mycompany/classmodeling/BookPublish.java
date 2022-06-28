/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmodeling;

/**
 *
 * @author John
 */
public class BookPublish {
    private String author;
    //yearCopy represents copyright year
    private int wordCount, pageNum, yearCopy;
    
    //constructor used to initialize author value. Requirements stated that this
    //system was used by a single author, thus value is established and only read.
    public BookPublish(){
        author = "Wendell Quimbly";
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setYearCopy(int yearCopy) {
        this.yearCopy = yearCopy;
    }

    public String getAuthor() {
        return author;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getYearCopy() {
        return yearCopy;
    }
    
}
