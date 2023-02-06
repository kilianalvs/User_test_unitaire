package org.example;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String email;
    private String name;
    private String firstname;
    private LocalDate born;

    private CustomEmailValidator customEmailValidator;

    public boolean isValid() throws AccessDeniedException {

        LocalDate now = LocalDate.now();

        if (name.isEmpty() || firstname.isEmpty() || email.isEmpty()){
            throw new IllegalArgumentException("Vous devez obligatoirement renseigner un Nom, un Prénom et un Email");
        }

        if (getBorn() == null){
            throw new IllegalArgumentException("Vous devez obligatoirement renseigner votre date de naissance");
        }

        if (now.compareTo(getBorn()) < 13){
            throw new AccessDeniedException("Vous n'avez pas l'age pour visiter ce site");
        }



        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher m = p.matcher(email.toUpperCase());

        if(!m.matches()){
            throw new IllegalArgumentException("Veuillez renseigner une adresse email correct");
        }

        return m.matches();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }
}
