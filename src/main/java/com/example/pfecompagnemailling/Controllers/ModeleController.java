package com.example.pfecompagnemailling.Controllers;


import com.example.pfecompagnemailling.Entities.Modele;
import com.example.pfecompagnemailling.Services.ModeleService.IModeleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ModeleController {
    IModeleService iModeleService;

    @PostMapping("/addModele")
    public Modele addModele(@RequestBody Modele Modele){
        return iModeleService.addModele(Modele)  ;
    }

    @PutMapping("/updateModele")
    public Modele updateModele(@RequestBody Modele Modele){
        return iModeleService.updateModele(Modele)  ;
    }

    @GetMapping("/AllModele")
    public List<Modele> AllModele(){
        return iModeleService.getAllModeles()  ;
    }

    @GetMapping("/getModeleById/{id}")
    public Modele getModeleById(@PathVariable("id") int id){
        return iModeleService.getModeleById(id)  ;
    }

    @DeleteMapping("/deleteModele/{id}")
    public void deleteModele(@PathVariable("id") int id){
        iModeleService.deleteModele(id);  ;
    }
}
