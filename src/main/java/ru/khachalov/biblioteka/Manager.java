package ru.khachalov.biblioteka;

public class Manager extends Library {
    private boolean statusLib = false;
    public void closeLib(){
        statusLib = false;
    }
    public void openLib(){
        statusLib = true;
    }
    public boolean getStatusLib(){
        return statusLib;
    }
}
