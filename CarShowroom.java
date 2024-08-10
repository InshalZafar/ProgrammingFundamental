// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;
// import java.text.SimpleDateFormat;
// import java.util.*;

// public class CarShowroom extends JFrame {
//     static final String USERS_FILE = "users.txt";
//     static final String CARS_FILE = "cars.txt";
//     static final String INVOICE_FILE = "invoices.txt";

//     static String[] users = new String[100];
//     static String[] carsCollection = new String[100];
//     static double[][] carStats = new double[100][4];
//     static String[] userRegistration = new String[5];
//     static String[] userLogin = new String[2];

//     private CardLayout cardLayout;
//     private JPanel mainPanel;

//     public CarShowroom() {
//         setTitle("Car Showroom");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(400, 300);
//         setLocationRelativeTo(null);

//         // Set background image
//         JLabel background = new JLabel(new ImageIcon("C:\\Users\\PMLS\\Desktop\\semester 3\\2nd semester\\pf\\sem project pf\\images.jpeg\"));
//         setContentPane(background);
//         setLayout(new BorderLayout());
        
//         cardLayout = new CardLayout();
//         mainPanel = new JPanel(cardLayout);
        
//         // Add main menu
//         JPanel mainMenu = createMainMenu();
//         mainPanel.add(mainMenu, "MainMenu");

//         // Add admin section
//         JPanel adminPanel = createAdminPanel();
//         mainPanel.add(adminPanel, "AdminSection");

//         // Add customer section
//         JPanel customerPanel = createCustomerPanel();
//         mainPanel.add(customerPanel, "CustomerSection");

//         add(mainPanel, BorderLayout.CENTER);

//         // Show main menu
//         cardLayout.show(mainPanel, "MainMenu");

//         addLocalCars();
//     }

//     private JPanel createMainMenu() {
//         JPanel panel = new JPanel();
//         panel.setLayout(new GridLayout(4, 1));

//         JLabel title = new JLabel("Welcome to Car Showroom!", SwingConstants.CENTER);
//         title.setFont(new Font("Arial", Font.BOLD, 24));
//         panel.add(title);

//         JButton adminButton = new JButton("Admin Section");
//         adminButton.addActionListener(e -> cardLayout.show(mainPanel, "AdminSection"));
//         panel.add(adminButton);

//         JButton customerButton = new JButton("Customer Section");
//         customerButton.addActionListener(e -> cardLayout.show(mainPanel, "CustomerSection"));
//         panel.add(customerButton);

//         JButton exitButton = new JButton("Exit");
//         exitButton.addActionListener(e -> System.exit(0));
//         panel.add(exitButton);

//         return panel;
//     }

//     private JPanel createAdminPanel() {
//         JPanel panel = new JPanel(new BorderLayout());
//         panel.setLayout(new GridLayout(3, 1));

//         JLabel title = new JLabel("Admin Section", SwingConstants.CENTER);
//         title.setFont(new Font("Arial", Font.BOLD, 24));
//         panel.add(title, BorderLayout.NORTH);

//         JButton loginButton = new JButton("Login");
//         loginButton.addActionListener(e -> adminLogin());
//         panel.add(loginButton, BorderLayout.CENTER);

//         JButton backButton = new JButton("Back to Main Menu");
//         backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
//         panel.add(backButton, BorderLayout.SOUTH);

//         return panel;
//     }

//     private JPanel createCustomerPanel() {
//         JPanel panel = new JPanel(new BorderLayout());
//         panel.setLayout(new GridLayout(3, 1));

//         JLabel title = new JLabel("Customer Section", SwingConstants.CENTER);
//         title.setFont(new Font("Arial", Font.BOLD, 24));
//         panel.add(title, BorderLayout.NORTH);

//         JButton registerButton = new JButton("Register");
//         registerButton.addActionListener(e -> registration());
//         panel.add(registerButton, BorderLayout.CENTER);

//         JButton loginButton = new JButton("Login");
//         loginButton.addActionListener(e -> login());
//         panel.add(loginButton, BorderLayout.CENTER);

//         JButton backButton = new JButton("Back to Main Menu");
//         backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
//         panel.add(backButton, BorderLayout.SOUTH);

//         return panel;
//     }

//     private void adminLogin() {
//         String[][] adminInformation = {
//             {"hamza@gmail.com", "Hamza123"},
//             {"Aqeel@gmail.com", "Aqeel123"},
//             {"Abdullah@gmail.com", "Abdullah123"},
//             {"Inshaal@gmail.com", "Inshaal123"},
//         };

//         JPanel loginPanel = new JPanel(new GridLayout(3, 2));
//         JTextField emailField = new JTextField();
//         JPasswordField passwordField = new JPasswordField();
//         JLabel statusLabel = new JLabel();

//         loginPanel.add(new JLabel("Email:"));
//         loginPanel.add(emailField);
//         loginPanel.add(new JLabel("Password:"));
//         loginPanel.add(passwordField);

//         int result = JOptionPane.showConfirmDialog(this, loginPanel, "Admin Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//         if (result == JOptionPane.OK_OPTION) {
//             String email = emailField.getText();
//             String password = new String(passwordField.getPassword());
//             boolean isAuthenticated = false;

//             for (String[] admin : adminInformation) {
//                 if (admin[0].equals(email) && admin[1].equals(password)) {
//                     isAuthenticated = true;
//                     break;
//                 }
//             }

//             if (isAuthenticated) {
//                 statusLabel.setText("Login successful!");
//                 adminChoices();
//             } else {
//                 statusLabel.setText("Invalid email or password.");
//             }
//         }
//     }

//     private void adminChoices() {
//         JPanel adminPanel = new JPanel(new GridLayout(7, 1));

//         adminPanel.add(new JLabel("Admin Section", SwingConstants.CENTER));

//         JButton showAllRecordsButton = new JButton("Show All Records");
//         showAllRecordsButton.addActionListener(e -> showReport());
//         adminPanel.add(showAllRecordsButton);

//         JButton showUserInfoButton = new JButton("Show User Information");
//         showUserInfoButton.addActionListener(e -> showUserInformation());
//         adminPanel.add(showUserInfoButton);

