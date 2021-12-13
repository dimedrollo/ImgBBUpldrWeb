package ru.dimedrollo;


import java.util.*;


public class Hometask08 {

    //Creating a Person class that implements the Comparable interface
    public static class Person implements Comparable<Person> {
        private String name;
        private Float weight;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getWeight() {
            return weight;
        }

        public void setWeight(Float weight) {
            this.weight = weight;
        }

        // Add a constructor
        public Person(String name, Float weight) {
            this.name = name;
            this.weight = weight;
        }

        //Adding the implementation of the interface method - the ability to compare Person objects by the weight parameter
        @Override
        public int compareTo(Person h) {
            return weight.compareTo(h.getWeight());
        }
    }

    public static void main(String[] args) {
        //Creating an array of 10 elements and a scanner to read data from the input
        Person[] personArray = new Person[10];
        Scanner scanner = new Scanner(System.in);
        //Filling the array with Person objects
        for (int i = 0; i < personArray.length; i++) {
            //If incorrect data is being entered, we replace it with zero
            personArray[i] = new Person(scanner.next(), scanner.hasNextFloat() ? scanner.nextFloat() : 0);
        }
        //Sorting an array of Person objects
        Arrays.sort(personArray);
        //Output a line-by-line sorted array of objects
        for (Person p : personArray) {
            System.out.println(p.getName() + " " + p.getWeight());
        }
    }
}


