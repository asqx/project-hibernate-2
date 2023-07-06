package com.javarush.hibernate2.rantsev;

import com.javarush.hibernate2.rantsev.creators.CustomerCreator;
import com.javarush.hibernate2.rantsev.creators.FilmCreator;
import com.javarush.hibernate2.rantsev.creators.InventoryCreator;
import com.javarush.hibernate2.rantsev.starter.Starter;

public class Runner {
    public static void main(String[] args) {
        FilmCreator filmCreator = new FilmCreator();
        CustomerCreator customerCreator = new CustomerCreator();
        InventoryCreator inventoryCreator = new InventoryCreator();
        Starter starter = new Starter(filmCreator, customerCreator, inventoryCreator);
        starter.execute();
    }
}