//         JButton addCarButton = new JButton("Add Car");
//         addCarButton.addActionListener(e -> addCar());
//         adminPanel.add(addCarButton);

//         JButton searchCarButton = new JButton("Search Car");
//         searchCarButton.addActionListener(e -> searchCar());
//         adminPanel.add(searchCarButton);

//         JButton deleteCarButton = new JButton("Delete Car");
//         deleteCarButton.addActionListener(e -> deleteCar());
//         adminPanel.add(deleteCarButton);

//         JButton displayAvailableCarsButton = new JButton("Display Available Cars");
//         displayAvailableCarsButton.addActionListener(e -> displayAvailableCars());
//         adminPanel.add(displayAvailableCarsButton);

//         JButton backButton = new JButton("Back to Main Menu");
//         backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
//         adminPanel.add(backButton);

//         JOptionPane.showMessageDialog(this, adminPanel, "Admin Choices", JOptionPane.PLAIN_MESSAGE);
//     }

//     private void showUserInformation() {
//         String[][] userInformation = readUsersInformation();
//         StringBuilder userInfoString = new StringBuilder("User Information:\n");

//         for (String[] userInfo : userInformation) {
//             if (userInfo[0] != null) {
//                 userInfoString.append("Email: ").append(userInfo[0]).append(", Password: ").append(userInfo[1]).append("\n");
//             }
//         }

//         JOptionPane.showMessageDialog(this, userInfoString.toString(), "User Information", JOptionPane.INFORMATION_MESSAGE);
//     }

//     private String[][] readUsersInformation() {
//         int numUsers = countLines("users.txt");
//         String[][] usersInformation = new String[numUsers][2];
//         try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
//             String line;
//             int index = 0;
//             while ((line = reader.readLine()) != null) {
//                 String[] userInfo = line.split(",\\s*");
//                 if (userInfo.length >= 2) {
//                     usersInformation[index++] = userInfo;
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error reading file: " + e.getMessage());
//         }
//         return usersInformation;
//     }

//     private int countLines(String filename) {
//         int lines = 0;
//         try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//             while (reader.readLine() != null) {
//                 lines++;
//             }
//         } catch (IOException e) {
//             System.out.println("Error counting lines: " + e.getMessage());
//         }
//         return lines;
//     }

//     private void addCar() {
//         JTextField carNameField = new JTextField();
//         JTextField transmissionTypeField = new JTextField();
//         JTextField colorsField = new JTextField();
//         JTextField priceField = new JTextField();
//         JTextField quantityField = new JTextField();

//         JPanel addCarPanel = new JPanel(new GridLayout(6, 2));
//         addCarPanel.add(new JLabel("Car Name:"));
//         addCarPanel.add(carNameField);
//         addCarPanel.add(new JLabel("Transmission Type (A/M):"));
//         addCarPanel.add(transmissionTypeField);
//         addCarPanel.add(new JLabel("Colors (comma separated):"));
//         addCarPanel.add(colorsField);
//         addCarPanel.add(new JLabel("Price:"));
//         addCarPanel.add(priceField);
//         addCarPanel.add(new JLabel("Quantity:"));
//         addCarPanel.add(quantityField);

//         int result = JOptionPane.showConfirmDialog(this, addCarPanel, "Add Car", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//         if (result == JOptionPane.OK_OPTION) {
//             try {
//                 String carName = carNameField.getText();
//                 char transmissionType = Character.toUpperCase(transmissionTypeField.getText().charAt(0));
//                 String[] colors = colorsField.getText().split(",");
//                 double price = Double.parseDouble(priceField.getText());
//                 int quantity = Integer.parseInt(quantityField.getText());

//                 for (int i = 0; i < carsCollection.length; i++) {
//                     if (carsCollection[i] == null) {
//                         carsCollection[i] = carName;
//                         carStats[i][0] = price;
//                         carStats[i][1] = quantity;
//                         carStats[i][2] = colors.length;
//                         carStats[i][3] = (transmissionType == 'A') ? 1 : 0;
//                         break;
//                     }
//                 }
//                 writeCarsToFile();
//                 JOptionPane.showMessageDialog(this, "Car added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                 displayAvailableCars();
//             } catch (Exception e) {
//                 JOptionPane.showMessageDialog(this, "Error adding car: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//             }
//         }
//     }

//     private void displayAvailableCars() {
//         StringBuilder carsInfo = new StringBuilder("Available Cars:\n");

//         for (int i = 0; i < carsCollection.length; i++) {
//             if (carsCollection[i] != null) {
//                 int displayNumber = i + 1;
//                 carsInfo.append(displayNumber).append(". ").append(carsCollection[i]).append("\n");
//                 carsInfo.append("Quantity: ").append((int) carStats[i][1]).append("\n");
//                 carsInfo.append("Available Colors: ").append((int) carStats[i][2]).append("\n");
//                 carsInfo.append("Transmission Type: ").append((carStats[i][3] == 1) ? "Automatic" : "Manual").append("\n");
//                 carsInfo.append("Initial Price: $").append(carStats[i][0]).append("\n");
//                 carsInfo.append("------------------------------\n");
//             }
//         }

//         JOptionPane.showMessageDialog(this, carsInfo.toString(), "Available Cars", JOptionPane.INFORMATION_MESSAGE);
//     }

//     private void deleteCar() {
//         JTextField carNumberField = new JTextField();

//         JPanel deleteCarPanel = new JPanel(new GridLayout(2, 2));
//         deleteCarPanel.add(new JLabel("Enter car number to delete:"));
//         deleteCarPanel.add(carNumberField);

//         int result = JOptionPane.showConfirmDialog(this, deleteCarPanel, "Delete Car", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//         if (result == JOptionPane.OK_OPTION) {
//             try {
//                 int carNumber = Integer.parseInt(carNumberField.getText());

//                 if (carNumber >= 1 && carNumber <= carsCollection.length && carsCollection[carNumber - 1] != null) {
//                     for (int i = carNumber - 1; i < carsCollection.length - 1; i++) {
//                         carsCollection[i] = carsCollection[i + 1];
//                         carStats[i] = Arrays.copyOf(carStats[i + 1], carStats[i + 1].length);
//                     }

//                     carsCollection[carsCollection.length - 1] = null;
//                     carStats[carsCollection.length - 1] = new double[4];

