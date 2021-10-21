package edu.eci.arsw.Model;

import java.util.ArrayList;
import java.util.HashSet;

public class Room {

    private ArrayList<User> Users;
    private int Id;
    private HashSet<String> Dictonary;
    private String ActualWord;

    public void setUsers(ArrayList<User> users) {
        Users = users;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setDictonary(HashSet<String> dictonary) {
        Dictonary = dictonary;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public int getId() {
        return Id;
    }

    public HashSet<String> getDictonary() {
        return Dictonary;
    }

    public String getActualWord() {
        return ActualWord;
    }

    public void setActualWord(String actualWord) {
        ActualWord = actualWord;
    }
}
