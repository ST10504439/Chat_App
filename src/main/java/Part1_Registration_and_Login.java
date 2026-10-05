/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.regex.Pattern;
/**
 *
 * @author sibus
 */
public class Part1_Registration_and_Login {
    // Instance variables to store user data
    private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
   
    
    // Setters used during registration to populate fields
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    /**
     * Ensures that any username contains an underscore (_) and is no more than 5 characters long.
     */
    public boolean checkUserName() {
        if (this.username == null) return false;
        return this.username.contains("_") && this.username.length() <= 5;
    }

    /**
     * Ensures that passwords meet complexity rules:
     * At least 8 characters long, contains a capital letter, a number, and a special character.
     */
    public boolean checkPasswordComplexity() {
        if (this.password == null) return false;
        
        boolean hasLength = this.password.length() >= 8;
        boolean hasCapital = Pattern.compile("[A-Z]").matcher(this.password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(this.password).find();
        boolean hasSpecial = Pattern.compile("[^a-zA-Z0-9]").matcher(this.password).find();

        return hasLength && hasCapital && hasDigit && hasSpecial;
    }

    /**
     * Ensures that the cell phone is the correct length and contains the international country code (e.g., 27).
     */
    public boolean checkCellPhoneNumber() {
        if (this.phoneNumber == null) return false;
        // South Africa country code is '27'. Total digits typically 11 (27 + 9 digits).
        // Spec: "contains the international country code followed by the number, which is no more than ten characters long."
        return this.phoneNumber.startsWith("27") && this.phoneNumber.length() <= 12; 
    }

    /**
     * Returns the necessary registration messaging based on formatting checks.
     */
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    /**
     * Verifies that the login details entered match the stored details.
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (this.username == null || this.password == null) return false;
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    /**
     * Returns the necessary messaging for a successful or failed login.
     */
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + this.firstName + ", " + this.lastName + " it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }}