//                     writeCarsToFile();
//                     JOptionPane.showMessageDialog(this, "Car deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                     displayAvailableCars();
//                 } else {
//                     JOptionPane.showMessageDialog(this, "Invalid car number.", "Error", JOptionPane.ERROR_MESSAGE);
//                 }
//             } catch (Exception e) {
//                 JOptionPane.showMessageDialog(this, "Error deleting car: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//             }
//         }
//     }

//     private void searchCar() {
//         JTextField carNameField = new JTextField();

//         JPanel searchCarPanel = new JPanel(new GridLayout(2, 2));
//         searchCarPanel.add(new JLabel("Enter car name to search:"));
//         searchCarPanel.add(carNameField);

//         int result = JOptionPane.showConfirmDialog(this, searchCarPanel, "Search Car", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//         if (result == JOptionPane.OK_OPTION) {
//             String carName = carNameField.getText();
//             StringBuilder carInfo = new StringBuilder();
//             boolean found = false;

//             for (int i = 0; i < carsCollection.length; i++) {
//                 if (carsCollection[i] != null && carsCollection[i].contains(carName)) {
//                     carInfo.append("Car found: ").append(carsCollection[i]).append("\n");
//                     carInfo.append("Quantity: ").append((int) carStats[i][1]).append("\n");
//                     carInfo.append("Available Colors: ").append((int) carStats[i][2]).append("\n");
//                     carInfo.append("Transmission Type: ").append((carStats[i][3] == 1) ? "Automatic" : "Manual").append("\n");
//                     carInfo.append("Initial Price: $").append(carStats[i][0]).append("\n");
//                     carInfo.append("------------------------------\n");
//                     found = true;
//                     break;
//                 }
//             }

//             if (found) {
//                 JOptionPane.showMessageDialog(this, carInfo.toString(), "Car Found", JOptionPane.INFORMATION_MESSAGE);
//             } else {
//                 JOptionPane.showMessageDialog(this, "Car not found.", "Error", JOptionPane.ERROR_MESSAGE);
//             }
//         }
//     }

//     private void showReport() {
//         try {
//             if (fileExists(INVOICE_FILE)) {
//                 BufferedReader reader = new BufferedReader(new FileReader(INVOICE_FILE));
//                 String line;
//                 StringBuilder report = new StringBuilder("-------- All Invoices --------\n");

//                 while ((line = reader.readLine()) != null) {
//                     report.append(line).append("\n");
//                 }

//                 reader.close();
//                 JOptionPane.showMessageDialog(this, report.toString(), "All Invoices", JOptionPane.INFORMATION_MESSAGE);
//             } else {
//                 JOptionPane.showMessageDialog(this, "No invoices available.", "Info", JOptionPane.INFORMATION_MESSAGE);
//             }
//         } catch (IOException e) {
//             JOptionPane.showMessageDialog(this, "Error reading invoices: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//         }
//     }

//     private boolean fileExists(String filePath) {
//         return new File(filePath).exists();
//     }

//     private void addLocalCars() {
//         carsCollection[0] = "Toyota Corolla GLI";
//         carsCollection[1] = "Honda Civic";
//         carsCollection[2] = "Suzuki Mehran";
//         carsCollection[3] = "Suzuki Cultus";
//         carsCollection[4] = "Toyota Corolla XLI";
//         carsCollection[5] = "Toyota Corolla Grande";
//         carsCollection[6] = "Honda Civic Reborn";
//         carsCollection[7] = "Honda City";
//         carsCollection[8] = "Toyota Camry";
//         carsCollection[9] = "Honda Accord";

//         readCarsInformation();
//         double randomPrice = generateRandomPrice();
//         double defaultPrice = 1500000.0; // Set your default price here
//         for (int i = 0; i < carsCollection.length; i++) {
//             if (carsCollection[i] != null) {
//                 if (carStats[i][1] == 0) {
//                     carStats[i][1] = 10; // Set initial quantity
//                 }

//                 carStats[i][0] = generateRandomPrice(); // Set initial price
//                 carStats[i][2] = 2; // Set available colors (assuming 2 colors available for each local car)
//                 carStats[i][3] = 0; // Placeholder for transmission type (0 for now, you can update it later)
//             }
//         }
//     }

//     private void readCarsInformation() {
//         try (BufferedReader reader = new BufferedReader(new FileReader(CARS_FILE))) {
//             String line;
//             int index = 0;
//             while ((line = reader.readLine()) != null) {
//                 String[] carInfo = line.split(",");
//                 if (carInfo.length == 5) {
//                     carsCollection[index] = carInfo[0];
//                     carStats[index][0] = Double.parseDouble(carInfo[1]);
//                     carStats[index][2] = Double.parseDouble(carInfo[3]);
//                     carStats[index][3] = Double.parseDouble(carInfo[4]);
//                     index++;
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error reading car information from file: " + e.getMessage());
//         }
//     }

//     private void writeCarsToFile() {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(CARS_FILE))) {
//             for (int i = 0; i < carsCollection.length; i++) {
//                 if (carsCollection[i] != null) {
//                     writer.write(carsCollection[i] + "," + carStats[i][0] + "," + carStats[i][1] + "," + carStats[i][2] + "," + carStats[i][3]);
//                     writer.newLine();
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error writing cars to file: " + e.getMessage());
//         }
//     }

//     private void registration() {
//         JPanel registrationPanel = new JPanel(new GridLayout(8, 2));

//         JTextField firstNameField = new JTextField();
//         JTextField lastNameField = new JTextField();
//         JTextField contactField = new JTextField();
//         JTextField emailField = new JTextField();
//         JPasswordField passwordField = new JPasswordField();
//         JPasswordField confirmPasswordField = new JPasswordField();
//         JTextField ageField = new JTextField();

//         registrationPanel.add(new JLabel("First Name:"));
//         registrationPanel.add(firstNameField);
//         registrationPanel.add(new JLabel("Last Name:"));
//         registrationPanel.add(lastNameField);
//         registrationPanel.add(new JLabel("Contact:"));
//         registrationPanel.add(contactField);
//         registrationPanel.add(new JLabel("Email:"));
//         registrationPanel.add(emailField);
//         registrationPanel.add(new JLabel("Password:"));
//         registrationPanel.add(passwordField);
//         registrationPanel.add(new JLabel("Confirm Password:"));
//         registrationPanel.add(confirmPasswordField);
//         registrationPanel.add(new JLabel("Age:"));
//         registrationPanel.add(ageField);

