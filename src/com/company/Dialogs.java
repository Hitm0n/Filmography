package com.company;

import javax.swing.*;

public class Dialogs {
    public static Author createAuthor() {
        JTextField name = new JTextField();
        JTextField country = new JTextField();
        JTextField age = new JTextField();
        JComboBox<String> gender = new JComboBox<String>(new String[]{"M", "W"});
        final JComponent[] inputs = new JComponent[] {
            new JLabel("Name: "), name,
            new JLabel("Country: "), country,
            new JLabel("Age: "), age,
            new JLabel("Gender"), gender
        };
        JOptionPane.showMessageDialog(null, inputs, "Add Author", JOptionPane.PLAIN_MESSAGE);
        return new Author(name.getText(), country.getText(), Integer.parseInt(age.getText()), (gender.getSelectedItem().toString().equals("M")));
    }

    public static Film createFilm() {
        JTextField title = new JTextField();
        JTextField year = new JTextField();
        JTextField budget = new JTextField();
        final JComponent[] inputs = new JComponent[] {
                new JLabel("Title: "), title,
                new JLabel("Year: "), year,
                new JLabel("Budget: "), budget
        };
        JOptionPane.showMessageDialog(null, inputs, "Add Film", JOptionPane.PLAIN_MESSAGE);
        return new Film(title.getText(), Integer.parseInt(year.getText()), Integer.parseInt(budget.getText()));
    }
}
