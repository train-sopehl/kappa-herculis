package com.herculis.tags;

import com.herculis.html.HtmlFormats;

public class Input {

    private String type;

    private String name;

    private String value;

    public Input() {
    }

    public Input(String name, String value) {
        this.type = "hidden";
        this.name = name;
        this.value = value;
    }

    public Input(String type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(HtmlFormats.DEFAULT_INPUT_FORMAT, this.type, this.name, this.value);
    }
}
