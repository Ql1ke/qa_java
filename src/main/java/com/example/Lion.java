package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    Feline feline = new Feline(); //нужно применить DI - инъекцию зависимости для разделения класса LION от FELINE.
//     47-я минута вебинара от 10.03

/*
    private Predator predator;
    public void setPredator(Predator predator) {
        this.predator = predator;
    }
*/

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
