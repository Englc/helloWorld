package de.englc.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextService {

    @Autowired
    private TextDomain textDomain;

    public String getText() {
        return textDomain.get() + " Adjusted";
    }
}
