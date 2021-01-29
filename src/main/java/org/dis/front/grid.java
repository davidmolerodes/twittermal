package org.dis.front;

import back.Tweet;
import back.Tweets;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.time.LocalDate;

public class grid extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Tweets lista = new Tweets();
        final VerticalLayout layout = new VerticalLayout();

        Grid<Tweet> grid = new Grid<>();
        grid.setItems(lista.getTweets());//binding the data

        grid.addColumn(Tweet::getNombre).setCaption("Titulo"); //Columns created del grid
        grid.addColumn(Tweet::getMensaje).setCaption("Genero").setWidth(150);
        grid.addColumn(Tweet::getFecha).setCaption("Fecha"); //Columns created del grid

        layout.addComponent(grid);
        setContent(layout);
    }
}
