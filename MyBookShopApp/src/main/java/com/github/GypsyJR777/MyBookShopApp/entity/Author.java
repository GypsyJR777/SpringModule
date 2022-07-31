package com.github.GypsyJR777.MyBookShopApp.entity;

public class Author {
    private Integer id;
    private String author;
    private String firstLetter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        setFirstLetter(author.substring(0, 1));
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                '}';
    }
}
