package com.oushuai.animal.bean;

public class New {
    private Integer newId;

    private String newTitle;

    private String newContent;

    private String newPhotoId1;

    private String newPhotoId2;

    private String newPhotoId3;

    private String newKeyWords;

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle == null ? null : newTitle.trim();
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent == null ? null : newContent.trim();
    }

    public String getNewPhotoId1() {
        return newPhotoId1;
    }

    public void setNewPhotoId1(String newPhotoId1) {
        this.newPhotoId1 = newPhotoId1 == null ? null : newPhotoId1.trim();
    }

    public String getNewPhotoId2() {
        return newPhotoId2;
    }

    public void setNewPhotoId2(String newPhotoId2) {
        this.newPhotoId2 = newPhotoId2 == null ? null : newPhotoId2.trim();
    }

    public String getNewPhotoId3() {
        return newPhotoId3;
    }

    public void setNewPhotoId3(String newPhotoId3) {
        this.newPhotoId3 = newPhotoId3 == null ? null : newPhotoId3.trim();
    }

    public String getNewKeyWords() {
        return newKeyWords;
    }

    public void setNewKeyWords(String newKeyWords) {
        this.newKeyWords = newKeyWords == null ? null : newKeyWords.trim();
    }
}