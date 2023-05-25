package com.example.pfecompagnemailling.Controllers;

import com.example.pfecompagnemailling.Entities.Planification;
import com.example.pfecompagnemailling.Services.PlanificationService.IPlanificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlanificationController {
    IPlanificationService iPlanificationService;

    @PostMapping("/addPlanification")
    public Planification addPlanification(@RequestBody Planification Planification) {
        return iPlanificationService.addPlanification(Planification);
    }

    @PutMapping("/updatePlanification")
    public Planification updatePlanification(@RequestBody Planification Planification) {
        return iPlanificationService.updatePlanification(Planification);
    }

    @GetMapping("/AllPlanification")
    public List<Planification> AllPlanification() {
        return iPlanificationService.getAllPlanifications();
    }

    @GetMapping("/getPlanificationById/{id}")
    public Planification getPlanificationById(@PathVariable("id") int id) {
        return iPlanificationService.getPlanificationById(id);
    }

    @DeleteMapping("/deletePlanification/{id}")
    public void deletePlanification(@PathVariable("id") int id) {
        iPlanificationService.deletePlanification(id);
    }
}
