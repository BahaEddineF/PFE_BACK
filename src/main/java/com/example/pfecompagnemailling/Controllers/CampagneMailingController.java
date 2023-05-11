package com.example.pfecompagnemailling.Controllers;


import com.example.pfecompagnemailling.Entities.CampagneMailing;
import com.example.pfecompagnemailling.Services.CampagneMailingService.ICampagneMaillingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CampagneMailingController {
    ICampagneMaillingService iCampagneMailingService;

    @PostMapping("/addCampagneMailing")
    public CampagneMailing addCampagneMailing(@RequestBody CampagneMailing CampagneMailing){
        return iCampagneMailingService.addCampagneMailling(CampagneMailing)  ;
    }

    @PutMapping("/updateCampagneMailing")
    public CampagneMailing updateCampagneMailing(@RequestBody CampagneMailing CampagneMailing){
        return iCampagneMailingService.updateCampagneMailling(CampagneMailing)  ;
    }

    @GetMapping("/AllCampagneMailing")
    public List<CampagneMailing> AllCampagneMailing(){
        return iCampagneMailingService.getAllCampagneMaillings()  ;
    }

    @GetMapping("/getCampagneMailingById/{id}")
    public CampagneMailing getCampagneMailingById(@PathVariable("id") int id){
        return iCampagneMailingService.getCampagneMaillingById(id)  ;
    }

    @DeleteMapping("/deleteCampagneMailing/{id}")
    public void deleteCampagneMailing(@PathVariable("id") int id){
        iCampagneMailingService.deleteCampagneMailing(id);  ;
    }

    @PostMapping("/addCampagneMailingWithConfigAndModele")
    public CampagneMailing addCampagneMailingAndAffectModeleConfig(
                                                                   @RequestBody CampagneMailing campagneMailing) {
     return iCampagneMailingService.addCampagneMailingAndAffectModeleConfig(campagneMailing)   ;
    }

    @PostMapping("/addCampagneMailingWithConfigAndModeleAndPlanification")
    public CampagneMailing addCampagneMailingWithConfigAndModeleAndPlanification(
                                                                   @RequestBody CampagneMailing campagneMailing) {
        return iCampagneMailingService.addCampagneMailingWithConfigAndModeleAndPlanification(campagneMailing)   ;
    }
}
