package com.banksystem.Konto;

import com.banksystem.Kunde.Kunde;

import java.math.BigDecimal;
import java.util.Random;
/*
Klasse BankKonto, die die wichtigsten Attributen und Methoden eines Kontos hat.
Die Klasse Konto ist abstract, da wir keine Objekte von dieser Oberklasse erzeugen wollen.
Nur Objekte der Unterklassen werden intanzieert.
 */
public abstract class BankKonto {

    // Attributen eines Kontos
    protected Kunde kontoInhaber; // Ein kontoInhaber ist eine Kunde, die x,y,z attributen hat...
    protected int kontoNummer; // Die Kontonummer wird automatisch generiert. Die Klasse Random wird benutzt, um eine Zufallsint-Zahl zu generieren.
    protected String kontoArt; // SK-Sparkonto;GK- Girokonto
    protected BigDecimal kontoStand; // Dieses Attribut hat den Datentyp Bigdecimal, da wir präsize arbeiten will.
    protected boolean status; // true= geöffnetes Konto; false = geschlossenes Konto.

    // Konstruktor 1
    // Dieser Konstruktor besitzt keine Parameter
    public BankKonto() {
        // Wenn ein Konto eröffnet wird, wird status geändert und den Kontostand auf 0 gesetzt.
        // Ausserdem setzt den Konstruktor die kontonummer mit einer Zufallszahl.
        this.setStatus(true);
        this.setKontoStand(BigDecimal.valueOf(0));
        this.setKontoNummer(generierKontoNummer());
    }

    public BankKonto(BigDecimal kontoStand) {
        this.kontoStand = kontoStand;
    }

    /**
     * Das Ziel dieser Methode ist eine ZufallsZahl zu generieren
     * Die Zahl muss positiv sein und auch 10 Ziffer haben
     *
     * @return Kontonummer
     */
    public static int generierKontoNummer() {
        Random zufallsnummer = new Random();

        int generierteZufallKontoNummer;

        // do-while-Schleife, die den Codeblock mindestens einmal ausführt und weiter wiederholt,

        generierteZufallKontoNummer = zufallsnummer.nextInt(900000000) + 1000000000;

        return generierteZufallKontoNummer;
    }
    // Getters und Setters

    public Kunde getKontoInhaber() {
        return kontoInhaber;
    }

    public void setKontoInhaber(Kunde kontoInhaber) {
        this.kontoInhaber = kontoInhaber;
    }

    public int getKontoNummer() {
        return kontoNummer;
    }

    public void setKontoNummer(int kontoNummer) {
        this.kontoNummer = kontoNummer;
    }

    public BigDecimal getKontoStand() {
        return kontoStand;
    }

    public void setKontoStand(BigDecimal kontoStand) {
        this.kontoStand = kontoStand;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getKontoArt() {
        return kontoArt;
    }

    public void setKontoArt(String kontoArt) {
        this.kontoArt = kontoArt;
    }

    // Abstrakte Methoden, die in den Unterklassen implementiert werden.
    public abstract void einzahlen(BigDecimal betrag) throws InvalidAmountOfDepositException;

    public abstract void auszahlen(BigDecimal betrag);

    public void kontoInformationenAnzeigen(){
        System.out.println("-----KONTOINFORMATIONEN-----");
        System.out.println("Kontoinhaber: "+this.getKontoInhaber());
        System.out.println("Kontonummer: "+this.getKontoNummer());
        System.out.println("Kontoart: "+this.getKontoArt());
        System.out.println("Kontostand: "+this.getKontoStand());
        System.out.println("Kontostatus: "+this.isStatus());
    }

}
