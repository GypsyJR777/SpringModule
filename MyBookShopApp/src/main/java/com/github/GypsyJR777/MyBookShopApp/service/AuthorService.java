package com.github.GypsyJR777.MyBookShopApp.service;

import com.github.GypsyJR777.MyBookShopApp.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorsData() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int row) -> {
            Author author = new Author();

            author.setId(rs.getInt("id"));
            author.setAuthor(rs.getString("author"));

            return author;
        });

        return new ArrayList<>(authors);
    }

    public Map<String, List<Author>> getMapAuthorsAndFirstLetters() {
        List<Author> authors = getAuthorsData();

        Map<String, List<Author>> fLettersAuthors = new HashMap<>();

        authors.forEach(author -> {
            if (fLettersAuthors.containsKey(author.getFirstLetter())){
                fLettersAuthors.get(author.getFirstLetter()).add(author);
            } else {
                List<Author> a = new ArrayList<>();
                a.add(author);
                fLettersAuthors.put(author.getFirstLetter(), a);
            }
        });

        return fLettersAuthors;
    }
}
