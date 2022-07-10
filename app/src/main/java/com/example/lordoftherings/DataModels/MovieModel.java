package com.example.lordoftherings.DataModels;

public class MovieModel {
    private String name;
    private String id;
    private String runtimeInMinutes;

    public MovieModel(String name, String id, String runtimeInMinutes) {
        this.name = name;
        this.id = id;
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public String getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(String runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
