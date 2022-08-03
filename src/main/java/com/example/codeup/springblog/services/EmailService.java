package com.example.codeup.springblog.services;

import com.example.codeup.springblog.model.Post;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from")
    private String from;

    public void prepareAndSend(Post post, String subject){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(subject);
        String body = "Thank you for posting to your Springblog! The title of your post is " + post.getTitle() + " If this was not you please contact customer support.";
        msg.setText(body);

        SendGrid sg = new SendGrid("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\n");
        Request request = new Request();
        try{
            this.emailSender.send(msg);
        } catch(MailException mex){
            System.out.println(mex.getMessage());
        }

    }
}
