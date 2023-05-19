package com.example.pfecompagnemailling.Services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.example.pfecompagnemailling.Entities.CampagneMailing;
import com.example.pfecompagnemailling.Entities.ModeEnvoie;
import com.example.pfecompagnemailling.Repository.CampagneMailingRepository;
import com.example.pfecompagnemailling.Services.CampagneMailingService.CampagneMaillingService;
import com.example.pfecompagnemailling.Services.CampagneMailingService.ICampagneMaillingService;

@Component
public class EmailScheduler {
    private final TaskScheduler taskScheduler;
    private final ICampagneMaillingService service;
    private final CampagneMailingRepository campagneMailingRepository ;
    @Autowired
    public EmailScheduler(TaskScheduler taskScheduler, ICampagneMaillingService service,CampagneMailingRepository campagneMailingRepository ) {
        this.taskScheduler = taskScheduler;
        this.service = service;
        this.campagneMailingRepository = campagneMailingRepository ; 
    }
    @Scheduled(fixedDelay = 60000)
	public void envoieCampagneAtScheduledTime() {
		Date date = new Date() ;
		Calendar calendar = Calendar.getInstance() ;
		calendar.setTime(date);
		List<CampagneMailing>  campagneMailings = campagneMailingRepository.findAllByModeEnvoieAndEtat(ModeEnvoie.Asynchrone , "Encours");
		for(CampagneMailing campagneMailing:campagneMailings)
		{
			if(campagneMailing.getPlanification() != null)
			{
                
				Date dateCampagne = campagneMailing.getPlanification().getDateenv();
                System.out.println("dateCompagne"  + dateCampagne);
				Calendar calendarCampagne = Calendar.getInstance() ;
				calendarCampagne.setTime(dateCampagne);
                // daily at 10PM  new CronTrigger("0 0 22 * * ?")
				taskScheduler.schedule(() -> service.sendAsynchronousMail(campagneMailing) ,dateCampagne );
                
			
			}
		}
	}
    
}
