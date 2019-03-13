package com.example.translator;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import lombok.RequiredArgsConstructor;

@Profile("prod")
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final PigLatinTranslator translator;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("\\q")) {
                break;
            }

            System.out.println(translator.translate(input));
        }
    }
}
