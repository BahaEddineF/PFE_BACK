package com.example.pfecompagnemailling.Services.ModeleService;

import com.example.pfecompagnemailling.Entities.Modele;
import com.example.pfecompagnemailling.Repository.ModeleRepository;
import com.example.pfecompagnemailling.Services.ConfigurationService.IConfigurationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModeleService implements IModeleService {
    public ModeleRepository modeleRepository;
    @Override
    public Modele addModele(Modele modele) {
        return modeleRepository.save(modele);
    }

    @Override
    public Modele updateModele(Modele modele) {
        return  modeleRepository.save(modele);
    }

    @Override
    public List<Modele> getAllModeles() {
        return modeleRepository.findAll();
    }

    @Override
    public Modele getModeleById(int id) {
        return modeleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteModele(int id) {
        modeleRepository.deleteById(id);
    }
}
