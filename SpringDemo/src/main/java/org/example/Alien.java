package org.example;

public class Alien {
    private int codeLine;

    public Alien() {
        System.out.println("Alien object created");
    }


    public void code() {
        System.out.println("Coding...");
    }

    public int getCodeLine() {
        return codeLine;
    }
    public void setCodeLine(int codeLine) {
        this.codeLine = codeLine;
    }
}
