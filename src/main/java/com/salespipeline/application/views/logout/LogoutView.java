package com.salespipeline.application.views.logout;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
@Route("logout")
@PageTitle("Logout")
public class LogoutView extends Composite<VerticalLayout> {

    public LogoutView() {
        Notification.show("You're successful logged out."); //ist zu sehen, aber nur ganz kurz, weil direkt zum login weitergeleitet wird

        UI.getCurrent().getPage().setLocation("login"); //schickt den Nutzer wieder zum Login
        VaadinSession.getCurrent().getSession().invalidate(); //Invalidate: Kannst nicht mit "zurück" wieder reinspringen
        VaadinSession.getCurrent().close(); //Close Session - Anwendung läuft aber weiter. -> Aktivierungen sind trotzdem noch available.

        }

}
