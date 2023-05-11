package com.example.pfecompagnemailling.Services.CampagneMailingService;

import com.example.pfecompagnemailling.Entities.CampagneMailing;
import com.example.pfecompagnemailling.Entities.Configuration;
import com.example.pfecompagnemailling.Entities.Modele;
import com.example.pfecompagnemailling.Entities.Planification;
import com.example.pfecompagnemailling.Repository.CampagneMailingRepository;
import com.example.pfecompagnemailling.Repository.ConfigurationRepository;
import com.example.pfecompagnemailling.Repository.ModeleRepository;
import com.example.pfecompagnemailling.Repository.PlanificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CampagneMaillingService  implements ICampagneMaillingService{
    public CampagneMailingRepository campagneMailingRepository;
    public PlanificationRepository planificationRepository;
    public ConfigurationRepository configurationRepository;
    public ModeleRepository modeleRepository;
    @Override
    public CampagneMailing addCampagneMailling(CampagneMailing campagneMailling) {
        return campagneMailingRepository.save(campagneMailling);
    }

    @Override
    public CampagneMailing updateCampagneMailling(CampagneMailing campagneMailling) {
        return campagneMailingRepository.save(campagneMailling);
    }

    @Override
    public List<CampagneMailing> getAllCampagneMaillings() {
        return campagneMailingRepository.findAll();
    }

    @Override
    public CampagneMailing getCampagneMaillingById(int id) {
        return campagneMailingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCampagneMailing(int id) {
         campagneMailingRepository.deleteById(id);

    }




    @Override
    public CampagneMailing addCampagneMailingAndPlanification(CampagneMailing campagneMailing) {
        Planification planification = new Planification();
        planification.setDateenv(campagneMailing.getPlanification().getDateenv());
        planification.setRepetetion(campagneMailing.getPlanification().getRepetetion());

        campagneMailing.setPlanification(planification);
        return null;
    }

    @Override
    public CampagneMailing addCampagneMailingAndAffectModeleConfig( CampagneMailing campagneMailing) {
        Configuration configuration = configurationRepository.findById(campagneMailing.getConfiguration().getId()).orElse(null);
        Modele modele = modeleRepository.findById(campagneMailing.getModele().getId()).orElse(null);
        campagneMailing.setConfiguration(configuration);
        campagneMailing.setModele(modele);
        campagneMailing.setPlanification(null);
        return campagneMailingRepository.save(campagneMailing);
    }

    @Override
    public CampagneMailing addCampagneMailingWithConfigAndModeleAndPlanification( CampagneMailing campagneMailing) {
        Configuration configuration = configurationRepository.findById(campagneMailing.getConfiguration().getId()).orElse(null);
        Modele modele = modeleRepository.findById(campagneMailing.getModele().getId()).orElse(null);
        campagneMailing.setConfiguration(configuration);
        campagneMailing.setModele(modele);

        Planification planification = campagneMailing.getPlanification();
        planificationRepository.save(planification);
        campagneMailing.setPlanification(planification);
        return campagneMailingRepository.save(campagneMailing);
    }

}
