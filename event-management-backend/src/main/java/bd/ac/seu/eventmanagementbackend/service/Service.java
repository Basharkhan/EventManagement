package bd.ac.seu.eventmanagementbackend.service;

import bd.ac.seu.eventmanagementbackend.model.GeneralEvent;
import bd.ac.seu.eventmanagementbackend.model.SpecialEvent;
import bd.ac.seu.eventmanagementbackend.repository.GeneralEventRepo;
import bd.ac.seu.eventmanagementbackend.repository.SpecialEventRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    GeneralEventRepo generalEventRepo;

    @Autowired
    SpecialEventRepo specialEventRepo;

    public List<GeneralEvent> getAllGeneralEvent(){
        return generalEventRepo.findAll();
    }

    public List<SpecialEvent> getAllSpecialEvent(){
        return specialEventRepo.findAll();
    }

    public GeneralEvent addGeneralEvent(String name, String description, String date){
        return generalEventRepo.save(new GeneralEvent(name, description, date));
    }

    public SpecialEvent addSpecialEvent(String name, String description, String date){
        return specialEventRepo.save(new SpecialEvent(name, description, date));
    }

}
