package com.realdolmen;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Evelyne on 08/07/15.
 */

@Title("Hello, world")
@Theme("valo")
@Widgetset("com.realdolmen.helloworld.MyAppWidgetset")  //zie in resources
public class HelloWorld extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();

        //add text
        Label label = new Label("Hello!");
        layout.addComponent(label);

        //set margins
        layout.setMargin(true);

        //add a button
        Button button = new Button("Push me!");
        //click-handler Java 7 (anonymous innerclass)
//        button.addClickListener(new Button.ClickListener() {
//                                                 @Override
//                                                 public void buttonClick(Button.ClickEvent clickEvent) {
//                                                     Notification.show("you clicked!");
//                                                 }
//                                             }
//        );

        //click)handler java 8 (gaat gewoon met rechterklik- replace with lambda expression)
        button.addClickListener(clickEvent -> Notification.show("you clicked!"));
        layout.addComponent(button);

        setContent(layout);

    }




    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = HelloWorld.class)  //doet al het werk, je moet wel zeggen welke ui de clientside moet inladen
    public static class Servlet extends VaadinServlet   {

    }
}
