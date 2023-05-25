package com.example.pfecompagnemailling.Controllers;

import com.example.pfecompagnemailling.Entities.CampagneMailing;
import com.example.pfecompagnemailling.Services.CampagneMailingService.ICampagneMaillingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class CampagneMailingController {
    ICampagneMaillingService iCampagneMailingService;

    @PostMapping("/addCampagneMailing")
    public CampagneMailing addCampagneMailing(@RequestBody CampagneMailing CampagneMailing) {
        return iCampagneMailingService.addCampagneMailling(CampagneMailing);
    }

    @GetMapping("/AllCampagneMailing")
    public List<CampagneMailing> AllCampagneMailing() {
        return iCampagneMailingService.getAllCampagneMaillings();
    }

    @GetMapping("/getCampagneMailingById/{id}")
    public CampagneMailing getCampagneMailingById(@PathVariable("id") int id) {
        return iCampagneMailingService.getCampagneMaillingById(id);
    }

    @DeleteMapping("/deleteCampagneMailing/{id}")
    public void deleteCampagneMailing(@PathVariable("id") int id) {
        iCampagneMailingService.deleteCampagneMailing(id);
        ;
    }

    @PostMapping("/addCampagneMailingWithConfigAndModele")
    public CampagneMailing addCampagneMailingAndAffectModeleConfig(
            @RequestBody CampagneMailing campagneMailing) {
        return iCampagneMailingService.addCampagneMailingAndAffectModeleConfig(campagneMailing);
    }

    @PostMapping("/saveCampagneMailing")
    public CampagneMailing saveCampagneMailing(
            @RequestBody CampagneMailing campagneMailing) {
        return iCampagneMailingService.saveCampagneMailing(campagneMailing);
    }

    @PostMapping("/sendSynchronousMail")
    void sendSynchronousMail(@RequestBody CampagneMailing campagneMailing) {
        iCampagneMailingService.sendSynchronousMail(campagneMailing);
    }

    @GetMapping("/countCampagneMailings")
    public long countCampagneMailings() {
        return iCampagneMailingService.countCampagneMailings();
    }
}
