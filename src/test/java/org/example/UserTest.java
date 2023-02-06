package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User getMockUser(){
        User user = new User();
        user.setEmail("kilian.alves@gmail.com");
        user.setFirstname("kilian");
        user.setName("Alves");
        user.setBorn(LocalDate.now().minusYears(15));
        return user;
    }

    @Before
    public void setUp(){
        System.out.println("Test UserTest.java");
        System.out.println("---------------------------------------------");
        System.out.println("Initialisation");
    }

    @Test
    void isValidShouldReturnTrue() throws AccessDeniedException {
        User user = getMockUser();
        assertTrue(user.isValid());
    }

    @Test
    void isValidShouldReturnFalseWithEmailKO() throws AccessDeniedException {
        User user = getMockUser();
        user.setEmail("kilianalevs.com");
        assertThrows(IllegalArgumentException.class, user::isValid);

    }

    @Test
    void isValidShouldReturnFalseWithNameEmpty(){
        User user = getMockUser();
        user.setName("");
        assertThrows(IllegalArgumentException.class, user::isValid);
    }

    @Test
    void isValidShouldReturnExceptionWhitBornKo(){
        User user = getMockUser();
        user.setBorn(LocalDate.now().minusYears(10));
        assertThrows(AccessDeniedException.class, user::isValid);
    }

    @Test
    void isValideShouldReturnExceptionWhitBornEmpty(){
        User user = getMockUser();
        user.setBorn(null);
        assertThrows(IllegalArgumentException.class, user::isValid);
    }
}