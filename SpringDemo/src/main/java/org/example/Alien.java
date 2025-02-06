package org.example;

public class Alien {
    private int codeLine;

    private Laptop laptop;

    public Alien() {
        System.out.println("Alien object created");
    }


    public void code() {
        System.out.println("Coding...");
        laptop.compile();
    }

    public int getCodeLine() {
        return codeLine;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void setCodeLine(int codeLine) {
        this.codeLine = codeLine;
    }


}
