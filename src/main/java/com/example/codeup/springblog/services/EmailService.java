package com.example.codeup.springblog.services;

import com.example.codeup.springblog.model.Post;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.Method;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("emailService")
public class EmailService {

    @Value("${spring.sendgrid.api-key}")
    private String key;

    public void prepareAndSend(Post post, String subject) {
        Email from = (new Email("christopher.aa.merritt@gmail.com"));
        Email to = (new Email("christopher.aa.merritt@gmail.com"));
        String body = "Thank you for posting to your Springblog! The title of your post is " + post.getTitle() + " If this was not you please contact customer support.";
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(key);
        Request request = new Request();
        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());

        } catch(MailException | IOException ex){
            ex.printStackTrace();
        }
    }
}
