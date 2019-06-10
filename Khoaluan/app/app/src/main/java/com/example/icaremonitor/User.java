package com.example.icaremonitor;

public class User {
    private String Value;
    private String Time;
    private String Note;

    public User(String value, String time, String note){
        this.setValue(value);
        this.setTime(time);
        this.setNote(note);

    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String ex) {
        Note = ex;
    }

}