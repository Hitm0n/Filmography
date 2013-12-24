package com.company;

import java.util.Vector;

public class Cart {

    private Vector<Film> films = new Vector<Film>();

    public Vector<Film> getFilms() {
        return films;
    }


    public int calculateBudget() {
        for (Film product : films) {
            budget += product.getBudget();
        }
        return budget;
    }

    public int calculateYear() {
        int year = 0;
        for (Film film : films) {
            year = film.getYear();
        }
        return year;
    }

    public boolean addFilm(Film film) {
        if (film == null) {
            throw new NullPointerException();
        }
        return films.add(film);
    }

    public Film getFilm(int index) {
        return films.get(index);
    }

    public void setFilms(Vector<Film> films) {
        this.films = films;
    }

    public String getAllFilms() {
        String s = "";
        for (Film film : films) {
            s += film + ", ";
        }
        s += "\nAll budget: " + calculateBudget() + "\nLast year: " + calculateYear() ;
        return s;
    }
}
