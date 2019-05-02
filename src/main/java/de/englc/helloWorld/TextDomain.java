package de.englc.helloWorld;

import org.springframework.stereotype.Service;

@Service
public class TextDomain {

    public String get() {
        return "This is some text";
    }
}
