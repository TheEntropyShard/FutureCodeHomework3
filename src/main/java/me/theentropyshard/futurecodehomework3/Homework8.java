package me.theentropyshard.futurecodehomework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Homework8 {
    private static class Address {
        private String city;
        private String region;

        public Address() {

        }

        public Address(String city, String region) {
            this.city = city;
            this.region = region;
        }

        public String getCity() {
            return this.city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getRegion() {
            return this.region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }

    private static class Student {
        private final String name;
        private final Optional<Address> address;

        public Student(String name) {
            this.name = name;
            this.address = Optional.empty();
        }

        public Student(String name, Address address) {
            this.name = name;
            this.address = Optional.of(address);
        }

        public String getName() {
            return this.name;
        }

        public Optional<Address> getAddress() {
            return this.address;
        }
    }

    private static void printStudentInfo(Student student) {
        Optional<Address> optionalAddress = student.getAddress();
        Address address = optionalAddress.orElse(null);
        String strAddress = "";
        if(address != null) {
            strAddress = " lives in " + address.getCity() + " " + address.getRegion();
        }
        System.out.println("Student " + student.getName() + strAddress);
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Student petya = new Student("Petya");
        Student masha = new Student("Masha");

        Student vasiliy = new Student("Vasiliy", new Address("Moscow", "Moscow City"));
        Student alexander = new Student("Alexander", new Address("Belgorod", "Sputnik"));

        printStudentInfo(petya);
        printStudentInfo(masha);
        printStudentInfo(vasiliy);
        printStudentInfo(alexander);

        System.out.println();

        List<String> randomWords = new ArrayList<>();
        randomWords.add("Apple");
        randomWords.add("House");
        randomWords.add("Car");
        randomWords.add("Work");
        randomWords.add("Keyboard");
        randomWords.add("Run");
        randomWords.add("Break");

        String sentence = randomWords.stream()
                .reduce((s, s2) -> s + " " + s2)
                .orElse("Empty sentence");

        System.out.println("Original:");
        System.out.println(randomWords);
        System.out.println();

        System.out.println("Sentence:");
        System.out.println(sentence);
    }
}
