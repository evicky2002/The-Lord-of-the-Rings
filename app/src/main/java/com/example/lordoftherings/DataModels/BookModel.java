package com.example.lordoftherings.DataModels;

import java.util.ArrayList;

public class BookModel {
    private String id;
    private String name;
    private String totalChapters;
    private ArrayList<String> chapters;

    public BookModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getTotalChapters() {
        return totalChapters;
    }

    public void setTotalChapters(String totalChapters) {
        this.totalChapters = totalChapters;
    }

    public ArrayList<String> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<String> chapters) {
        this.chapters = chapters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
