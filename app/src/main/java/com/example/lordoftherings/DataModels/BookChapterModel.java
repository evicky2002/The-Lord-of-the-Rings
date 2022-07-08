package com.example.lordoftherings.DataModels;

import java.util.List;

public class BookChapterModel {
    private List<String> chapters;

    public BookChapterModel( List<String> chapters) {
        this.chapters = chapters;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }
}
