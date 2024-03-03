package com.banksystem.Konto;

import java.math.BigDecimal;

public final class SparBankKonto extends BankKonto {


    public SparBankKonto() {
        this.setKontoArt("Sparkonto");
        this.setKontoStand(BigDecimal.valueOf(20)); // Jedes geoeffnete Sparkonto bekommt 20 Euro als Guthaben.
    }

    @Override
    public void einzahlen(BigDecimal betrag) throws InvalidAmountOfDepositException {
        boolean istKontoGeoeffnet = this.isStatus();

        // Fur Kunden die ein Sparkonto haben, koennen sie nur einzahlen, wenn der Betrag gleich oder mehr als 10 Euro ist.
        int MINDESTBETRAG_EINZAHLUNG = 20;
        if (istKontoGeoeffnet && betrag.compareTo(BigDecimal.valueOf(MINDESTBETRAG_EINZAHLUNG)) >= 0) {
            this.setKontoStand(this.getKontoStand().add(betrag));
            System.out.println(betrag + " Euro wurden erfolgreich eingezahlt!" + "\n" + "Aktueller Kontostand: " + this.getKontoStand() + " Euro");
        } else {
            throw new InvalidAmountOfDepositException("Einzahlung nicht erfolgreich!.Mögliche Gründe: Konto ist geschlossen oder Betrag zu gering.");
        }
    }

    @Override
    public void auszahlen(BigDecimal betrag) {
        boolean istKontoGeoeffnet = this.isStatus();
        if (istKontoGeoeffnet && betrag.compareTo(this.getKontoStand()) <= 0) {
            this.setKontoStand(this.getKontoStand().subtract(betrag));
            System.out.println(betrag + " Euro wurden erfolgreich ausgezahlt!" + "\n" + "Aktueller Kontostand: " + this.getKontoStand() + " Euro");
        } else {
            System.out.println("Abhebung nicht möglich. Konto ist geschlossen oder Betrag übersteigt den Kontostand.");
        }
    }
}






