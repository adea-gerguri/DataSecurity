package controller;

import app.Navigator;
import database.DatabaseUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.dto.UserDto;
import service.DBConnector;
import service.UserService;
import controller.HomeController;
import java.sql.*;

public class SignUpController {
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private PasswordField pwdConfirmPassword;
    @FXML
    private TextField txtSuggested;

    @FXML
    private void initialize() {
        txtSuggested.setText(generateStrongPassword());
    }
    @FXML
    private void handleSignUp(ActionEvent ae) {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText();
        String password = pwdPassword.getText();
        String confirmPassword = pwdConfirmPassword.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            System.out.println("Please fill in all the fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            System.out.println("Password and confirm password do not match.");
            return;
        }

        UserDto userSignUpData = new UserDto(firstName, lastName, email, password, confirmPassword);


        boolean response = UserService.signUp(userSignUpData);
        System.out.println("Response: " + response);


        Navigator.navigate(ae, Navigator.LOGIN_PAGE);
    }
    @FXML
    private void handleCancel(ActionEvent ae) {
        txtFirstName.clear();
        txtLastName.clear();
        txtEmail.clear();
        pwdPassword.clear();
        pwdConfirmPassword.clear();
    }
    private String generateStrongPassword() {
        String password = "";
        for (int i = 0; i < 10; i++) {
            password += (char) ((int) (Math.random() * 26) + generateRandomSpecialChar() +
                    generateRandomUppercaseLetter() +
                    generateRandomSpecialChar() +
                    generateRandomUppercaseLetter());
        }
        return password;
    }
    public char generateRandomSpecialChar() {
        int minAscii = 33;
        int maxAscii = 126;
        int randomAscii = (int) (Math.random() * (maxAscii - minAscii + 1) + minAscii);
        return (char) randomAscii;
    }

    private char generateRandomUppercaseLetter() {
        int minAscii = 65;
        int maxAscii = 90;
        int randomAscii = (int) (Math.random() * (maxAscii - minAscii + 1) + minAscii);
        return (char) randomAscii;
    }


}