package controller;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.PasswordHasher;

public class HomeController {
    @FXML
    private TextField txtWeak;
    @FXML
    private TextField pwdMedium;
    @FXML
    private TextField pwdStrong;
    @FXML
    private TextField txtAdd;
    @FXML
    private PasswordField pwdShto;
    @FXML
    private TextField txtEncrypt;

    @FXML
    private void handleWeak() {
        String password = generateWeakPassword();
        txtWeak.setText(password);
    }

    @FXML
    private void handleMedium() {
        String password = generateMediumPassword();
        pwdMedium.setText(password);
    }

    @FXML
    private void handleStrong() {
        String password = generateStrongPassword();
        pwdStrong.setText(password);
    }

    @FXML
    private void handleAdd() {
        String password = pwdShto.getText(); // Get password from the password field
        String salt = PasswordHasher.generateSalt();
        String encrypted = PasswordHasher.generateSaltedHash(password, salt);
        txtEncrypt.setText(encrypted);
    }

    private String generateWeakPassword() {
        String password = "";
        for (int i = 0; i < 6; i++) {
            password += (char) ((int) (Math.random() * 26) + 'a');
        }
        return password;
    }

    private char generateRandomSpecialChar() {
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

    private String generateMediumPassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += (char) ((int) (Math.random() * 26) + generateRandomUppercaseLetter());
        }
        return password;
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
}