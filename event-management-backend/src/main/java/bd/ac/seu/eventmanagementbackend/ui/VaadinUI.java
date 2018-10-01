package bd.ac.seu.eventmanagementbackend.ui;


import bd.ac.seu.eventmanagementbackend.model.GeneralEvent;
import bd.ac.seu.eventmanagementbackend.service.Service;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringUI(path = "/admin-panel")
public class VaadinUI extends UI{

    @Autowired
    Service service;

    private VerticalLayout verticalLayout;
    private FormLayout formLayout;
    private TextField nameField;
    private TextField desField;
    private TextField dateField;

    List<GeneralEvent> generalEventList;
    Grid<GeneralEvent> generalEventGrid;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        verticalLayout = new VerticalLayout();
        this.setContent(verticalLayout);

        formLayout = new FormLayout();
        verticalLayout.addComponent(formLayout);

        formLayout.setCaption("General Event");
        generalEventList = service.getAllGeneralEvent();
        generalEventGrid = new Grid<>();
        verticalLayout.addComponent(generalEventGrid);
        generalEventGrid.setItems(generalEventList);

        generalEventGrid.setSizeFull();
        generalEventGrid.getIcon();
        generalEventGrid.addColumn(GeneralEvent::getName).setCaption("Event's Name").setWidth(200);
        generalEventGrid.addColumn(GeneralEvent::getDescription).setCaption("description").setWidth(300);
        generalEventGrid.addColumn(GeneralEvent::getDate).setCaption("Date").setWidth(200);

    }
}
