/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.account;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @BeforeEach
    void setup() {
        // Reset static variables before each test to ensure a clean state
        Account.registeredUsername = "";
        Account.registeredPassword = "";
        Account.firstName = "Anza";
        Account.lastName = "Mahwasane";
    }

    @Test
    void testCheckUserName_Valid() {
        assertTrue(Account.checkUserName("k_l"), "Username 'k_l' should be valid");
    }

    @Test
    void testCheckUserName_Invalid() {
        assertFalse(Account.checkUserName("kyl_ee"), "Username too long");
        assertFalse(Account.checkUserName("kyle"), "Username missing underscore");
    }

    @Test
    void testCheckPasswordComplexity_Valid() {
        // 8 chars, Capital, Number, Special
        assertTrue(Account.checkPasswordComplexity("Ch@tt3r1"), "Password should be valid");
    }

    @Test
    void testCheckPasswordComplexity_Invalid() {
        assertFalse(Account.checkPasswordComplexity("password"), "Missing everything");
        assertFalse(Account.checkPasswordComplexity("Pass123"), "Too short and no special char");
    }

    @Test
    void testCheckCellPhoneNumber_Valid() {
        // Starts with +27 followed by 9 digits
        assertTrue(Account.checkCellPhoneNumber("+27123456789"));
    }

    @Test
    void testCheckCellPhoneNumber_Invalid() {
        assertFalse(Account.checkCellPhoneNumber("0721234567"), "Missing international code");
        assertFalse(Account.checkCellPhoneNumber("+27123"), "Too short");
    }

    @Test
    void testLoginUser_Success() {
        Account.registeredUsername = "j_doe";
        Account.registeredPassword = "Password1!";
        
        assertTrue(Account.loginUser("j_doe", "Password1!"));
    }

    @Test
    void testLoginUser_Failure() {
        Account.registeredUsername = "j_doe";
        Account.registeredPassword = "Password1!";
        
        assertFalse(Account.loginUser("j_doe", "wrongPass"));
    }

    @Test
    void testReturnLoginStatus_Success() {
        String expected = "Welcome Anza Mahwasane it is great to see you";
        assertEquals(expected, Account.returnLoginStatus(true));
    }

    @Test
    void testReturnLoginStatus_Failure() {
        String expected = "Username or password is incorrect please try again";
        assertEquals(expected, Account.returnLoginStatus(false));
    }
}