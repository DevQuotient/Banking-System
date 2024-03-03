package com.banksystem.Konto;

import java.math.BigDecimal;

public final  class GiroBankKonto extends BankKonto {


    public GiroBankKonto() {
        this.setKontoArt("Girokonto");
        this.setKontoStand(BigDecimal.valueOf(10)); // Jedes geoeffnete Girokonto bekommt 10 Euro Guthaben fur den Kontostand
    }

    @Override
    public void einzahlen(BigDecimal betrag) throws InvalidAmountOfDepositException {
        boolean istKontoGeoeffnet = this.isStatus();

        // Fur Kunden die ein Girokonto haben, koennen sie nur einzahlen, wenn der Betrag gleich oder mehr als 10 Euro ist.
        int MINDESTBETRAG_EINZAHLUNG = 10;
        if (istKontoGeoeffnet && betrag.compareTo(BigDecimal.valueOf(MINDESTBETRAG_EINZAHLUNG)) >= 0) {
            this.setKontoStand(this.getKontoStand().add(betrag));
            System.out.println(betrag + " Euro wurden erfolgreich eingezahlt!" + "\n" + "Aktueller Kontostand: " + this.getKontoStand() + " Euro");
        } else {
            throw new InvalidAmountOfDepositException("Einzahlung nicht erfolgreich!.Mögliche Gründe: Konto ist geschlossen oder Betrag zu gering.");
        }
    }
    /**
     * Zusammengefasst überprüft diese Methode, ob das Konto geöffnet ist, der Kontostand über 100 Euro liegt und der abzuhebende Betrag nicht größer ist als der aktuelle Kontostand.
     */
    @Override
    public void auszahlen(BigDecimal betrag) {
        boolean istKontoGeoeffnet = this.isStatus();
        BigDecimal hundertEuro = BigDecimal.valueOf(100);
        // Überprüfen, ob das Konto geöffnet ist, der Kontostand über 100 Euro liegt
        // und der abzuhebende Betrag nicht größer ist als der aktuelle Kontostand
        if (istKontoGeoeffnet && this.getKontoStand().compareTo(hundertEuro) > 0 && betrag.compareTo(this.getKontoStand()) <= 0) {
            this.setKontoStand(this.getKontoStand().subtract(betrag));
            System.out.println(betrag + " Euro wurden erfolgreich ausgezahlt!" + "\n" + "Aktueller Kontostand: " + this.getKontoStand() + " Euro");
        } else {
            System.out.println("Abhebung nicht möglich. Konto ist geschlossen, Betrag übersteigt den Kontostand oder der Kontostand ist bereits 100 Euro.");
        }

    }


}
