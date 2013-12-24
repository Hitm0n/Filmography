package com.company;


import java.util.Vector;

public class Author {

    private String name;
    private String country;
    private int age;
    private boolean gender;

    private static Vector<Author> authors = new Vector<Author>();

    private Cart cart;

    public Author(String name, String country, int age, boolean gender) {
        this.country = country;
        this.age = age;
        this.gender = gender;
        addAuthor(this);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) throws Exception {
        if (this.cart == null) {
            this.cart = cart;
        } else {
        }
    }

    public static boolean addAuthor(Author author) {
        return authors.add(author);
    }

    public static Vector<Author> getAuthors() {
        return authors;
    }

    public static Author removeAuthor(int index) {
        return authors.remove(index);
    }

    public static boolean removeAuthor(Author author) {
        return authors.remove(author);
    }

    @Override
    public String toString() {
        return name;
    }
}
