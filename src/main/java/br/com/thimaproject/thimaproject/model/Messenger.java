package br.com.thimaproject.thimaproject.model;

import org.springframework.stereotype.Component;

@Component
public class Messenger {
    private String messenger;

    public String getMenssenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }
}
