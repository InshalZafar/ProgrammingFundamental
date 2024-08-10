import java.io.*;
import java.util.InputMismatchException;
import java.util.Date;
import java.util.Random;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Arrays;


public class CarNew{
        static final String USERS_FILE = "users.txt";
        static final String CARS_FILE = "cars.txt";
        static final String INVOICE_FILE = "invoices.txt";

        static String[] users = new String[100];
        static String[] carsCollection = new String[100];
        static double[][] carStats = new double[100][4];
        static String[] userRegistration = new String[5];
		static String[] userLogin = new String[2];
        public static void main(String[] args){


       // readUsersFromFile();
        //readCarsFromFile();
       // readCarsInformation();
       boolean exception1 = true;

        Scanner scanner = new Scanner(System.in);
        addLocalCars();
        while(true){
                do {
            try {
                System.out.println("Welcome to Car Showroom!");
                System.out.println("1. Admin Section");
                System.out.println("2. Customer Section");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.nextLine(); // Consume the invalid input
                    continue; // Skip the rest of the loop and start again
                }

                exception1 = false;

                switch (choice) {
                    case 1:
                        adminSection();
                        break;
                    case 2:
                        customerSection();
                        break;
                    case 3:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (ArithmeticException ex) {
                System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
                scanner.nextLine(); // Consume the invalid input
            } catch (InputMismatchException ex) {
                System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
                scanner.nextLine(); // Consume the invalid input
            } catch (NoSuchElementException ex) {
                System.out.println("Enter Again. Nothing Entered.");
                scanner.nextLine(); // Consume the invalid input
            }

        } while (exception1);
    }
        }
        public static void addLocalCars() {
        // Add Pakistani local cars to the collection
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
        double randomPrice = generateRandomPrice();
        double defaultPrice = 1500000.0; // Set your default price here
        for (int i = 0; i < carsCollection.length; i++) {
        if (carsCollection[i] != null) {
            // Only set initial quantity to 3 if the current quantity is 0
            if (carStats[i][1] == 0) {
                carStats[i][1] = 10; // Set initial quantity
            }

            // Set initial price, available colors, and transmission type
            carStats[i][0] = generateRandomPrice(); // Set initial price
            carStats[i][2] = 2; // Set available colors (assuming 2 colors available for each local car)
            carStats[i][3] = 0; // Placeholder for transmission type (0 for now, you can update it later)
        }
    }
}
 public static void adminSection() {
    Scanner scanner = new Scanner(System.in);
            adminLogin();
        }
    public static void adminLogin(){
        Scanner scanner = new Scanner(System.in);
        String[][] adminInformation = {
			{"hamza@gmail.com", "Hamza123"},
			{"Aqeel@gmail.com", "Aqeel123"},
			{"Abdullah@gmail.com", "Abdullah123"},
			{"Inshaal@gmail.com", "Inshaal123"},
		};
        boolean adminCheckException = true;
        int adminCheck = -1;

        do{
            try{
				System.out.println("**************************************************\n" +
				"*****            TOYOTA CROWN MOTORS         *****\n" +
				"**************************************************\n\n" +
				"Which Admin are you?\n" +
				"PRESS 1 for HAMZA\n" +
				"PRESS 2 for AQEEL\n" +
				"PRESS 3 for ABDULLAH\n" +
				"PRESS 4 for INSHAAL\n" +
				"**************************************************");
                adminCheck = scanner.nextInt();
                adminCheckException = false;
            }
        	catch (ArithmeticException ex){
						System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
						scanner.nextLine();
					}
			catch (InputMismatchException ex){
						System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
						scanner.nextLine();
					}
			catch (NoSuchElementException ex){
						System.out.println("Enter Again. Nothing Entered.");
						scanner.nextLine();
					}
				}while(adminCheckException);

            boolean adminCheckException1 = true;

            while(true){
                if(adminCheck == 1 || adminCheck == 2 || adminCheck == 3 || adminCheck == 4 ){
                    break;
                }
                else{
                    do{
                        try{
                            System.out.println("Wrong input. Enter from 1 - 4: ");
                                adminCheck = scanner.nextInt();
                                adminCheckException1 = false;
                        }
                        catch (ArithmeticException ex){
                                    System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
                                    scanner.nextLine();
                        }
                        catch (InputMismatchException ex){
                                    System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
                                    scanner.nextLine();
                        }
                        catch (NoSuchElementException ex){
                                    System.out.println("Enter Again. Nothing Entered.");
                                    scanner.nextLine();
                        }
                            }while(adminCheckException1);
                   
                }
            }
                adminLoginCheck(adminInformation, adminCheck);

        }   
		public static void adminLoginCheck(String[][] adminInformation, int adminCheck) {
			Scanner input = new Scanner(System.in);
	
			String email = "";
			String password = "";
			int adminChoice;
            boolean adminChoiceException1;
            boolean adminFound = false;

		switch (adminCheck) {
				case 1:
					email = getValidInput("Enter your Email Address: ", adminInformation[0][0]);
					password = getValidInput("Enter your Password: ", adminInformation[0][1]);
					System.out.println("\t---Welcome HAMZA!---");
					adminChoices(input);
	
					break;
	
				case 2:
					email = getValidInput("Enter your Email Address: ", adminInformation[1][0]);
					password = getValidInput("Enter your Password: ", adminInformation[1][1]);
					System.out.println("\t---Welcome AQEEL!---");
					adminChoices(input);
	
					break;
	
				case 3:
					email = getValidInput("Enter your Email Address: ", adminInformation[2][0]);
					password = getValidInput("Enter your Password: ", adminInformation[2][1]);
					System.out.println("\t---Welcome ABDULLAH---");
					adminChoices(input);
	
					break;
	
				case 4:
					email = getValidInput("Enter your Email Address: ", adminInformation[3][0]);
					password = getValidInput("Enter your Password: ", adminInformation[3][1]);
					System.out.println("\t---Welcome INSHAAL!---");
					adminChoices(input);
	
					break;
			}
		}
	
		public static String getValidInput(String prompt, String expected) {
			Scanner input = new Scanner(System.in);
			String userInput = null;
            do {
                 try {
                System.out.print(prompt);
                userInput = input.nextLine();

                if (!userInput.equals(expected)) {
                    System.out.println("Wrong Input. Enter Again.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Input mismatch. Please enter the correct type.");
                input.nextLine(); // Consume the invalid input
            } catch (NoSuchElementException ex) {
                System.out.println("Input not found. Please enter the required input.");
                input.nextLine(); // Consume the invalid input
            } catch (Exception ex) {
                System.out.println("An unexpected error occurred. Please try again.");
                input.nextLine(); // Consume the invalid input
            }
        } while (!userInput.equals(expected));

        return userInput;
    }
        public static void adminChoices(Scanner input) {
			int adminChoice =-1;
			boolean adminChoiceException1 = true;
	
			do {
				try {
                    while (true) {
                        System.out.println("\nAdmin Section:");
                        System.out.println("1. Show All Records");
                        System.out.println("2. Show User Information");
                        System.out.println("3. Add Car");
                        System.out.println("4. Search Car");
                        System.out.println("5. Delete Car");
                        System.out.println("6. Display Available Cars");
                        System.out.println("7. Back to Main Menu");
                        System.out.print("Enter your choice: ");

                        adminChoice = input.nextInt();
                        input.nextLine(); 

                        switch (adminChoice) {
                            case 1:
                                showReport();
                                break;
                            case 2:
                                String[][] userInformation = readUsersInformation();
								for (int i = 0; i < userInformation.length; i++) {
									String[] userInfo = userInformation[i];
									System.out.println("Email: " + userInfo[0] + ", Password: " + userInfo[1]);
								}
                                //displayUserInformation();
                                break;
                            case 3:
                                addCar();
                                break;
                            case 4:
                                searchCar();
                                break;
                            case 5:
                                deleteCar();
                                break;
                            case 6:
                                displayAvailableCars();
                                break;
                            case 7:
                                return; 
                            default:
                                System.out.println("Invalid choice. Please enter a valid option.");
                             }
                            }
                        }catch (ArithmeticException ex) {
                            System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
                            input.nextLine();
                        } catch (InputMismatchException ex) {
                            System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
                            input.nextLine();
                        } catch (NoSuchElementException ex) {
                            System.out.println("Enter Again. Nothing Entered.");
                            input.nextLine();
                        }
                    } while(adminChoiceException1);
                 }
                 public static String[][] readUsersInformation() {
                    int numUsers = countLines("users.txt");
                    String[][] usersInformation = new String[numUsers][2];
                    try (BufferedReader reader= new BufferedReader(new FileReader("users.txt"))) {
                        String line;
                        int index = 0;
                        while ((line = reader.readLine()) != null) {
                            String[] userInfo = line.split(",\\s*");
                            if (userInfo.length >= 2) {
							usersInformation[index++] = userInfo;
                        }
                    }
                } catch (IOException e) {
                    //System.out.println("Cannot find your required/desired Output");
					//System.out.println("Error reading file: " + e.getMessage());
                }
                return usersInformation;
			}
			public static int countLines(String filename) {
				int lines = 0;
				try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
					while (reader.readLine() != null) {
						lines++;
					}
				} catch (IOException e) {
					//System.out.println("Error counting lines: " + e.getMessage());
				}
				return lines;
			}
            public static void addCar() {
                Scanner scanner = new Scanner(System.in);
                boolean inputValid = false;
                String carName = "";
                char transmissionType;
                do{
                    try{
                System.out.print("Enter the car name: ");
                carName = scanner.nextLine();

                System.out.print("Enter the transmission type (Automatic/A, Manual/M): ");
                transmissionType = Character.toUpperCase(scanner.next().charAt(0));

                System.out.print("Enter the Color of the Car ");
                String[] colors = scanner.next().split(",");

                System.out.print("Enter the price for the car: ");
                double price = scanner.nextDouble();

                System.out.print("Enter the quantity of the car: ");
                int quantity = scanner.nextInt();
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
                 System.out.println("Car added successfully!");
                 displayAvailableCars();
                 inputValid = true; 
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input. Please enter valid data types.");
                    scanner.nextLine(); // Consume the invalid input
                } catch (NoSuchElementException ex) {
                    System.out.println("Input not found. Please enter the required input.");
                    scanner.nextLine(); // Consume the invalid input
                } catch (Exception ex) {
                    System.out.println("An unexpected error occurred while adding a car.");
                 }
                 }while (!inputValid);
                 }

                 public static void displayAvailableCars() {
                    System.out.println("Available Cars:");
                    for (int i = 0; i < carsCollection.length; i++) {
                        if (carsCollection[i] != null) {
                            int displayNumber = i + 1; 
                            System.out.println(displayNumber + ". " + carsCollection[i]);
                            displayCarStats(i);
                            System.out.println();
                            System.out.println("------------------------------");
                        }
                    }
                }
                public static int displayCarStats(String carName) {
                    int carIndex = findCarIndex(carName);
                    if (carIndex != -1) {
                        System.out.println("Car: " + carsCollection[carIndex]);
                        displayCarStats(carIndex);
                    } 
                    return carIndex;
                }
                public static String getTransmissionType(double transmissionType) {
                    return (transmissionType == 0) ? "Not specified" : (transmissionType == 1) ? "Automatic" : "Manual";
                 } 
                 public static int findCarIndex(String carName) {
                     for (int i = 0; i < carsCollection.length; i++) {
                        if (carsCollection[i] != null && carsCollection[i].equalsIgnoreCase(carName)) {
                             return i;
                             }
                            }
                            return -1; // Car not found
                 }
                 public static void displayCarStats(int carIndex) {
                    System.out.println("Quantity: " + carStats[carIndex][1]);
                    System.out.println("Available Colors: " + carStats[carIndex][2]);
                    System.out.println("Transmission Type: " + ((carStats[carIndex][3] == 1) ? "Automatic" : "Manual"));
                    System.out.println("Initial Price: $" + carStats[carIndex][0]);
                }
                public static void deleteCar() {
                    Scanner scanner = new Scanner(System.in);
                    boolean inputValidCarNumber = false;
                
                    do {
                        try {
                            System.out.print("Enter the car number to delete: ");
                            int carNumber = scanner.nextInt();
                
                            if (carNumber >= 1 && carNumber <= carsCollection.length && carsCollection[carNumber - 1] != null) {
                                // Shift remaining cars to fill the gap
                                for (int i = carNumber - 1; i < carsCollection.length - 1; i++) {
                                    carsCollection[i] = carsCollection[i + 1];
                                    carStats[i] = Arrays.copyOf(carStats[i + 1], carStats[i + 1].length);
                                }
                
                                carsCollection[carsCollection.length - 1] = null;
                                carStats[carsCollection.length - 1] = new double[4];
                
                                writeCarsToFile();
                
                                System.out.println("Car " + carNumber + " deleted successfully!");
                                displayAvailableCars(); 
                
                                inputValidCarNumber = true;
                            } else {
                                System.out.println("Invalid car number. Please enter a valid car number.");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid input. Please enter a valid car number.");
                            scanner.nextLine(); // Consume the invalid input
                        } catch (Exception ex) {
                            System.out.println("An unexpected error occurred while deleting the car. Please try again.");
                            scanner.nextLine(); // Consume the invalid input
                        }
                    } while (!inputValidCarNumber);
                }
                
                public static void searchCar() {
                    Scanner scanner = new Scanner(System.in);
                    boolean inputValid2 = false;
                    do{
                         try{
                            System.out.print("Enter the car Name to search: ");
                            String searchString = scanner.nextLine();
                            boolean found = false;
                            for (int i = 0; i < carsCollection.length; i++) {
                                String car = carsCollection[i];
                                if (car != null && car.contains(searchString)) {
                                    System.out.println("Car found: " + car);
                                    displayCarStats(i);
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Car not found.");
                            }
                            inputValid2 = true;
                        } catch (NoSuchElementException ex) {
                             System.out.println("Input not found. Please enter the required input.");
                              scanner.nextLine(); // Consume the invalid input
                             } catch (Exception ex) {
                                 System.out.println("An unexpected error occurred while searching for the car. Please try again.");
                                 scanner.nextLine(); // Consume the invalid input
                            }
                        } while (!inputValid2);
                     }
                     public static void customerSection() {
                        Scanner scanner = new Scanner (System.in);
                     boolean loggedIn = false;
                     do {
                        try {
                            if (!loggedIn) {
                                System.out.println("Customer Section:");
                                System.out.println("1. Register");
                                System.out.println("2. Login");
                                System.out.println("3. Exit to Main Menu");
                                System.out.print("Enter your choice: ");
                                int customerChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                                switch (customerChoice) {
                                    case 1:
                                    registration();
                                    login();
                                    loggedIn = true;
                                    break;
                                    case 2:
                                    login();
                                    loggedIn = true;
                                    break;
                                    case 3:
                                    return; // Return to the main menu
                                    default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                 }
                                 } else {
                                    System.out.println("Customer Section:");
                                    System.out.println("1. Purchase a Car");
                                    System.out.println("2. Exit to Main Menu");
                                    System.out.print("Enter your choice: ");
                                    int customerChoice = scanner.nextInt();
                                    scanner.nextLine(); // Consume the newline character
                                    switch (customerChoice) {
                                        case 1:
                                        purchaseCar(scanner);
                                        break;
                                        case 2:
                                        return; // Return to the main menu
                                        default:
                                         System.out.println("Invalid choice. Please enter a valid option.");
                                        }
                                    }
                                } catch (InputMismatchException ex) {
                                    System.out.println("Invalid input. Please enter a valid value.");
                                    scanner.nextLine(); // Consume the invalid input
                                } catch (Exception ex) {
                                    System.out.println("An unexpected error occurred. Please try again.");
                                     scanner.nextLine(); // Consume the invalid input
                                    }
                                } while (true);
                            }
                            public static void purchaseCar(Scanner scanner) {
                                boolean inputValid4 = false;
                                char transmissionType;
                                String color = "";
                                int filerStatus = -1;
                                double totalPrice = 0.0;
                            
                                String selectedCarName = ""; // Variable to store the selected car name
                                double basePrice = 0.0; // Variable to store the selected car base price
                                int quantity = 0; // Variable to store the selected car quantity
                            
                                do {
                                    try {
                                        for (int i = 0; i < carsCollection.length; i++) {
                                            if (carsCollection[i] != null) {
                                                int displayNumber = i + 1; // Adding 1 to convert from zero-based index to human-readable number
                                                System.out.println(displayNumber + ". " + carsCollection[i]);
                                            }
                                        }
                            
                                        System.out.print("Enter the number of the car you want to purchase: ");
                                        int selectedNumber = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character
                            
                                        int carIndex = selectedNumber - 1;
                            
                                        if (carIndex >= 0 && carIndex < carsCollection.length && carsCollection[carIndex] != null) {
                                            selectedCarName = carsCollection[carIndex];
                                            basePrice = carStats[carIndex][0];
                                            quantity = (int) carStats[carIndex][1];
                            
                                            System.out.println("You selected: " + selectedCarName);

                if (quantity > 0) {
                    while(true){
                    System.out.print("Enter the transmission type (Automatic/A, Manual/M): ");
                    transmissionType = Character.toUpperCase(scanner.next().charAt(0));
                    if(transmissionType == 'A' || transmissionType == 'M'){
                        break;
                    }
                    else{
                        System.out.println("Wrong input. Enter again:\n");
                    }

                    }
                    scanner.nextLine();
                    
                    while (true) {
                        System.out.println("Enter the desired color: \nWe have Two Colours (B for Black and W for White)");
                        color = scanner.next().trim().toLowerCase();
                    
                        if ("b".equals(color) || "black".equals(color)) {
                            color = "Black"; // Set a standard format if needed
                            break;
                        } else if ("w".equals(color) || "white".equals(color)) {
                            color = "White"; // Set a standard format if needed
                            break;
                        } else {
                            System.out.println("Wrong input. Enter Again:\n");
                        }
                    }                    

                    while (true) {
                        System.out.print("Are you a filer? (1 for yes, 0 for no): ");
                        try {
                            filerStatus = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            if (filerStatus == 1 || filerStatus == 0) {
                                break;
                            } else {
                                System.out.println("Wrong input. Enter again:\n");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            scanner.nextLine(); // Consume the invalid input, including the newline character
                        }
                    }

                    totalPrice = calculateTotalPrice(basePrice, transmissionType, filerStatus);
                    System.out.println("Total Price: $" + totalPrice);
                    System.out.print("Please enter the amount to pay: ");
                    double paidAmount = scanner.nextDouble();
                    if (paidAmount == totalPrice) {
                        generateInvoice(selectedCarName, transmissionType, color, basePrice, filerStatus, totalPrice);
                        carStats[carIndex][1]--; 
                        writeCarsToFile();
                        System.out.println("Thank you for your purchase!");
                    } else if (paidAmount > totalPrice) {
                        System.out.println("You entered more than the total price. Please enter the correct amount.");
                        paidAmount = scanner.nextDouble();
                    } else {
                        System.out.println("You entered less than the total price. Purchase canceled.");
                        System.out.print("Do you want to purchase another car? (1 for yes, 0 for no): ");
                        int purchaseChoice = scanner.nextInt();
                        if (purchaseChoice == 0) {
                            System.out.println("Returning to the main menu.");
                            return;
                        }
                    }
                }
                else {
                        System.out.println("Sorry, the selected car is out of stock.");
                       }
                     }else {
                        System.out.println("Car not found.");
                    }
                    inputValid4 = true;
                 } catch (InputMismatchException ex) {
                    System.out.println("Invalid input. Please enter a valid value.");
                    scanner.nextLine(); 
                } catch (Exception ex) {
                     System.out.println("An unexpected error occurred. Please try again.");
                     scanner.nextLine(); 
                    }
                }while (!inputValid4);
            }
            public static double calculateTotalPrice(double basePrice, char transmissionType, int filerStatus) {
                double totalPrice = basePrice;
                if (transmissionType == 'A') {
                    totalPrice += 10000;
                }
            
                // Apply filer status factor
                if (filerStatus == 0) {
                    totalPrice += 0.17 * basePrice; // 17% tax for non-filer
                } else {
                    totalPrice += 0.03 * basePrice; // 3% tax for filer
                }
            
                return totalPrice;
            }
            public static void generateInvoice(String selectedCarName, char transmissionType, String color, double basePrice, int filerStatus, double totalPrice) {
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
                    public static String getTransmissionType(char transmissionType) {
                        return (transmissionType == 'A') ? "Automatic" : "Manual";
                    }
                     public static int generateRandomInvoiceNumber() {
                        return new Random().nextInt(1000) + 1;
                    }
                    public static void writeCarsToFile() {
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
        public static void decreaseCarQuantity(String carName, double[][] carStats) {
        // Find the index of the purchased car
        int carIndex = findCarIndex(carName);

        // If the car is found, decrease its quantity by 1
        if (carIndex != -1 && carStats[carIndex][1] > 0) {
            carStats[carIndex][1]--; // Decrease the quantity by 1
            writeCarsToFile(); // Update the file with the new quantity
            System.out.println("Car purchased successfully. Quantity updated.");
        } else {
            System.out.println("Error: Car not found or no quantity available.");
        }
    }
    public static void showReport() {
        try {
            if (fileExists(INVOICE_FILE)) {
                try (BufferedReader reader = new BufferedReader(new FileReader(INVOICE_FILE))) {
                    String line;
                    System.out.println("-------- All Invoices --------");
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println("------------------------------");
                }
            } else {
                System.out.println("No invoices available.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }
    public static void readCarsInformation() {
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
                carStats[index][3] = Double.parseDouble(carInfo[4]);
                index++;
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading car information from file: " + e.getMessage());
    }
}
public static void registration() {
			Scanner input = new Scanner(System.in);
			// Index 0: First Name
			System.out.print("Enter your first name: ");
			userRegistration[0] = input.next();
			userRegistration[0] = userRegistration[0].substring(0, 1).toUpperCase() + userRegistration[0].substring(1).toLowerCase();
			// Index 1: Last Name
			System.out.print("Enter your last name: ");
			userRegistration[1] = input.next();
			userRegistration[1] = userRegistration[1].substring(0, 1).toUpperCase() + userRegistration[1].substring(1).toLowerCase();
			// Index 2: Contact
			int contactCheck = -1;
			while (contactCheck != 0) {
				System.out.print("Enter your Contact: \nFormat : +92331-2345678 or 0331-2345678: ");
				userRegistration[2] = input.next();
				if (userRegistration[2].matches("^\\+?\\d{5}-?\\d{7}$") || userRegistration[2].matches("^0?\\d{4}-?\\d{7}$")) {
					contactCheck = 0;
				} else {
					System.out.println("Wrong Input. Please enter a valid contact number in the format +92331-2345678 or 0331-2345678");
				}
			}
			boolean emailCheck = false;
        while (!emailCheck) {
            System.out.print("Enter your Email Address: ");
            userRegistration[3] = input.next();

            // Check if the email already exists
            if (isEmailExists(userRegistration[3])) {
                System.out.println("This email is already registered. Please use a different email.");
            } else {
					if (userRegistration[3].matches("^[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\\.[a-zA-Z]{2,}$")) {
					emailCheck = true;
				} else {
					System.out.print("Wrong format for Email Address. Enter Email Address Again: ");
				}
            }
        }
			// Index 4: Password
			boolean validPassword = false;
			while (!validPassword) {
				System.out.print("Enter your Password: ");
				userRegistration[4] = input.next();
				if (userRegistration[4].length() >= 8 && containsUpperCase(userRegistration[4]) && containsLowerCase(userRegistration[4])) {
					validPassword = true;
				} else {
					System.out.println("Invalid Password. Password must be at least 8 characters and include at least one upper case and one lower case letter.");
				}
			}
			// Index 5: Confirm Password
			System.out.print("Confirm your Password: ");
			String confirmPassword = input.next();
			// Check if the confirmed password matches the original password
			while (!userRegistration[4].equals(confirmPassword)) {
				System.out.print("Passwords do not match. Enter your Password again: ");
				confirmPassword = input.next();
			}
			// AGE CHECKER
			int age = -1;
			boolean thirdException = true;
			do {
				try {

					System.out.println("Enter your Age: \nMinimum Age for Registration is 18\nMaximum Age for Registration is 100\n");
					age = input.nextInt();
					thirdException = false;
				} catch (ArithmeticException ex) {
					System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
					input.nextLine();
				} catch (InputMismatchException ex) {
					System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
					input.nextLine();
				} catch (NoSuchElementException ex) {
					System.out.println("Enter Again. Nothing Entered.");
					input.nextLine();
				}
			} while (thirdException);
			// MAXIMUM RANGE OF AGE = 99 AND MINIMUM RANGE = 18
			boolean innerException2 = true;
			int ageChecker = -1;
			int ageCounter = -1;
			boolean innerException3 = true;
			if (age < 18 || age > 100) {
				do {
					try {


						System.out.println("Sorry! We cannot Register you. Your age is not Valid for Registration.");
						System.out.println("Do you want to Register Again or Exit?\nEnter 1 to Register Again\nEnter 0 to Exit\n");

						ageChecker = input.nextInt();
						innerException2 = false;
					} catch (ArithmeticException ex) {
						System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
						input.nextLine();
					} catch (InputMismatchException ex) {
						System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
						input.nextLine();
					} catch (NoSuchElementException ex) {
						System.out.println("Enter Again. Nothing Entered.");
						input.nextLine();
					}
				} while (innerException2);


				while (ageCounter != 0) {
					switch (ageChecker) {
						case 1:
							registration();
							ageCounter = 0;
							break;
						case 0:
							System.exit(1);
							ageCounter = 0;
							break;
						default:
							do {
								try {
									ageCounter = -1;
									System.out.println("Wrong input. Enter either 0 or 1:");
									ageChecker = input.nextInt();
									innerException3 = false;
									break;
								} catch (ArithmeticException ex) {
									System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
									input.nextLine();
								} catch (InputMismatchException ex) {
									System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
									input.nextLine();
								} catch (NoSuchElementException ex) {
									System.out.println("Enter Again. Nothing Entered.");
									input.nextLine();
								}
							} while (innerException3);


					}

				}
			}
			else{
				System.out.println("Registered Successfully!");
				writeUserToFile(userRegistration);
			}

		}
        public static void writeUserToFile(String[] userRegistration) {
    	try {
        FileWriter writer = new FileWriter("users.txt", true); // Append mode
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        String userData = userRegistration[3] + ", " + userRegistration[4] + "\n";

        bufferedWriter.write(userData);
        bufferedWriter.close();
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
	}
    public static boolean isEmailExists(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(", ");
                if (userData.length == 2 && userData[0].equals(email)) {
                    return true; // Email already exists
                }
            }
        } catch (IOException e) {
           // System.out.println("Error reading file: " + e.getMessage());
        }
        return false; // Email does not exist
    }
		public static void login() {
				Scanner input = new Scanner(System.in);

				boolean loginSuccessful = false;

				while (!loginSuccessful) {
					try {
						System.out.print("Enter your email address: ");
						userLogin[0] = input.next();

						System.out.print ("Enter your password: ");
						userLogin[1] = input.next();

						// Check if the entered email and password match any registered user
						if (checkUserCredentials(userLogin)) {
							System.out.println("Login successful!");
							loginSuccessful = true;
						} else {
							System.out.print("Invalid email or password. Please try again: ");
						}
					} catch (Exception e) {
						System.out.println("An error occurred: " + e.getMessage());
						input.nextLine(); // Consume the remaining newline character
					}
				}
					}
			public static boolean checkUserCredentials(String[] userLogin) {
			try {
                Scanner scanner = new Scanner(new File("users.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] userData = line.split(", ");
                    if (userData.length == 2 && userData[0].equals(userLogin[0]) && userData[1].equals(userLogin[1])) {
							scanner.close();
							return true;
						}
                    }
                    scanner.close();
				} catch (FileNotFoundException e) {
					//System.out.println("Error reading user data file: " + e.getMessage());
				}
                return false;
			}
		
		public static boolean containsUpperCase(String str) {
			for (char c : str.toCharArray()) {
				if (Character.isUpperCase(c)) {
					return true;
				}
			}
			return false;
		}
	   public static boolean containsLowerCase(String str) {
			for (char c : str.toCharArray()) {
				if (Character.isLowerCase(c)) {
					return true;
				}
			}
			return false;
        }
        public static double generateRandomPrice() {
        Random random = new Random();
        double minPrice = 700000.0;
        double maxPrice = 3200000.0;

        // Generate a random double between minPrice and maxPrice
        double randomPrice = minPrice + (maxPrice - minPrice) * random.nextDouble();

        // Round the price to two decimal places
        randomPrice = Math.round(randomPrice * 100) / 100;

        return randomPrice;
    }
    }
		 
    