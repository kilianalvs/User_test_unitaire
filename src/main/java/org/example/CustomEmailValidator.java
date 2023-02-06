package org.example;

import java.nio.file.AccessDeniedException;

public class CustomEmailValidator {

    public boolean isValidEmail(String email) throws AccessDeniedException {
        throw new AccessDeniedException("Je suis nul en java");
    }
}
