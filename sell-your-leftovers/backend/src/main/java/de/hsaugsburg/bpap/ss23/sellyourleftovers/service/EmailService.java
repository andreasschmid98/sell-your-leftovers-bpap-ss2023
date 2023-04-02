package de.hsaugsburg.bpap.ss23.sellyourleftovers.service;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This defines the service class for managing the email functionality.
 */
@Service
@RequiredArgsConstructor
public class EmailService {

    /**
     * Static Strings needed for creating the service mails
     */
    private final static String ADDRESS = "art.artx@gmx.de";
    private final static String SUBJECT_BUY = "SYL - Vielen Dank für Deinen Einkauf";
    private final static String SUBJECT_SELL = "SYL - Dein Produkt wurde verkauft";
    private final static String START_BUY = "Lieber Kunde,\n\nvielen Dank für Deinen Einkauf. Anbei erhältst Du Deine Rechnung:\n\n";
    private final static String START_SELL = "Lieber Verkäufer,\n\neines oder mehrere Deiner Produkte wurden verkauft.";
    private final static String END_BUY = "\n\nDie Daten des Zahlungsempfängers findest Du in Deinem Paket!\n\nMit freundlichen Grüßen\n\nDein Sell Your Leftovers Team";
    private final static String END_SELL = "\n\nDer Käufer wird Dir das Geld in Kürze überweisen!\n\nMit freundlichen Grüßen\n\nDein Sell Your Leftovers Team";

    private final JavaMailSender mailSender;
    private final UserService userService;

    public void send(List<Product> products) {

        User buyer = userService.getCurrentUser();
        List<User> allUsers = userService.getAllUsers();
        List<User> sellers = new ArrayList<>();


        for (User user : allUsers) {
           if (user.getUploads().stream().anyMatch(products::contains)) {
               sellers.add(user);
           }
        }

        sendToBuyer(buyer.getEmail(), products);

        for(User seller : sellers){
            sendToSeller(seller.getEmail());
        }
    }

    private void sendToBuyer(String to, List<Product> products) {
        String invoice = createInvoice(products);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(ADDRESS);
        message.setTo(to);
        message.setSubject(SUBJECT_BUY);
        message.setText(START_BUY + invoice + END_BUY);

        mailSender.send(message);
    }

    private void sendToSeller(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(ADDRESS);
        message.setTo(to);
        message.setSubject(SUBJECT_SELL);
        message.setText(START_SELL + END_SELL);

        mailSender.send(message);
    }

    private String createInvoice(List<Product> products) {
        String invoice = "";
        BigDecimal sum = new BigDecimal(0);

        for (Product product : products) {
            invoice += "" + product.getName() + ": " + product.getPrice() + " €\n\n";
            sum = sum.add(product.getPrice());
        }

        invoice += "Gesamt: " + sum + " €";

        return invoice;
    }
}
