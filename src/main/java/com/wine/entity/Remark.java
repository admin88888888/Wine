package com.wine.entity;

public class Remark {
    private Integer id;

    private Integer liquorid;

    private Float score;

    private String content;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLiquorid() {
        return liquorid;
    }

    public void setLiquorid(Integer liquorid) {
        this.liquorid = liquorid;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}