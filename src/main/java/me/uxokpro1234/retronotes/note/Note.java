package me.uxokpro1234.retronotes.note;

public class Note {
    public String title;
    public String content;

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

    //Overrode outut to get String instead of class.
    @Override
    public String toString() {
        return "Title: " + title + " Content: " + content;
    }
}