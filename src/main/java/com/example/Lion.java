package com.example;

import java.util.ArrayList;
import java.util.List;

public class Lion {

    boolean hasMane;

    public Lion(String sex, Feline mockFeline) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    Feline feline = new Feline();

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood(String animalType) throws Exception {
        List<String> food = feline.getFood(animalType);
        List<String> additionalFood = new ArrayList<>(); // используя изменяемый список
        additionalFood.addAll(food); // добавляем все элементы из возвращаемого списка
        additionalFood.add("Еще один элемент"); // добавляем дополнительные элементы
        return additionalFood; // возвращаем изменяемый список
    }
    }



