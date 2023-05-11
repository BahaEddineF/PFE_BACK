package com.example.pfecompagnemailling.Services.PlanificationService;

import com.example.pfecompagnemailling.Entities.Planification;

import java.util.List;

public interface IPlanificationService {
    public Planification addPlanification (Planification planification);
    public Planification updatePlanification (Planification planification);
    public List<Planification> getAllPlanifications();
    public Planification getPlanificationById(int id);
    public void deletePlanification(int id);
}
