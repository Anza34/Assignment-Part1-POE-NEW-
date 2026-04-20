/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.account;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Account {

    static String registeredUsername = "";
    static String registeredPassword = "";
    static String registeredPhone = "";
    static String firstName = "";
    static String lastName = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== REGISTRATION ===");
        System.out.print("Enter your First Name:");
        firstName = input.nextLine();
        System.out.print("Enter your Last Name:");
        lastName = input.nextLine();
        System.out.print("Enter username:");
        String username = input.nextLine();

        if (checkUserName(username)) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted,please ensure that your username contains an underscore and is no more than five characters in length");
            input.close();
            return;
        }

        // Password
        System.out.print("Enter password:");
        String password = input.nextLine();

        if (checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted please ensure that the password contains at least eight characters,capital letter,number,and A special character");
            input.close();
            return;
        }
        
        System.out.print("Enter cell phone number:");
        String phone = input.nextLine();

        if (checkCellPhoneNumber(phone)) {
            System.out.println("Cell phone number successfully captured");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain an international code, please correct the number and try again");
            input.close();
            return;
        }

        // Store details
        registeredUsername = username;
        registeredPassword = password;
        registeredPhone = phone;

        System.out.println("Registration successful");

        // LOGIN
        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username:");
        String loginUser = input.nextLine();

        System.out.print("Enter password:");
        String loginPass = input.nextLine();

        boolean loginSuccess = loginUser(loginUser, loginPass);

        System.out.println(returnLoginStatus(loginSuccess));

        input.close();
    }

    // Username validation
    public static boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5 && username.length() > 0;
    }

    // Password validation
    public static boolean checkPasswordComplexity(String password) {
        if (password == null) return false;

        boolean length = password.length() >= 8;
        boolean capital = false;
        boolean number = false;
        boolean special = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) capital = true;
            else if (Character.isDigit(c)) number = true;
            else if ("!@#$%^&*".indexOf(c) >= 0) special = true;
        }

        return length && capital && number && special;
    }

     //Phonenumber validation
    public static boolean checkCellPhoneNumber(String number) {
        if (number == null) return false;
        return number.matches("^\\+27\\d{9}$");
    }

    public static boolean loginUser(String username, String password) {
        return username != null &&
                password != null &&
                username.equals(registeredUsername) &&
                password.equals(registeredPassword);
    }

    // display login message
    public static String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you";
        } else {
            return "Username or password is incorrect please try again";
        }
    }
}