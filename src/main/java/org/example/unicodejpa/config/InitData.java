package org.example.unicodejpa.config;

import org.example.unicodejpa.model.Unicode;
import org.example.unicodejpa.repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private UnicodeRepository unicodeRepository;


    @Override
    public void run(String... args) throws Exception {
    Set<Character> unicodeChars = new HashSet<>();

    //fra 0 til 65535, det var hvad jeg kunne læse mig frem til som maks kunne være i et Set<Character>
        //dette hører under det man kalder BMP (Basic Multilingual Plane) der spænder over U+0000 til U+FFFF
    for (int i = 0; i <= 65535; i++) {
        unicodeChars.add((char) i);
    }

    for (char c : unicodeChars) {
        Unicode unicode = new Unicode();
        unicode.setUnicode((int) c);
        unicode.setC(c);
        unicodeRepository.save(unicode);
    }


    }
}
