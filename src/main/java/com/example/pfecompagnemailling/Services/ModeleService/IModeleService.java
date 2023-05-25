package com.example.pfecompagnemailling.Services.ModeleService;

import com.example.pfecompagnemailling.Entities.Modele;

import java.util.List;

public interface IModeleService {
    public Modele addModele(Modele Modele);

    public Modele updateModele(Modele Modele);

    public List<Modele> getAllModeles();

    public Modele getModeleById(int id);

    public void deleteModele(int id);
}
