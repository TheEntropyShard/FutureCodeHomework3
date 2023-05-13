package me.theentropyshard.futurecodehomework3;

import java.util.ArrayList;
import java.util.List;

public class Homework7 {
    private static class Phone implements Comparable<Phone> {
        private String manufacturer;
        private String model;
        private int price;

        public Phone() {

        }

        public Phone(String manufacturer, String model, int price) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.price = price;
        }

        @Override
        public int compareTo(Phone p) {
            return this.price - p.getPrice();
        }

        @Override
        public String toString() {
            return this.manufacturer + " " + this.model + ", price: " + this.price;
        }

        public String getManufacturer() {
            return this.manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getModel() {
            return this.model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPrice() {
            return this.price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Samsung", "A51", 20000));
        phones.add(new Phone("Samsung", "S23", 50000));
        phones.add(new Phone("Samsung", "Galaxy Fold 3", 70000));
        phones.add(new Phone("BQ", "5060", 5000));
        phones.add(new Phone("Xiaomi", "Redmi 7A", 7000));
        phones.add(new Phone("Xiaomi", "A51", 20000));
        phones.add(new Phone("Nokia", "3310", 1000));

        System.out.println("Phones we have:");
        System.out.println(phones);
        System.out.println();

        List<Phone> samsungPhones = phones.stream()
                .filter(phone -> phone.getManufacturer().equals("Samsung"))
                .toList();

        System.out.println("Samsung phones:");
        System.out.println(samsungPhones);
        System.out.println();

        System.out.println("Sorted phones:");
        phones.stream()
                .sorted()
                .forEach(phone -> System.out.println(phone.getModel() + ": " + phone.getPrice()));
    }
}
