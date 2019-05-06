package com.oushuai.animal.bean;

import java.util.List;

public class Album {
    private Integer albumId;

    private String albumName;

    private String albumUrl;
    public Album(){

}


    public Album(String albumName, String albumUrl) {
        this.albumName = albumName;
        this.albumUrl = albumUrl;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl == null ? null : albumUrl.trim();
    }
}