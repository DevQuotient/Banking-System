package com.banksystem.Konto;

public class InvalidAmountOfDepositException extends Exception {

    public InvalidAmountOfDepositException(String nachricht) {
        super(nachricht);
    }
}
