package com.example.pfecompagnemailling.Services.PlanificationService;

import com.example.pfecompagnemailling.Entities.Planification;
import com.example.pfecompagnemailling.Repository.PlanificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanificationService implements IPlanificationService {
    public PlanificationRepository planificationRepository;

    @Override
    public Planification addPlanification(Planification planification) {
        return planificationRepository.save(planification);
    }

    @Override
    public Planification updatePlanification(Planification planification) {
        return planificationRepository.save(planification);
    }

    @Override
    public List<Planification> getAllPlanifications() {
        return planificationRepository.findAll();
    }

    @Override
    public Planification getPlanificationById(int id) {
        return planificationRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePlanification(int id) {
        planificationRepository.deleteById(id);
    }
    // !timer
}
