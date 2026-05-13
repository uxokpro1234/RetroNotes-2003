package me.uxokpro1234.retronotes.note;

import java.util.ArrayList;

public class NoteManager {
    private ArrayList<Note> notes;

    public NoteManager(){
        notes = new ArrayList<>();
    }


    public void addNote(Note note){
        notes.add(note);
    }

    public void removeNote(int index){
        notes.remove(index);
    }

    public ArrayList<Note> getNotes(){
        return notes;
    }

    public Note findByTitle(String title) {
        for(int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if(note.title.equals(title)){
                return note;
            }
        }
        return null;
    }
}