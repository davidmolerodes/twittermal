package org.dis.front;

import javax.servlet.annotation.WebServlet;

import back.Tweet;
import back.Tweets;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.ocpsoft.prettytime.PrettyTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Tweets lista = new Tweets();
        Grid<Tweet> grid = new Grid<>();
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField nombre = new TextField("Nombre:");
        final TextArea mensaje = new TextArea("Mensaje:");
        mensaje.setHeight("150px");

        Button button = new Button("Click Me");

        PrettyTime p = new PrettyTime();
        Date date = new Date();

        button.addClickListener(e -> {
            Tweet t = new Tweet(nombre.getValue(), mensaje.getValue(), p.format(date));
            if(t.comprobar(mensaje.getValue()) == true) {
                lista.create(t);
                layout.addComponent(new Label("Tweet N" + lista.getNum()
                        + ", it works!"));

                grid.setItems(lista.getTweets());
            }

        });


        // grid.setItems(lista.getTweets());
        grid.setWidth("800px");
        grid.addColumn(Tweet::getNombre).setCaption("Nombre").setWidth(100);; //Columns created del grid
        grid.addColumn(Tweet::getMensaje).setCaption("Mensaje").setWidth(400);
        grid.addColumn(Tweet::getFecha).setCaption("Fecha").setWidth(200); //Columns created del grid
        grid.addComponentColumn(item -> new Button("Delete", clickEvent -> {
            lista.delete(item.getNombre());
            grid.setItems(lista.getTweets());
        })).setWidth(100);

        layout.addComponents(nombre, mensaje, button);
        layout.addComponent(grid);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
