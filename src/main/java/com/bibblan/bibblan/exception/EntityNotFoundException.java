package com.bibblan.bibblan.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message) {
        // pratar med catch-metoden i BorrowedBooksController rad 45, om listan man försöker uppdater inte existerar eller är fel.
        // Denna skulle man kunna använda till betydligt fler metoder men vi lärde oss den lite senare i kursen och jag ska vara ärlig
        // jag har inte 1000% förståelse för exakt hur den fungerar så därför har jag valt att skriva 97% av mitt program
        // av kod som jag helt kan förklara och förstå
        super(message);
    }
}
