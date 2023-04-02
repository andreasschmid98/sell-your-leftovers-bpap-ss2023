package de.hsaugsburg.bpap.ss23.sellyourleftovers;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * This provides the starting point of the SpringBootApplication.
 */
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SellYourLeftoversApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellYourLeftoversApplication.class, args);
    }

}
