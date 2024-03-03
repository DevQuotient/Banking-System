package com.banksystem.Bank;

import com.banksystem.Konto.GiroBankKonto;
import com.banksystem.Konto.SparBankKonto;
import com.banksystem.Kunde.Kunde;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class BankSystem {
    static Scanner eingabe = new Scanner(System.in);
    private static ArrayList<SparBankKonto> listeVonSparKonten = new ArrayList<>();
    private static ArrayList<GiroBankKonto> listeVonGiroKonten = new ArrayList<>();
    private static ArrayList<Kunde> listeVonKunden = new ArrayList<>();

    public static void kontoEröffnen() {
        System.out.println("Wie viele Konten möchten Sie eröffnen?");
        try {
            int anzahlDerKonten = eingabe.nextInt();

            if (anzahlDerKonten > 0) {
                System.out.println("Geben Sie bitte die Art des Kontos ein: " + "\n" + "Hinweis: GK-Girokonto|SK- Sparkonto");
                String kontoart = eingabe.next();
                for (int i = 0; i < anzahlDerKonten; i++) {
                    if (kontoart.equalsIgnoreCase("SK")) {
                        eingabe.nextLine();
                        System.out.println("Geben Sie bitte den Namen des Kunden ein:");
                        String name = eingabe.nextLine();
                        System.out.println("Geben Sie bitte die Adresse des Kunden ein:");
                        String adresse = eingabe.nextLine();
                        System.out.println("Geben Sie bitte die EmailAdresse des Kunden ein:");
                        String emailAdresse = eingabe.nextLine();
                        System.out.println("Geben Sie bitte die Mobilnummer ohne(+ Vorwahl) des Kunden ein:");
                        int mobilNummer = eingabe.nextInt();
                        System.out.println("Geben Sie bitte den Beruf des Kunden ein:");
                        String beruf = eingabe.nextLine();
                        Kunde kunde = new Kunde(name, adresse, emailAdresse, mobilNummer, beruf);
                        listeVonKunden.add(kunde);
                        SparBankKonto sparKonto = new SparBankKonto();
                        System.out.println("Geben Sie den Einzahlungsbetrag ein: ");
                        BigDecimal betrag = eingabe.nextBigDecimal();
                        sparKonto.setKontoStand(betrag);
                        sparKonto.setKontoInhaber(kunde);
                        listeVonSparKonten.add(sparKonto);
                    } else if (kontoart.equalsIgnoreCase("GK")) {
                        eingabe.nextLine();
                        System.out.println("Geben Sie bitte den Namen des Kunden ein:");
                        String name = eingabe.nextLine();
                        System.out.println("Geben Sie bitte die Adresse des Kunden ein:");
                        String adresse = eingabe.nextLine();
                        System.out.println("Geben Sie bitte die EmailAdresse des Kunden ein:");
                        String emailAdresse = eingabe.nextLine();
                        System.out.println("Geben Sie bitte die Mobilnummer ohne(+ Vorwahl) des Kunden ein:");
                        int mobilNummer = eingabe.nextInt();
                        System.out.println("Geben Sie bitte den Beruf des Kunden ein:");
                        String beruf = eingabe.next();
                        Kunde kunde = new Kunde(name, adresse, emailAdresse, mobilNummer, beruf);
                        listeVonKunden.add(kunde);
                        GiroBankKonto giroKonto = new GiroBankKonto();
                        System.out.println("Geben Sie den Einzahlungsbetrag ein: ");
                        BigDecimal betrag = eingabe.nextBigDecimal();
                        giroKonto.setKontoStand(betrag);
                        giroKonto.setKontoInhaber(kunde);
                        giroKonto.einzahlen(betrag);
                        listeVonGiroKonten.add(giroKonto);
                    } else {
                        System.out.println("Kontoart wurde nicht gefunden!");
                    }
                }
            } else {
                System.out.println("Keine gültige Anzahl von Konten wurde eingegeben!");
            }

        } catch (InputMismatchException exception) {
            System.out.println("Geben Sie bitte nur Zahlen ein!");
        }catch (Exception e){
            System.out.println("Etwas ist schief gelaufen :(");
        }
    }
    public static void kontoSchlieẞen(){

    }
    public static void kontoInformationenAnzeigen(){

    }
    public static void einzahlen(){

    }
    public static void auszahlen(){

    }

    public static void main(String[] args) {

        eingabe = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Neues Konto eröffnen");
            System.out.println("2. Geld einzahlen");
            System.out.println("3. Geld auszahlen");
            System.out.println("4. Kontoinformationen ansehen");
            System.out.println("5. Programm beenden");

            option = eingabe.nextInt();
            try {
                switch (option) {
                    case 1:

                        kontoEröffnen();

                        break;
                    case 2:
                        System.out.println("Geld einzahlen");

                        break;
                    case 3:
                        System.out.println("Geld auszahlen");
                        break;
                    case 4:
                        kontoInformationenAnzeigen();
                        break;
                    case 5:
                        System.out.println("Bis bald :)");
                        break;
                    default:
                        throw new InputMismatchException("Ungueltige Eingabe!");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }


        } while (option != 5);
    }
}



