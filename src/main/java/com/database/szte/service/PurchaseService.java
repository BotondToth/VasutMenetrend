package com.database.szte.service;

import com.database.szte.data.ApplicationUser;
import com.database.szte.data.Purchase;
import com.database.szte.dto.PurchaseResultDTO;
import com.database.szte.dto.PurchaseSaveDTO;
import com.database.szte.mapper.PurchaseMapper;
import com.database.szte.repository.PurchaseMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Controller
public class PurchaseService implements IPurchaseService {

    @Autowired
    private PurchaseMongoRepository purchaseMongoRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String passw;

    @Override
    public List<PurchaseResultDTO> getPurchasesByUserId(final String userId) {
        return purchaseMongoRepository.findPurchaseByUser(findUserForPurchase(userId))
                .stream()
                .map(p -> purchaseMapper.toResultDTO(p))
                .collect(Collectors.toList());
    }

    @Override
    public Purchase saveNewPurchase(final PurchaseSaveDTO dto) throws MessagingException {
        final Purchase purchase = purchaseMongoRepository.save(purchaseMapper.toPurchase(dto));
        if (purchase != null) {
            sendEmailWithAttachment(purchase.getUser().getEmail());
        }
        return purchase;
    }

    private void sendEmailWithAttachment(final String to) throws MessagingException {
        Properties props = createProperties();

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, passw);
                    }
                });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        message.setSubject("VasútMenetrend - Jegyvásárlás");
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Kedves Utasunk!\n\nKöszönjük a vásárlást, jegyét a csatolmányok között találja!\n\n"
                + " Vasútmenetrend, 2020");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        messageBodyPart = new MimeBodyPart();
        String filename = "qrcode.png";
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);
        Transport.send(message);
    }

    private Properties createProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        return props;
    }

    private ApplicationUser findUserForPurchase(final String userId) {
        return userService.findUserById(userId);
    }
}
