package com.example.pfecompagnemailling.Services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.pfecompagnemailling.Entities.CampagneMailing;
import com.example.pfecompagnemailling.Entities.ModeEnvoie;
import com.example.pfecompagnemailling.Repository.CampagneMailingRepository;
import com.example.pfecompagnemailling.Services.CampagneMailingService.ICampagneMaillingService;

@Component
public class EmailScheduler {
    private final TaskScheduler taskScheduler;
    private final ICampagneMaillingService service;
    private final CampagneMailingRepository campagneMailingRepository;

    @Autowired
    public EmailScheduler(TaskScheduler taskScheduler, ICampagneMaillingService service,
            CampagneMailingRepository campagneMailingRepository) {
        this.taskScheduler = taskScheduler;
        this.service = service;
        this.campagneMailingRepository = campagneMailingRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void envoieCampagneAtScheduledTime() {
        List<CampagneMailing> campagneMailings = campagneMailingRepository.findAllByModeEnvoieAndEtat(ModeEnvoie.Asynchrone, "Encours");
    
        for (CampagneMailing campagneMailing : campagneMailings) {
            if (campagneMailing.getPlanification() != null) {
                Date targetDate = campagneMailing.getPlanification().getDateenv();
                System.out.println("Target Date: " + targetDate);
    
                if (campagneMailing.getPlanification().getRepetetion() != 0) {
                    Date repetitionDate = calculateRepetitionDate(targetDate, campagneMailing.getPlanification().getRepetetion());
                    scheduleRepeatingMailing(targetDate, repetitionDate, campagneMailing);
                } else {
                    scheduleMailing(targetDate, campagneMailing);
                }
            }
        }
    }
    
    public void scheduleMailing(Date targetDate, CampagneMailing campagneMailing) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    
        long delay = targetDate.getTime() - System.currentTimeMillis();
        System.out.println("Delay: " + delay);

        if (delay < 0) {
            // Current time is already past the targetDate, no need to schedule the mailing
            return;
        }
        executor.schedule(() -> {
            service.sendAsynchronousMail(campagneMailing);
            campagneMailing.setEtat("Envoyé");
            campagneMailingRepository.save(campagneMailing);
        }, delay, TimeUnit.MILLISECONDS);
    
        executor.shutdown();
    }
    
    public void scheduleRepeatingMailing(Date targetDate, Date repetitionDate, CampagneMailing campagneMailing) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    
        long initialDelay = targetDate.getTime() - System.currentTimeMillis();
        long repeatDelay = repetitionDate.getTime() - System.currentTimeMillis();
        if (initialDelay >= 0 ) {
            executor.schedule(() -> {
                service.sendAsynchronousMail(campagneMailing);
                campagneMailing.setEtat("Envoyé");
                campagneMailingRepository.save(campagneMailing);
            }, initialDelay, TimeUnit.MILLISECONDS);
        }
      
        if (repeatDelay >= 0 ) {
        executor.schedule(() -> {
            service.sendAsynchronousMail(campagneMailing);
            campagneMailing.setEtat("Envoyé");
            campagneMailingRepository.save(campagneMailing);
        }, repeatDelay, TimeUnit.MILLISECONDS);
    
       
    }
    executor.shutdown();
}
    
    public Date calculateRepetitionDate(Date targetDate, int repetitionDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(targetDate);
        calendar.add(Calendar.DAY_OF_YEAR, repetitionDays);
        return calendar.getTime();
    }


}
