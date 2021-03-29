package com.salespipeline.application.views.login;

import com.salespipeline.application.data.service.AuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;


@Route(value = "login")
@PageTitle("Salespipeline Login")
@CssImport("./styles/views/login/login-view.css")
//Route Alias -> Start des Localhost auf der Loginseite trotz Development Mode im Browser
@RouteAlias(value = "")
public class LoginView extends Div {
//Login Username ,Password
    public LoginView(AuthService authService) {
        setId("login-view");
        var username = new TextField("Username");
        var password = new PasswordField("Password");

        add(
                new Image("images/SalespipelineLogo.png", "Salespipeline Logo"),
                new H1("Salespipeline"),
                new H3("by Tim Muscholl Enterprises Business Solutions"),
                new H4("Version 1.0"),
                username,
                password,
                new Button("Login", event -> {
                    try {
                        authService.authenticate(username.getValue(), password.getValue()); //Passwort abfragen -> Noch nicht aktivierte Accounts sind nicht gespeichert
                        //und können daher nicht genutzt werden.
                        UI.getCurrent().navigate("home");
                    } catch (AuthService.AuthException e) {
                        Notification.show("Nice try. Please enter valid credentials");
                    }
                }));
               // new RouterLink("Nutzer registrieren", RegisterView.class)); //Kann noch auskommentiert werden, wenn user von admins angelegt werden
                //oder die Rollen User und Admin nutzen.
              //add( new RouterLink("Admin registrieren", ARegisterView.class)); //Routerlink zur Admin registrieren

    }

}
