package com.oushuai.animal.bean;

import java.util.Date;

public class Photo {
    private String photoId;

    private String photoUrl;

    private Integer albumId;

    private String photoName;

    private Date photoDate;

    private String recommend;

    private Integer readtimes;

    //查询照片的同时查询相册名字
    private Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public  Photo(){

    }
    public Photo(String photoId, String photoUrl, Integer albumId, String photoName, Date photoDate, String recommend, Integer readtimes) {
        this.photoId = photoId;
        this.photoUrl = photoUrl;
        this.albumId = albumId;
        this.photoName = photoName;
        this.photoDate = photoDate;
        this.recommend = recommend;
        this.readtimes = readtimes;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public Date getPhotoDate() {
        return photoDate;
    }

    public void setPhotoDate(Date photoDate) {
        this.photoDate = photoDate;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend == null ? null : recommend.trim();
    }

    public Integer getReadtimes() {
        return readtimes;
    }

    public void setReadtimes(Integer readtimes) {
        this.readtimes = readtimes;
    }
}