//         int result = JOptionPane.showConfirmDialog(this, registrationPanel, "User Registration", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//         if (result == JOptionPane.OK_OPTION) {
//             try {
//                 String firstName = firstNameField.getText();
//                 String lastName = lastNameField.getText();
//                 String contact = contactField.getText();
//                 String email = emailField.getText();
//                 String password = new String(passwordField.getPassword());
//                 String confirmPassword = new String(confirmPasswordField.getPassword());
//                 int age = Integer.parseInt(ageField.getText());

//                 if (!password.equals(confirmPassword)) {
//                     JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
//                     return;
//                 }

//                 if (age < 18 || age > 70) {
//                     JOptionPane.showMessageDialog(this, "Invalid age. Age must be between 18 and 100.", "Error", JOptionPane.ERROR_MESSAGE);
//                     return;
//                 }

//                 if (isEmailExists(email)) {
//                     JOptionPane.showMessageDialog(this, "Email already exists. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
//                     return;
//                 }

//                 userRegistration[0] = firstName;
//                 userRegistration[1] = lastName;
//                 userRegistration[2] = contact;
//                 userRegistration[3] = email;
//                 userRegistration[4] = password;

//                 writeUserToFile(userRegistration);
//                 JOptionPane.showMessageDialog(this, "Registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//             } catch (Exception e) {
//                 JOptionPane.showMessageDialog(this, "Error during registration: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//             }
//         }
//     }

//     private boolean isEmailExists(String email) {
//         try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] userData = line.split(", ");
//                 if (userData.length == 2 && userData[0].equals(email)) {
//                     return true; // Email already exists
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error reading file: " + e.getMessage());
//         }
//         return false; // Email does not exist
//     }

//     private void writeUserToFile(String[] userRegistration) {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
//             String userData = userRegistration[3] + ", " + userRegistration[4] + "\n";
//             writer.write(userData);
//         } catch (IOException e) {
//             System.out.println("Error writing to file: " + e.getMessage());
//         }
//     }

//     private void login() {
//         JPanel loginPanel = new JPanel(new GridLayout(3, 2));
//         JTextField emailField = new JTextField();
//         JPasswordField passwordField = new JPasswordField();

//         loginPanel.add(new JLabel("Email:"));
//         loginPanel.add(emailField);
//         loginPanel.add(new JLabel("Password:"));
//         loginPanel.add(passwordField);

//         int result = JOptionPane.showConfirmDialog(this, loginPanel, "Customer Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//         if (result == JOptionPane.OK_OPTION) {
//             String email = emailField.getText();
//             String password = new String(passwordField.getPassword());

//             userLogin[0] = email;
//             userLogin[1] = password;

//             if (checkUserCredentials(userLogin)) {
//                 JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                 customerChoices();
//             } else {
//                 JOptionPane.showMessageDialog(this, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
//             }
//         }
//     }

//     private boolean checkUserCredentials(String[] userLogin) {
//         try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] userData = line.split(", ");
//                 if (userData.length == 2 && userData[0].equals(userLogin[0]) && userData[1].equals(userLogin[1])) {
//                     return true;
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error reading file: " + e.getMessage());
//         }
//         return false;
//     }

//     private void customerChoices() {
//         JPanel customerPanel = new JPanel(new GridLayout(4, 1));

//         customerPanel.add(new JLabel("Customer Section", SwingConstants.CENTER));

//         JButton purchaseCarButton = new JButton("Purchase a Car");
//         purchaseCarButton.addActionListener(e -> purchaseCar());
//         customerPanel.add(purchaseCarButton);

//         JButton showAvailableCarsButton = new JButton("Show Available Cars");
//         showAvailableCarsButton.addActionListener(e -> displayAvailableCars());
//         customerPanel.add(showAvailableCarsButton);

//         JButton backButton = new JButton("Back to Main Menu");
//         backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
//         customerPanel.add(backButton);

//         JOptionPane.showMessageDialog(this, customerPanel, "Customer Choices", JOptionPane.PLAIN_MESSAGE);
//     }

//     private void purchaseCar() {
//         JTextField carNumberField = new JTextField();
//         JTextField transmissionTypeField = new JTextField();
//         JTextField colorField = new JTextField();
//         JTextField filerStatusField = new JTextField();

//         JPanel purchaseCarPanel = new JPanel(new GridLayout(5, 2));
//         purchaseCarPanel.add(new JLabel("Car Number:"));
//         purchaseCarPanel.add(carNumberField);
//         purchaseCarPanel.add(new JLabel("Transmission Type (A/M):"));
//         purchaseCarPanel.add(transmissionTypeField);
//         purchaseCarPanel.add(new JLabel("Color (B for Black, W for White):"));
//         purchaseCarPanel.add(colorField);
//         purchaseCarPanel.add(new JLabel("Are you a filer? (1 for Yes, 0 for No):"));
//         purchaseCarPanel.add(filerStatusField);

//         int result = JOptionPane.showConfirmDialog(this, purchaseCarPanel, "Purchase Car", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//         if (result == JOptionPane.OK_OPTION) {
//             try {
//                 int carNumber = Integer.parseInt(carNumberField.getText());
//                 char transmissionType = Character.toUpperCase(transmissionTypeField.getText().charAt(0));
//                 String color = colorField.getText().trim().toLowerCase();
//                 int filerStatus = Integer.parseInt(filerStatusField.getText());

//                 if (carNumber >= 1 && carNumber <= carsCollection.length && carsCollection[carNumber - 1] != null) {
//                     String selectedCarName = carsCollection[carNumber - 1];
//                     double basePrice = carStats[carNumber - 1][0];
//                     int quantity = (int) carStats[carNumber - 1][1];

//                     if (quantity > 0) {
//                         double totalPrice = calculateTotalPrice(basePrice, transmissionType, filerStatus);
//                         String message = String.format("Total Price: $%.2f\nPlease confirm the purchase.", totalPrice);
//                         int confirm = JOptionPane.showConfirmDialog(this, message, "Confirm Purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

