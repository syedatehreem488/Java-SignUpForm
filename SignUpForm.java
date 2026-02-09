import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpForm extends JFrame {
    private JTextField userField, phoneField, cnicField;
    private JPasswordField passField;
    private JButton okButton, cancelButton;

    public SignUpForm() {
        setTitle("Sign Up");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("UserName:");
        userLabel.setBounds(20, 20, 100, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(130, 20, 180, 25);
        add(userField);

        JLabel phoneLabel = new JLabel("Phone #:");
        phoneLabel.setBounds(20, 60, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(130, 60, 180, 25);
        add(phoneField);

        JLabel cnicLabel = new JLabel("CNIC:");
        cnicLabel.setBounds(20, 100, 100, 25);
        add(cnicLabel);

        cnicField = new JTextField();
        cnicField.setBounds(130, 100, 180, 25);
        add(cnicField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 140, 100, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(130, 140, 180, 25);
        add(passField);

        okButton = new JButton("OK");
        okButton.setBounds(80, 180, 80, 25);
        add(okButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 180, 90, 25);
        add(cancelButton);

        okButton.addActionListener(e -> saveUser());
        cancelButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void saveUser() {
        String user = userField.getText();
        String phone = phoneField.getText();
        String cnic = cnicField.getText();
        String pass = new String(passField.getPassword());

        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write(user + "," + phone + "," + cnic + "," + pass + "\n");
            JOptionPane.showMessageDialog(this, "Registration Successful!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignUpForm();
    }
}
