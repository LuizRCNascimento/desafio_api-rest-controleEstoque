package starter.apirest.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailService {

	
    private JavaMailSender mailSender;

    public void enviar() {
        SimpleMailMessage email = new SimpleMailMessage();
        System.out.println("Email enviado...");
        email.setFrom("gft.mkt6@gft.com");
        email.setTo("locc@gft.com");
        email.setSubject("Teste envio de e-mail");
        email.setText("Enviei este e-mail usando Spring Boot.");
        mailSender.send(email);
    }
}