//                         if (confirm == JOptionPane.OK_OPTION) {
//                             generateInvoice(selectedCarName, transmissionType, color, basePrice, filerStatus, totalPrice);
//                             carStats[carNumber - 1][1]--;
//                             writeCarsToFile();
//                             JOptionPane.showMessageDialog(this, "Thank you for your purchase!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                         }
//                     } else {
//                         JOptionPane.showMessageDialog(this, "Sorry, the selected car is out of stock.", "Out of Stock", JOptionPane.ERROR_MESSAGE);
//                     }
//                 } else {
//                     JOptionPane.showMessageDialog(this, "Invalid car number.", "Error", JOptionPane.ERROR_MESSAGE);
//                 }
//             } catch (Exception e) {
//                 JOptionPane.showMessageDialog(this, "Error during purchase: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//             }
//         }
//     }

//     private double calculateTotalPrice(double basePrice, char transmissionType, int filerStatus) {
//         double totalPrice = basePrice;
//         if (transmissionType == 'A') {
//             totalPrice += 10000;
//         }

//         if (filerStatus == 0) {
//             totalPrice += 0.17 * basePrice; // 17% tax for non-filer
//         } else {
//             totalPrice += 0.03 * basePrice; // 3% tax for filer
//         }

//         return totalPrice;
//     }

//     private void generateInvoice(String selectedCarName, char transmissionType, String color, double basePrice, int filerStatus, double totalPrice) {
//         try (PrintWriter writer = new PrintWriter(new FileWriter(INVOICE_FILE, true))) {
//             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//             String dateTime = dateFormat.format(new Date());
//             int invoiceNumber = generateRandomInvoiceNumber();

//             writer.println("**************************************************");
//             writer.println("*****            TOYOTA CROWN MOTORS         *****");
//             writer.println("**************************************************");
//             writer.println("\nINVOICE");
//             writer.write("Invoice Number:              " + invoiceNumber + "\n");
//             writer.println("\nDate and Time:           " + dateTime);
//             writer.println("\nCar Information:");
//             writer.println("-----------------------");
//             writer.println("Customer's Email:         " + userLogin[0]);
//             writer.println("Car Name:                 " + selectedCarName);
//             writer.println("Transmission Type:        " + getTransmissionType(transmissionType));
//             writer.println("Car Color:                " + color);
//             writer.println("Base Price:               $" + basePrice);
//             writer.println("Filer Status:             " + filerStatus);
//             writer.println("\nPayment Information:");
//             writer.println("-----------------------");
//             writer.println("Total Amount Due:         $" + totalPrice);
//             writer.println("\nThank you for choosing Toyota Crown Motors!");
//             writer.println("\n**************************************************");
//             writer.println("** Drive with Excellence **");
//             writer.println("**************************************************");
//             writer.println("Invoice Number: " + invoiceNumber++);
//             writer.println("----------");

//             System.out.println("Invoice generated successfully!");
//         } catch (IOException e) {
//             System.out.println("Error generating invoice: " + e.getMessage());
//         }
//     }

//     private String getTransmissionType(char transmissionType) {
//         return (transmissionType == 'A') ? "Automatic" : "Manual";
//     }

//     private int generateRandomInvoiceNumber() {
//         return new Random().nextInt(1000) + 1;
//     }

//     private double generateRandomPrice() {
//         Random random = new Random();
//         double minPrice = 700000.0;
//         double maxPrice = 3200000.0;

//         double randomPrice = minPrice + (maxPrice - minPrice) * random.nextDouble();
//         randomPrice = Math.round(randomPrice * 100) / 100;

