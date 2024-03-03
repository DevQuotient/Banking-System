package com.banksystem.Kunde;

import com.banksystem.Konto.BankKonto;

/*
Klasse com.banksystem.Kunde.Kunde, die die wichtigsten Attributen und Methoden eines Kundens hat.
*/public class Kunde {
    BankKonto konto; // Ein Kunde hat ein Konto
    // Attributen von Kunden
    private String name;
    private String adresse;
    private String emailAdresse;
    private int mobilNummer;
    private String beruf;

    public Kunde(String name, String adresse, String emailAdresse, int mobilNummer, String beruf) {
        this.name = name;
        this.adresse = adresse;
        this.beruf = beruf;
        this.emailAdresse = emailAdresse;
        this.mobilNummer = mobilNummer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }

    public void setEmailAdresse(String emailAdresse) {
        this.emailAdresse = emailAdresse;
    }

    public int getMobilNummer() {
        return mobilNummer;
    }

    public void setMobilNummer(int mobilNummer) {
        this.mobilNummer = mobilNummer;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public BankKonto getKonto() {
        return konto;
    }

    public void setKonto(BankKonto konto) {
        this.konto = konto;
    }

    @Override
    public String toString() {
        return "Kunde[" +
                "Name: " + name + '\'' +
                ", Adresse: " + adresse + '\'' +
                ", Emailadresse: " + emailAdresse + '\'' +
                ", Mobilnummer: " + mobilNummer + '\'' +
                ", Beruf: " + beruf + '\'' + "]";
    }
}
