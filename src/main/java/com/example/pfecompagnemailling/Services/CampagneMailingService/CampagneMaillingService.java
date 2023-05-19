package com.example.pfecompagnemailling.Services.CampagneMailingService;

import com.example.pfecompagnemailling.Entities.CampagneMailing;
import com.example.pfecompagnemailling.Entities.Configuration;
import com.example.pfecompagnemailling.Entities.Modele;
import com.example.pfecompagnemailling.Entities.Planification;
import com.example.pfecompagnemailling.Entities.User;
import com.example.pfecompagnemailling.Repository.CampagneMailingRepository;
import com.example.pfecompagnemailling.Repository.ConfigurationRepository;
import com.example.pfecompagnemailling.Repository.ModeleRepository;
import com.example.pfecompagnemailling.Repository.PlanificationRepository;
import com.example.pfecompagnemailling.Repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class CampagneMaillingService  implements ICampagneMaillingService{
    public CampagneMailingRepository campagneMailingRepository;
    public PlanificationRepository planificationRepository;
    public ConfigurationRepository configurationRepository;
    public ModeleRepository modeleRepository;
    public UserRepository userRepository;
    @Override
    public CampagneMailing addCampagneMailling(CampagneMailing campagneMailling) {
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
    public CampagneMailing saveCampagneMailing( CampagneMailing campagneMailing) {
        Configuration configuration = configurationRepository.findById(campagneMailing.getConfiguration().getId()).orElse(null);
        Modele modele = modeleRepository.findById(campagneMailing.getModele().getId()).orElse(null);
        campagneMailing.setConfiguration(configuration);
        campagneMailing.setModele(modele);
        campagneMailing.setEtat("Encours");
        Planification planification = campagneMailing.getPlanification();
        if(planification != null) {
        planificationRepository.save(planification);
        campagneMailing.setPlanification(planification);
        }
        return campagneMailingRepository.save(campagneMailing);
    }
 
 
     public JavaMailSender getJavaMailSender(CampagneMailing campagneMailing) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(campagneMailing.getConfiguration().getSmtpserver());
        mailSender.setPort(campagneMailing.getConfiguration().getPort());
        mailSender.setUsername(campagneMailing.getEmail());
        mailSender.setPassword("yxmrjqpthvuszhjq");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }

    @Override
    public void sendSynchronousMail(CampagneMailing campagneMailing) {
        List<User> userList = userRepository.findAllByRoleLibelle(campagneMailing.getDestinataire());
        List<String> to = new ArrayList<>();
        userList.forEach(elem -> {
            to.add(elem.getEmail());
        });
        MimeMessage message2 = getJavaMailSender(campagneMailing).createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message2);

       Modele modele =  campagneMailing.getModele();
        for(String receiver: to)
        {
            try {
                helper.setTo(receiver);
                helper.setText("<span style='font-weight: bold;font-size: 20px;'>Corps: </span>"+"\n" + modele.getContenu()+"\n" +"<span style='font-weight: bold;font-size: 20px;'>Signature: </span> <br>"+  modele.getSignature()
                ,true);
                helper.setSubject(modele.getSujet());
            } catch (MessagingException e) {
                e.printStackTrace();
    
              
            }
            getJavaMailSender(campagneMailing).send(message2);
        }

        campagneMailing.setEtat("Envoyé");
        campagneMailingRepository.save(campagneMailing);
      
    }

    @Override
    public void sendAsynchronousMail(CampagneMailing campagneMailing) {
        List<User> userList = userRepository.findAllByRoleLibelle(campagneMailing.getDestinataire());
        List<String> to = new ArrayList<>();
        userList.forEach(elem -> {
            to.add(elem.getEmail());
        });
        MimeMessage message2 = getJavaMailSender(campagneMailing).createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message2);

       Modele modele =  campagneMailing.getModele();
        for(String receiver: to)
        {
            try {
                helper.setTo(receiver);
                helper.setText("<span style='font-weight: bold;font-size: 20px;'>Corps: </span>"+"\n" + modele.getContenu()+"\n" +"<span style='font-weight: bold;font-size: 20px;'>Signature: </span> <br>"+  modele.getSignature()
                ,true);
                helper.setSubject(modele.getSujet());
            } catch (MessagingException e) {
                e.printStackTrace();
    
              
            }
            getJavaMailSender(campagneMailing).send(message2);
        }
        campagneMailing.setEtat("Envoyé");
        campagneMailingRepository.save(campagneMailing);
    }
}
