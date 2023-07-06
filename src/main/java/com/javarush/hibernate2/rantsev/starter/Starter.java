package com.javarush.hibernate2.rantsev.starter;

import com.javarush.hibernate2.rantsev.creators.CustomerCreator;
import com.javarush.hibernate2.rantsev.creators.FilmCreator;
import com.javarush.hibernate2.rantsev.creators.InventoryCreator;
import com.javarush.hibernate2.rantsev.domains.Customer;

public class Starter {
    private final FilmCreator filmCreator;
    private final CustomerCreator customerCreator;
    private final InventoryCreator inventoryCreator;

    public Starter(FilmCreator filmCreator, CustomerCreator customerCreator, InventoryCreator inventoryCreator) {
        this.filmCreator = filmCreator;
        this.customerCreator = customerCreator;
        this.inventoryCreator = inventoryCreator;
    }

    public void execute() {
        for(int i = 0; i < 100; i++) {
            newFilmWasMade();
            createCustomer();
            customerRentInventory(getRandomCustomer());
            returnInventoryToStore();
        }
    }

    private void newFilmWasMade() {
        filmCreator.newFilmWasMade();
    }

    private void createCustomer() {
        customerCreator.createCustomer();
    }

    private Customer getRandomCustomer() {
        return customerCreator.getRandomCustomer();
    }

    private void customerRentInventory(Customer customer) {
        inventoryCreator.customerRentInventory(customer);
    }

    private void returnInventoryToStore() {
        inventoryCreator.returnInventoryToStore();
    }
}
