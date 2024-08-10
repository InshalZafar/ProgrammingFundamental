import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IceCreamParlour extends JFrame {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] flavors = {"Vanilla", "Chocolate", "Strawberry", "Mango", "Butterscotch", "Pistachio", "Coffee", "Mint", "Blueberry", "Raspberry"};
    private static final double[] flavorPrices = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
    private static final int[] flavorStockCones = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
    private static final int[] flavorStockCups = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
    private static final String adminEmail = "inshal2003@gmail.com";
    private static final String adminPassword = "inshal234";
    private static final String customerFile = "customers.txt";
    private static final String orderFile = "orders.txt";
    private static final String[] addons = {"Chocolate Syrup", "Pineapple Syrup", "Chocolate Chunks", "Cherry"};
    private static final double[] addonPrices = {10, 15, 25, 5};
    private static double wallet = 0.0;
    private static int orderNumber = 1;

    public IceCreamParlour() {
        // Setup the main frame
        setTitle("Ice Cream Parlor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mainMenu();
    }

    private void mainMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton adminLoginButton = new JButton("Admin Login");
        adminLoginButton.addActionListener(e -> adminLogin());

        JButton customerRegButton = new JButton("Customer Registration");
        customerRegButton.addActionListener(e -> customerRegistration());

        JButton customerLoginButton = new JButton("Customer Login");
        customerLoginButton.addActionListener(e -> customerLogin());

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(adminLoginButton);
        panel.add(customerRegButton);
        panel.add(customerLoginButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    private void adminLogin() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Admin Login", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (email.equals(adminEmail) && password.equals(adminPassword)) {
                adminMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
            }
        }
    }

    private void adminMenu() {
        JPanel panel = new JPanel(new GridLayout(7, 1));

        JButton manageCustomersButton = new JButton("Manage Customers");
        // Add action listener to manage customers button

        JButton manageFlavorsButton = new JButton("Manage Flavors");
        // Add action listener to manage flavors button

        JButton manageAddonsButton = new JButton("Manage Addons");
        // Add action listener to manage addons button

        JButton manageShakesButton = new JButton("Manage Shakes");
        // Add action listener to manage shakes button

        JButton viewWalletButton = new JButton("View Wallet");
        viewWalletButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Total Wallet: " + wallet));

        JButton receiptsButton = new JButton("Receipts");
        // Add action listener to receipts button

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> mainMenu());

        panel.add(manageCustomersButton);
        panel.add(manageFlavorsButton);
        panel.add(manageAddonsButton);
        panel.add(manageShakesButton);
        panel.add(viewWalletButton);
        panel.add(receiptsButton);
        panel.add(logoutButton);

        setContentPane(panel);
        revalidate();
    }

    private void customerRegistration() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Customer Registration", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String password = new String(passwordField.getPassword());

            if (isValidEmail(email) && isValidPhone(phone) && isValidName(name)) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(customerFile, true))) {
                    bw.write(name + " " + email + " " + phone + " " + password);
                    bw.newLine();
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error writing to customer file: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email, phone number, or name. Please try again.");
            }
        }
    }

    private void customerLogin() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Customer Login", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (validateCustomer(email, password)) {
                customerMenu(email);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
            }
        }
    }

    private void customerMenu(String email) {
        // Implementation for customer menu in GUI
    }

    private boolean validateCustomer(String email, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts[1].equals(email) && parts[3].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading customer file: " + e.getMessage());
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        return Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$").matcher(email).matches();
    }

    private boolean isValidPhone(String phone) {
        return Pattern.compile("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$").matcher(phone).matches();
    }

    private boolean isValidName(String name) {
        return name.matches("^[a-zA-Z\\s]+$");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IceCreamParlour().setVisible(true));
    }
}
