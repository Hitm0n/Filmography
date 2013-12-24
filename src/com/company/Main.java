package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {



    private JComboBox<Author> authorJComboBox;
    private DefaultComboBoxModel<Author> defaultComboBoxModel;
    private JComboBox<Film> filmJComboBox;
    private DefaultComboBoxModel<Film> productComboBoxModel;

    public Main() {
        buildGUI();

    }

    public void buildGUI() {
        JFrame frame = new JFrame("Filmography");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        Box authorBox = new Box(BoxLayout.X_AXIS);
        Box showBox = new Box(BoxLayout.X_AXIS);
        Box filmBox = new Box(BoxLayout.X_AXIS);

        JButton authorButton = new JButton("Create Author");
        authorButton.addActionListener(new CreateAuthorListener());
        JButton showAllProducts = new JButton("Show Author's Films");
        showAllProducts.addActionListener(new ShowAllFilmsListener());
        JButton productButton = new JButton("Create Film");
        productButton.addActionListener(new CreateProductListener());

        authorBox.add(authorButton);
        showBox.add(showAllProducts);
        filmBox.add(productButton);
        mainBox.add(showBox);
        mainBox.add(new JLabel(" "));

        Box cartBox = new Box(BoxLayout.X_AXIS);

        cartBox.add(new JLabel("Film's Author: "));
        authorJComboBox = new JComboBox<Author>();
        defaultComboBoxModel = new DefaultComboBoxModel<Author>(Author.getAuthors());
        authorJComboBox.setModel(defaultComboBoxModel);
        cartBox.add(authorJComboBox);
        JButton cartButton = new JButton("Create Filmography and bind");
        cartButton.addActionListener(new CreateCartListener());
        cartBox.add(cartButton);
        mainBox.add(cartBox);

        Box productBox = new Box(BoxLayout.X_AXIS);

        JButton bindButton = new JButton("Add to Filmography");
        productBox.add(new JLabel("Films: "));
        bindButton.addActionListener(new AddToCartListener());
        filmJComboBox = new JComboBox<Film>();
        productComboBoxModel = new DefaultComboBoxModel<Film>(Film.getFilms());
        filmJComboBox.setModel(productComboBoxModel);
        filmJComboBox.setSize(new Dimension(250, filmJComboBox.getHeight()));
        productBox.add(filmJComboBox);
        productBox.add(bindButton);

        mainBox.add(productBox);
        mainBox.add(new JLabel(" "));
        mainBox.add(authorBox);
        mainBox.add(filmBox);

        frame.setSize(500,270);
        frame.getContentPane().add(mainBox);
        frame.setVisible(true);
    }

    private class CreateAuthorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dialogs.createAuthor();
            authorJComboBox.updateUI();
        }
    }

    private class CreateCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Author author = (Author) authorJComboBox.getSelectedItem();
            try {
                author.setCart(new Cart());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Author not selected");
            }
        }
    }

    private class CreateProductListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Dialogs.createFilm();
            filmJComboBox.updateUI();
        }
    }

    private class AddToCartListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Author author = (Author) authorJComboBox.getSelectedItem();
            try {
                author.getCart().addFilm((Film) filmJComboBox.getSelectedItem());
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Film not selected or filmography don't initialize");
            }
        }
    }

    private class ShowAllFilmsListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Author author = (Author) authorJComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, author.getCart().getAllFilms(), "Films of " + author.getName(),  JOptionPane.PLAIN_MESSAGE);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Filmography don't initialize");
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
