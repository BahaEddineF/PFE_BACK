package com.example.pfecompagnemailling.Services.CampagneMailingService;

import com.example.pfecompagnemailling.Entities.CampagneMailing;

import java.util.List;

public interface ICampagneMaillingService {
    public CampagneMailing addCampagneMailling (CampagneMailing CampagneMailling);
    public CampagneMailing updateCampagneMailling (CampagneMailing CampagneMailling);
    public List<CampagneMailing> getAllCampagneMaillings();
    public CampagneMailing getCampagneMaillingById(int id);

    public void deleteCampagneMailing(int id);

    public CampagneMailing addCampagneMailingAndPlanification(CampagneMailing campagneMailing);


   public CampagneMailing addCampagneMailingAndAffectModeleConfig( CampagneMailing campagneMailing);

    public CampagneMailing  addCampagneMailingWithConfigAndModeleAndPlanification ( CampagneMailing campagneMailing);
}
