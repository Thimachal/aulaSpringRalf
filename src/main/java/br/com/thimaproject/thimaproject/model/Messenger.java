package br.com.thimaproject.thimaproject.model;

import org.springframework.stereotype.Component;

@Component
public class Messenger {
    private String menssenger;

    public String getMenssenger() {
        return menssenger;
    }

    public void setMenssenger(String menssenger) {
        this.menssenger = menssenger;
    }
}
