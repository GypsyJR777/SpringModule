package org.example.web.entity;

import javax.validation.constraints.NotNull;

public class BookRegexToRemove {
    @NotNull
    private String regex;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
