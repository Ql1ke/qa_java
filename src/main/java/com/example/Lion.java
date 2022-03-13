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
    DI через метод Set (сеттер)
    private Predator predator;
    public void setPredator(Predator predator) {
        this.predator = predator;
    }

    DI через конструктор
    private Predator predator;
    public Lion(Predator predator) {
        this.predator = predator;
    }
*/


/*
* НО Class Feline наследет не интерфейс Predator, а класс Animal. Поэтому надо создать переменную с типом класса
* Animal и брать метод getFood уже из класса Animal.
*
* private Animal food;
* public Lion(Animal food) {
*   this.animal = food;
* }

/*
     private Animal food;
     public Lion(Animal food) {
        this.food = food;
     }

     public List<String> getFood() throws Exception {
         return food.getFood("Хищник");
     }
*/

//    private Feline feline;

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
