package com.group07.buildabackend.backend.dto.documentDTO;


import com.group07.buildabackend.backend.dto.DTO;

public class DocumentDTO implements DTO {
    private String id;
    private String title;

    private String url;

    public DocumentDTO(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public DocumentDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
