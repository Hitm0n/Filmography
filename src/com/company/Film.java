package com.company;

import java.util.Vector;

public class Film {

    private String title;
    private int year;

    private static Vector<Film> films = new Vector<Film>();

    public Film(String title, int year, int budget) {
        this.year = year;
        this.budget = budget;
        addFilm(this);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static boolean addFilm(Film film) {
        return films.add(film);
    }

    public static Vector<Film> getFilms() {
        return films;
    }

    public static Film removeFilm(int index) {
        return films.remove(index);
    }

    public static boolean removeFilm(Film film) {
        return films.remove(film);
    }

    @Override
    public String toString() {
        return title;
    }
}