//         return randomPrice;
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             CarShowroom carShowroom = new CarShowroom();
//             carShowroom.setVisible(true);
//         });
//     }
// }
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CarShowroom extends JFrame {
    static final String USERS_FILE = "users.txt";
    static final String CARS_FILE = "cars.txt";
    static final String INVOICE_FILE = "invoices.txt";

    static String[] users = new String[100];
    static String[] carsCollection = new String[100];
    static double[][] carStats = new double[100][4];
    static String[] userRegistration = new String[5];
    static String[] userLogin = new String[2];

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public CarShowroom() {
        setTitle("Car Showroom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Set background image
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\PMLS\\Desktop\\semester 3\\2nd semester\\pf\\sem project pf\\images.jpeg"));
        setContentPane(background);
        setLayout(new BorderLayout());
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // Add main menu
        JPanel mainMenu = createMainMenu();
        mainPanel.add(mainMenu, "MainMenu");

        // Add admin section
        JPanel adminPanel = createAdminPanel();
        mainPanel.add(adminPanel, "AdminSection");

        // Add customer section
        JPanel customerPanel = createCustomerPanel();
        mainPanel.add(customerPanel, "CustomerSection");

        add(mainPanel, BorderLayout.CENTER);

        // Show main menu
        cardLayout.show(mainPanel, "MainMenu");

        addLocalCars();
    }

    private JPanel createMainMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel title = new JLabel("Welcome to Car Showroom!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);

        JButton adminButton = new JButton("Admin Section");
        adminButton.addActionListener(e -> cardLayout.show(mainPanel, "AdminSection"));
        panel.add(adminButton);

        JButton customerButton = new JButton("Customer Section");
        customerButton.addActionListener(e -> cardLayout.show(mainPanel, "CustomerSection"));
        panel.add(customerButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        return panel;
    }

    private JPanel createAdminPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(new GridLayout(4, 1)); // Changed to organize vertically

        JLabel title = new JLabel("Admin Section", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> adminLogin());
        panel.add(loginButton, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createCustomerPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(new GridLayout(4, 1)); // Changed to organize vertically

        JLabel title = new JLabel("Customer Section", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> registration());
        panel.add(registerButton, BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> login());
        panel.add(loginButton, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private void adminLogin() {
        String[][] adminInformation = {
            {"hamza@gmail.com", "Hamza123"},
            {"Aqeel@gmail.com", "Aqeel123"},
            {"Abdullah@gmail.com", "Abdullah123"},
            {"Inshaal@gmail.com", "Inshaal123"},
        };

        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JLabel statusLabel = new JLabel();

        loginPanel.add(new JLabel("Email:"));
        loginPanel.add(emailField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(this, loginPanel, "Admin Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            boolean isAuthenticated = false;

            for (String[] admin : adminInformation) {
                if (admin[0].equals(email) && admin[1].equals(password)) {
                    isAuthenticated = true;
                    break;
                }
            }

            if (isAuthenticated) {
                statusLabel.setText("Login successful!");
                adminChoices();
            } else {
                statusLabel.setText("Invalid email or password.");
            }
        }
    }

    private void adminChoices() {
        JPanel adminPanel = new JPanel(new GridLayout(8, 1)); // Increased to fit more options

        adminPanel.add(new JLabel("Admin Section", SwingConstants.CENTER));

        JButton showAllRecordsButton = new JButton("Show All Records");
        showAllRecordsButton.addActionListener(e -> showReport());
        adminPanel.add(showAllRecordsButton);

        JButton showUserInfoButton = new JButton("Show User Information");
        showUserInfoButton.addActionListener(e -> showUserInformation());
        adminPanel.add(showUserInfoButton);

        JButton addCarButton = new JButton("Add Car");
        addCarButton.addActionListener(e -> addCar());
        adminPanel.add(addCarButton);

        JButton searchCarButton = new JButton("Search Car");
        searchCarButton.addActionListener(e -> searchCar());
        adminPanel.add(searchCarButton);

        JButton deleteCarButton = new JButton("Delete Car");
        deleteCarButton.addActionListener(e -> deleteCar());
        adminPanel.add(deleteCarButton);

        JButton displayAvailableCarsButton = new JButton("Display Available Cars");
        displayAvailableCarsButton.addActionListener(e -> displayAvailableCars());
        adminPanel.add(displayAvailableCarsButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        adminPanel.add(backButton);

        JOptionPane.showMessageDialog(this, adminPanel, "Admin Choices", JOptionPane.PLAIN_MESSAGE);
    }

    private void showUserInformation() {
        String[][] userInformation = readUsersInformation();
        StringBuilder userInfoString = new StringBuilder("User Information:\n");

        for (String[] userInfo : userInformation) {
            if (userInfo[0] != null) {
                userInfoString.append("Email: ").append(userInfo[0]).append(", Password: ").append(userInfo[1]).append("\n");
            }
        }

        JOptionPane.showMessageDialog(this, userInfoString.toString(), "User Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private String[][] readUsersInformation() {
        int numUsers = countLines(USERS_FILE);
        String[][] usersInformation = new String[numUsers][2];
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(",\\s*");
                if (userInfo.length >= 2) {
                    usersInformation[index++] = userInfo;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return usersInformation;
    }

    private int countLines(String filename) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            System.out.println("Error counting lines: " + e.getMessage());
        }
        return lines;
    }

    private void addCar() {
        JTextField carNameField = new JTextField();
        JTextField transmissionTypeField = new JTextField();
        JTextField colorsField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField quantityField = new JTextField();

        JPanel addCarPanel = new JPanel(new GridLayout(6, 2));
        addCarPanel.add(new JLabel("Car Name:"));
        addCarPanel.add(carNameField);
        addCarPanel.add(new JLabel("Transmission Type (A/M):"));
        addCarPanel.add(transmissionTypeField);
        addCarPanel.add(new JLabel("Colors (comma separated):"));
        addCarPanel.add(colorsField);
        addCarPanel.add(new JLabel("Price:"));
        addCarPanel.add(priceField);
        addCarPanel.add(new JLabel("Quantity:"));
        addCarPanel.add(quantityField);

        int result = JOptionPane.showConfirmDialog(this, addCarPanel, "Add Car", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String carName = carNameField.getText();
                char transmissionType = Character.toUpperCase(transmissionTypeField.getText().charAt(0));
                String[] colors = colorsField.getText().split(",");
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                for (int i = 0; i < carsCollection.length; i++) {
                    if (carsCollection[i] == null) {
                        carsCollection[i] = carName;
                        carStats[i][0] = price;
                        carStats[i][1] = quantity;
                        carStats[i][2] = colors.length;
                        carStats[i][3] = (transmissionType == 'A') ? 1 : 0;
                        break;
                    }
                }
                writeCarsToFile();
                JOptionPane.showMessageDialog(this, "Car added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                displayAvailableCars();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error adding car: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayAvailableCars() {
        JPanel carsPanel = new JPanel(new GridLayout(0, 1));

        for (int i = 0; i < carsCollection.length; i++) {
            if (carsCollection[i] != null) {
                int displayNumber = i + 1;
                String carInfo = String.format(
                    "<html><b>%d. %s</b><br>Quantity: %d<br>Available Colors: %d<br>Transmission Type: %s<br>Initial Price: $%.2f<br>------------------------------<br></html>",
                    displayNumber, carsCollection[i], (int) carStats[i][1], (int) carStats[i][2],
                    (carStats[i][3] == 1) ? "Automatic" : "Manual", carStats[i][0]
                );
                JLabel carLabel = new JLabel(carInfo);
                carsPanel.add(carLabel);
            }
        }

        JScrollPane scrollPane = new JScrollPane(carsPanel);
        scrollPane.setPreferredSize(new Dimension(350, 200));

        JOptionPane.showMessageDialog(this, scrollPane, "Available Cars", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteCar() {
        JTextField carNumberField = new JTextField();

        JPanel deleteCarPanel = new JPanel(new GridLayout(2, 2));
        deleteCarPanel.add(new JLabel("Enter car number to delete:"));
        deleteCarPanel.add(carNumberField);

        int result = JOptionPane.showConfirmDialog(this, deleteCarPanel, "Delete Car", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int carNumber = Integer.parseInt(carNumberField.getText());

                if (carNumber >= 1 && carNumber <= carsCollection.length && carsCollection[carNumber - 1] != null) {
                    for (int i = carNumber - 1; i < carsCollection.length - 1; i++) {
                        carsCollection[i] = carsCollection[i + 1];
                        carStats[i] = Arrays.copyOf(carStats[i + 1], carStats[i + 1].length);
                    }

                    carsCollection[carsCollection.length - 1] = null;
                    carStats[carsCollection.length - 1] = new double[4];

                    writeCarsToFile();
                    JOptionPane.showMessageDialog(this, "Car deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    displayAvailableCars();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid car number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error deleting car: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void searchCar() {
        JTextField carNameField = new JTextField();

        JPanel searchCarPanel = new JPanel(new GridLayout(2, 2));
        searchCarPanel.add(new JLabel("Enter car name to search:"));
        searchCarPanel.add(carNameField);

        int result = JOptionPane.showConfirmDialog(this, searchCarPanel, "Search Car", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String carName = carNameField.getText();
            StringBuilder carInfo = new StringBuilder();
            boolean found = false;

            for (int i = 0; i < carsCollection.length; i++) {
                if (carsCollection[i] != null && carsCollection[i].contains(carName)) {
                    carInfo.append("Car found: ").append(carsCollection[i]).append("\n");
                    carInfo.append("Quantity: ").append((int) carStats[i][1]).append("\n");
                    carInfo.append("Available Colors: ").append((int) carStats[i][2]).append("\n");
                    carInfo.append("Transmission Type: ").append((carStats[i][3] == 1) ? "Automatic" : "Manual").append("\n");
                    carInfo.append("Initial Price: $").append(carStats[i][0]).append("\n");
                    carInfo.append("------------------------------\n");
                    found = true;
                    break;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(this, carInfo.toString(), "Car Found", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Car not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showReport() {
        try {
            if (fileExists(INVOICE_FILE)) {
                BufferedReader reader = new BufferedReader(new FileReader(INVOICE_FILE));
                String line;
                StringBuilder report = new StringBuilder("-------- All Invoices --------\n");

                while ((line = reader.readLine()) != null) {
                    report.append(line).append("\n");
                }

                reader.close();
                JOptionPane.showMessageDialog(this, report.toString(), "All Invoices", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No invoices available.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading invoices: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }

    private void addLocalCars() {
        carsCollection[0] = "Toyota Corolla GLI";
        carsCollection[1] = "Honda Civic";
        carsCollection[2] = "Suzuki Mehran";
        carsCollection[3] = "Suzuki Cultus";
        carsCollection[4] = "Toyota Corolla XLI";
        carsCollection[5] = "Toyota Corolla Grande";
        carsCollection[6] = "Honda Civic Reborn";
        carsCollection[7] = "Honda City";
        carsCollection[8] = "Toyota Camry";
        carsCollection[9] = "Honda Accord";

        readCarsInformation();
        double defaultPrice = 1500000.0; // Set your default price here
        for (int i = 0; i < carsCollection.length; i++) {
            if (carsCollection[i] != null) {
                if (carStats[i][1] == 0) {
                    carStats[i][1] = 10; // Set initial quantity
                }

                carStats[i][0] = defaultPrice; // Set initial price
                carStats[i][2] = 2; // Set available colors (assuming 2 colors available for each local car)
                carStats[i][3] = 0; // Placeholder for transmission type (0 for now, you can update it later)
            }
        }
    }

    private void readCarsInformation() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CARS_FILE))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] carInfo = line.split(",");
                if (carInfo.length == 5) {
                    carsCollection[index] = carInfo[0];
                    carStats[index][0] = Double.parseDouble(carInfo[1]);
                    carStats[index][2] = Double.parseDouble(carInfo[3]);
                    carStats[index][3] = Double.parseDouble(carInfo[4]);
                    index++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading car information from file: " + e.getMessage());
        }
    }

    private void writeCarsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CARS_FILE))) {
            for (int i = 0; i < carsCollection.length; i++) {
                if (carsCollection[i] != null) {
                    writer.write(carsCollection[i] + "," + carStats[i][0] + "," + carStats[i][1] + "," + carStats[i][2] + "," + carStats[i][3]);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing cars to file: " + e.getMessage());
        }
    }

    private void registration() {
        JPanel registrationPanel = new JPanel(new GridLayout(8, 2));

        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();
        JTextField ageField = new JTextField();

        registrationPanel.add(new JLabel("First Name:"));
        registrationPanel.add(firstNameField);
        registrationPanel.add(new JLabel("Last Name:"));
        registrationPanel.add(lastNameField);
        registrationPanel.add(new JLabel("Contact:"));
        registrationPanel.add(contactField);
        registrationPanel.add(new JLabel("Email:"));
        registrationPanel.add(emailField);
        registrationPanel.add(new JLabel("Password:"));
        registrationPanel.add(passwordField);
        registrationPanel.add(new JLabel("Confirm Password:"));
        registrationPanel.add(confirmPasswordField);
        registrationPanel.add(new JLabel("Age:"));
        registrationPanel.add(ageField);

        int result = JOptionPane.showConfirmDialog(this, registrationPanel, "User Registration", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String contact = contactField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                int age = Integer.parseInt(ageField.getText());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (age < 18 || age > 70) {
                    JOptionPane.showMessageDialog(this, "Invalid age. Age must be between 18 and 70.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (isEmailExists(email)) {
                    JOptionPane.showMessageDialog(this, "Email already exists. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                userRegistration[0] = firstName;
                userRegistration[1] = lastName;
                userRegistration[2] = contact;
                userRegistration[3] = email;
                userRegistration[4] = password;

                writeUserToFile(userRegistration);
                JOptionPane.showMessageDialog(this, "Registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error during registration: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean isEmailExists(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(", ");
                if (userData.length == 2 && userData[0].equals(email)) {
                    return true; // Email already exists
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false; // Email does not exist
    }

    private void writeUserToFile(String[] userRegistration) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            String userData = userRegistration[3] + ", " + userRegistration[4] + "\n";
            writer.write(userData);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private void login() {
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        loginPanel.add(new JLabel("Email:"));
        loginPanel.add(emailField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(this, loginPanel, "Customer Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            userLogin[0] = email;
            userLogin[1] = password;

            if (checkUserCredentials(userLogin)) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                customerChoices();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean checkUserCredentials(String[] userLogin) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(", ");
                if (userData.length == 2 && userData[0].equals(userLogin[0]) && userData[1].equals(userLogin[1])) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
    }

    private void customerChoices() {
        JPanel customerPanel = new JPanel(new GridLayout(5, 1)); // Increased to fit more options

        customerPanel.add(new JLabel("Customer Section", SwingConstants.CENTER));

        JButton purchaseCarButton = new JButton("Purchase a Car");
        purchaseCarButton.addActionListener(e -> purchaseCar());
        customerPanel.add(purchaseCarButton);

        JButton showAvailableCarsButton = new JButton("Show Available Cars");
        showAvailableCarsButton.addActionListener(e -> displayAvailableCars());
        customerPanel.add(showAvailableCarsButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        customerPanel.add(backButton);

        JOptionPane.showMessageDialog(this, customerPanel, "Customer Choices", JOptionPane.PLAIN_MESSAGE);
    }

    private void purchaseCar() {
        JPanel purchaseCarPanel = new JPanel(new BorderLayout());

        // Create a panel to hold the car numbers
        JPanel carNumbersPanel = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < carsCollection.length; i++) {
            if (carsCollection[i] != null) {
                int displayNumber = i + 1;
                carNumbersPanel.add(new JLabel(displayNumber + ": " + carsCollection[i]));
            }
        }

        JScrollPane carNumbersScrollPane = new JScrollPane(carNumbersPanel);
        carNumbersScrollPane.setPreferredSize(new Dimension(200, 100));

        JTextField carNumberField = new JTextField();
        JTextField transmissionTypeField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField filerStatusField = new JTextField();

        JPanel fieldsPanel = new JPanel(new GridLayout(5, 2));
        fieldsPanel.add(new JLabel("Car Number:"));
        fieldsPanel.add(carNumberField);
        fieldsPanel.add(new JLabel("Transmission Type (A/M):"));
        fieldsPanel.add(transmissionTypeField);
        fieldsPanel.add(new JLabel("Color (B for Black, W for White):"));
        fieldsPanel.add(colorField);
        fieldsPanel.add(new JLabel("Are you a filer? (1 for Yes, 0 for No):"));
        fieldsPanel.add(filerStatusField);

        purchaseCarPanel.add(carNumbersScrollPane, BorderLayout.CENTER);
        purchaseCarPanel.add(fieldsPanel, BorderLayout.SOUTH);

        int result = JOptionPane.showConfirmDialog(this, purchaseCarPanel, "Purchase Car", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int carNumber = Integer.parseInt(carNumberField.getText());
                char transmissionType = Character.toUpperCase(transmissionTypeField.getText().charAt(0));
                String color = colorField.getText().trim().toLowerCase();
                int filerStatus = Integer.parseInt(filerStatusField.getText());

                if (carNumber >= 1 && carNumber <= carsCollection.length && carsCollection[carNumber - 1] != null) {
                    String selectedCarName = carsCollection[carNumber - 1];
                    double basePrice = carStats[carNumber - 1][0];
                    int quantity = (int) carStats[carNumber - 1][1];

                    if (quantity > 0) {
                        double totalPrice = calculateTotalPrice(basePrice, transmissionType, filerStatus);
                        String message = String.format("Total Price: $%.2f\nPlease confirm the purchase.", totalPrice);
                        int confirm = JOptionPane.showConfirmDialog(this, message, "Confirm Purchase", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (confirm == JOptionPane.OK_OPTION) {
                            generateInvoice(selectedCarName, transmissionType, color, basePrice, filerStatus, totalPrice);
                            carStats[carNumber - 1][1]--;
                            writeCarsToFile();
                            JOptionPane.showMessageDialog(this, "Thank you for your purchase!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Sorry, the selected car is out of stock.", "Out of Stock", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid car number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error during purchase: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private double calculateTotalPrice(double basePrice, char transmissionType, int filerStatus) {
        double totalPrice = basePrice;
        if (transmissionType == 'A') {
            totalPrice += 10000;
        }

        if (filerStatus == 0) {
            totalPrice += 0.17 * basePrice; // 17% tax for non-filer
        } else {
            totalPrice += 0.03 * basePrice; // 3% tax for filer
        }

        return totalPrice;
    }

    private void generateInvoice(String selectedCarName, char transmissionType, String color, double basePrice, int filerStatus, double totalPrice) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(INVOICE_FILE, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = dateFormat.format(new Date());
            int invoiceNumber = generateRandomInvoiceNumber();

            writer.println("**************************************************");
            writer.println("*****            TOYOTA CROWN MOTORS         *****");
            writer.println("**************************************************");
            writer.println("\nINVOICE");
            writer.write("Invoice Number:              " + invoiceNumber + "\n");
            writer.println("\nDate and Time:           " + dateTime);
            writer.println("\nCar Information:");
            writer.println("-----------------------");
            writer.println("Customer's Email:         " + userLogin[0]);
            writer.println("Car Name:                 " + selectedCarName);
            writer.println("Transmission Type:        " + getTransmissionType(transmissionType));
            writer.println("Car Color:                " + color);
            writer.println("Base Price:               $" + basePrice);
            writer.println("Filer Status:             " + filerStatus);
            writer.println("\nPayment Information:");
            writer.println("-----------------------");
            writer.println("Total Amount Due:         $" + totalPrice);
            writer.println("\nThank you for choosing Toyota Crown Motors!");
            writer.println("\n**************************************************");
            writer.println("** Drive with Excellence **");
            writer.println("**************************************************");
            writer.println("Invoice Number: " + invoiceNumber++);
            writer.println("----------");

            System.out.println("Invoice generated successfully!");
        } catch (IOException e) {
            System.out.println("Error generating invoice: " + e.getMessage());
        }
    }

    private String getTransmissionType(char transmissionType) {
        return (transmissionType == 'A') ? "Automatic" : "Manual";
    }

    private int generateRandomInvoiceNumber() {
        return new Random().nextInt(1000) + 1;
    }

    private double generateRandomPrice() {
        Random random = new Random();
        double minPrice = 700000.0;
        double maxPrice = 3200000.0;

        double randomPrice = minPrice + (maxPrice - minPrice) * random.nextDouble();
        randomPrice = Math.round(randomPrice * 100) / 100;

        return randomPrice;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarShowroom carShowroom = new CarShowroom();
            carShowroom.setVisible(true);
        });
    }
}

