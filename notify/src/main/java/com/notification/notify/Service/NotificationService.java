package com.notification.notify.Service;
import com.notification.notify.entity.Notification;
import com.notification.notify.Repository.NotificationRepository;
import com.notification.notify.entity.Campain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired 
    JavaMailSender mailSender;

    @Autowired
    private RestTemplate restTemplate;

    public Notification sendEmail(String recipient, String subject, String body)
    {


        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);

        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setMessage(body);
        notification.setType("email");
        notification.setSentAt(LocalDateTime.now());
        return notificationRepository.save(notification);

    }

    public void notifyCampaignUpdate(Long campaignId,String recipient) {
        String campaignServiceUrl = "http://localhost:8086/api/campaigns/" + campaignId;
        Campain campaign = restTemplate.getForObject(campaignServiceUrl, Campain.class);

        String subject = "Campaign Updated: " + campaign.getCampaign_name();
        String message = "The campaign '" + campaign.getCampaign_name() + "' has been updated. Details: " + campaign.getDescription();

        sendEmail(recipient, subject, message); // Replace with actual recipient
    }

}
