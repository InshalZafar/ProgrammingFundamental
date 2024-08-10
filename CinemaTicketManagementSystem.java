// import java.io.*;
// import java.util.*;
// import java.time.LocalDateTime;
// import java.text.SimpleDateFormat;

// public class CinemaTicketManagementSystem {
//     static final String USERS_FILE = "users.txt";
//     static final String MOVIES_FILE = "movies.txt";
//     static final String BOOKINGS_FILE = "bookings.txt";

//     static String[] users = new String[100];
//     static String[] moviesCollection = new String[100];
//     static double[][] movieStats = new double[100][2]; // [0]: Price, [1]: Available Seats
//     static List<Booking> bookings = new ArrayList<>();
//     static String[] userRegistration = new String[5];
//     static String[] userLogin = new String[2];

//     public static void main(String[] args) {
//         boolean exception1 = true;

//         Scanner scanner = new Scanner(System.in);
//         addLocalMovies();
//         while (true) {
//             do {
//                 try {
//                     System.out.println("Welcome to Cinema Ticket Management System!");
//                     System.out.println("1. Admin Section");
//                     System.out.println("2. Customer Section");
//                     System.out.println("3. Exit");
//                     System.out.print("Enter your choice: ");

//                     int choice;
//                     if (scanner.hasNextInt()) {
//                         choice = scanner.nextInt();
//                         scanner.nextLine(); // Consume the newline character
//                     } else {
//                         System.out.println("Invalid input. Please enter an integer.");
//                         scanner.nextLine(); // Consume the invalid input
//                         continue; // Skip the rest of the loop and start again
//                     }

//                     exception1 = false;

//                     switch (choice) {
//                         case 1:
//                             adminLogin();
//                             break;
//                         case 2:
//                             customerSection();
//                             break;
//                         case 3:
//                             System.out.println("Exiting the program. Goodbye!");
//                             System.exit(0);
//                             break;
//                         default:
//                             System.out.println("Invalid choice. Please enter a valid option.");
//                     }
//                 } catch (ArithmeticException ex) {
//                     System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                     scanner.nextLine(); // Consume the invalid input
//                 } catch (InputMismatchException ex) {
//                     System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                     scanner.nextLine(); // Consume the invalid input
//                 } catch (NoSuchElementException ex) {
//                     System.out.println("Enter Again. Nothing Entered.");
//                     scanner.nextLine(); // Consume the invalid input
//                 }

//             } while (exception1);
//         }
//     }

//     public static void addLocalMovies() {
//         // Add local movies to the collection
//         moviesCollection[0] = "Inception";
//         moviesCollection[1] = "The Dark Knight";
//         moviesCollection[2] = "Interstellar";
//         moviesCollection[3] = "The Matrix";
//         moviesCollection[4] = "Avatar";
//         moviesCollection[5] = "Avengers: Endgame";
//         moviesCollection[6] = "Titanic";
//         moviesCollection[7] = "Jurassic Park";
//         moviesCollection[8] = "The Lion King";
//         moviesCollection[9] = "Gladiator";

//         readMoviesInformation();
//         for (int i = 0; i < moviesCollection.length; i++) {
//             if (moviesCollection[i] != null) {
//                 // Only set initial quantity to 100 if the current quantity is 0
//                 if (movieStats[i][1] == 0) {
//                     movieStats[i][1] = 100; // Set initial seats
//                 }

//                 // Set initial price
//                 movieStats[i][0] = 500 + (i % 6) * 100; // Prices will be 500, 600, 700, 800, 900, 1000
//             }
//         }
//     }

//     public static void adminLogin() {
//         Scanner scanner = new Scanner(System.in);
//         String[][] adminInformation = {
//             {"inshal@gmail.com", "Inshal123"}
//         };
//         adminLoginCheck(adminInformation);
//     }

//     public static void adminLoginCheck(String[][] adminInformation) {
//         Scanner input = new Scanner(System.in);

//         String email = getValidInput("Enter your Email Address: ", adminInformation[0][0]);
//         String password = getValidInput("Enter your Password: ", adminInformation[0][1]);
//         System.out.println("\t---Welcome INSHAL!---");
//         adminChoices(input);
//     }

//     public static String getValidInput(String prompt, String expected) {
//         Scanner input = new Scanner(System.in);
//         String userInput = null;
//         do {
//             try {
//                 System.out.print(prompt);
//                 userInput = input.nextLine();

//                 if (!userInput.equals(expected)) {
//                     System.out.println("Wrong Input. Enter Again.");
//                 }
//             } catch (InputMismatchException ex) {
//                 System.out.println("Input mismatch. Please enter the correct type.");
//                 input.nextLine(); // Consume the invalid input
//             } catch (NoSuchElementException ex) {
//                 System.out.println("Input not found. Please enter the required input.");
//                 input.nextLine(); // Consume the invalid input
//             } catch (Exception ex) {
//                 System.out.println("An unexpected error occurred. Please try again.");
//                 input.nextLine(); // Consume the invalid input
//             }
//         } while (!userInput.equals(expected));

//         return userInput;
//     }

//     public static void adminChoices(Scanner input) {
//         int adminChoice = -1;
//         boolean adminChoiceException1 = true;

//         do {
//             try {
//                 while (true) {
//                     System.out.println("\nAdmin Section:");
//                     System.out.println("1. Show All Records");
//                     System.out.println("2. Show User Information");
//                     System.out.println("3. Add Movie");
//                     System.out.println("4. Search Movie");
//                     System.out.println("5. Delete Movie");
//                     System.out.println("6. Display Available Movies");
//                     System.out.println("7. Back to Main Menu");
//                     System.out.print("Enter your choice: ");

//                     adminChoice = input.nextInt();
//                     input.nextLine();

//                     switch (adminChoice) {
//                         case 1:
//                             showReport();
//                             break;
//                         case 2:
//                             String[][] userInformation = readUsersInformation();
//                             for (int i = 0; i < userInformation.length; i++) {
//                                 String[] userInfo = userInformation[i];
//                                 System.out.println("Email: " + userInfo[0] + ", Password: " + userInfo[1]);
//                             }
//                             break;
//                         case 3:
//                             addMovie();
//                             break;
//                         case 4:
//                             searchMovie();
//                             break;
//                         case 5:
//                             deleteMovie();
//                             break;
//                         case 6:
//                             displayAvailableMovies();
//                             break;
//                         case 7:
//                             return;
//                         default:
//                             System.out.println("Invalid choice. Please enter a valid option.");
//                     }
//                 }
//             } catch (ArithmeticException ex) {
//                 System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                 input.nextLine();
//             } catch (InputMismatchException ex) {
//                 System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                 input.nextLine();
//             } catch (NoSuchElementException ex) {
//                 System.out.println("Enter Again. Nothing Entered.");
//                 input.nextLine();
//             }
//         } while (adminChoiceException1);
//     }

//     public static String[][] readUsersInformation() {
//         int numUsers = countLines(USERS_FILE);
//         String[][] usersInformation = new String[numUsers][2];
//         try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
//             String line;
//             int index = 0;
//             while ((line = reader.readLine()) != null) {
//                 String[] userInfo = line.split(",\\s*");
//                 if (userInfo.length >= 2) {
//                     usersInformation[index++] = userInfo;
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error reading user information from file: " + e.getMessage());
//         }
//         return usersInformation;
//     }

//     public static int countLines(String filename) {
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

//     public static void addMovie() {
//         Scanner scanner = new Scanner(System.in);
//         boolean inputValid = false;
//         String movieName = "";
//         do {
//             try {
//                 System.out.print("Enter the movie name: ");
//                 movieName = scanner.nextLine();

//                 System.out.print("Enter the ticket price for the movie (500-1000): ");
//                 double price = scanner.nextDouble();
//                 while (price < 500 || price > 1000) {
//                     System.out.print("Invalid price. Enter a price between 500 and 1000: ");
//                     price = scanner.nextDouble();
//                 }

//                 System.out.print("Enter the number of available seats: ");
//                 int seats = scanner.nextInt();

//                 for (int i = 0; i < moviesCollection.length; i++) {
//                     if (moviesCollection[i] == null) {
//                         moviesCollection[i] = movieName;
//                         movieStats[i][0] = price;
//                         movieStats[i][1] = seats;
//                         break;
//                     }
//                 }
//                 writeMoviesToFile();
//                 System.out.println("Movie added successfully!");
//                 displayAvailableMovies();
//                 inputValid = true;
//             } catch (InputMismatchException ex) {
//                 System.out.println("Invalid input. Please enter valid data types.");
//                 scanner.nextLine(); // Consume the invalid input
//             } catch (NoSuchElementException ex) {
//                 System.out.println("Input not found. Please enter the required input.");
//                 scanner.nextLine(); // Consume the invalid input
//             } catch (Exception ex) {
//                 System.out.println("An unexpected error occurred while adding a movie.");
//             }
//         } while (!inputValid);
//     }

//     public static void displayAvailableMovies() {
//         System.out.println("Available Movies:");
//         for (int i = 0; i < moviesCollection.length; i++) {
//             if (moviesCollection[i] != null) {
//                 int displayNumber = i + 1;
//                 System.out.println(displayNumber + ". " + moviesCollection[i]);
//                 displayMovieStats(i);
//                 System.out.println();
//                 System.out.println("------------------------------");
//             }
//         }
//     }

//     public static int displayMovieStats(String movieName) {
//         int movieIndex = findMovieIndex(movieName);
//         if (movieIndex != -1) {
//             System.out.println("Movie: " + moviesCollection[movieIndex]);
//             displayMovieStats(movieIndex);
//         }
//         return movieIndex;
//     }

//     public static int findMovieIndex(String movieName) {
//         for (int i = 0; i < moviesCollection.length; i++) {
//             if (moviesCollection[i] != null && moviesCollection[i].equalsIgnoreCase(movieName)) {
//                 return i;
//             }
//         }
//         return -1; // Movie not found
//     }

//     public static void displayMovieStats(int movieIndex) {
//         System.out.println("Ticket Price: $" + movieStats[movieIndex][0]);
//         System.out.println("Available Seats: " + (int)movieStats[movieIndex][1]);
//     }

//     public static void deleteMovie() {
//         Scanner scanner = new Scanner(System.in);
//         boolean inputValidMovieNumber = false;

//         do {
//             try {
//                 System.out.print("Enter the movie number to delete: ");
//                 int movieNumber = scanner.nextInt();

//                 if (movieNumber >= 1 && movieNumber <= moviesCollection.length && moviesCollection[movieNumber - 1] != null) {
//                     // Shift remaining movies to fill the gap
//                     for (int i = movieNumber - 1; i < moviesCollection.length - 1; i++) {
//                         moviesCollection[i] = moviesCollection[i + 1];
//                         movieStats[i] = Arrays.copyOf(movieStats[i + 1], movieStats[i + 1].length);
//                     }

//                     moviesCollection[moviesCollection.length - 1] = null;
//                     movieStats[moviesCollection.length - 1] = new double[2];

//                     writeMoviesToFile();

//                     System.out.println("Movie " + movieNumber + " deleted successfully!");
//                     displayAvailableMovies();

//                     inputValidMovieNumber = true;
//                 } else {
//                     System.out.println("Invalid movie number. Please enter a valid movie number.");
//                     scanner.nextLine();
//                 }
//             } catch (InputMismatchException ex) {
//                 System.out.println("Invalid input. Please enter a valid movie number.");
//                 scanner.nextLine(); // Consume the invalid input
//             } catch (Exception ex) {
//                 System.out.println("An unexpected error occurred while deleting the movie. Please try again.");
//                 scanner.nextLine(); // Consume the invalid input
//             }
//         } while (!inputValidMovieNumber);
//     }

//     public static void searchMovie() {
//         Scanner scanner = new Scanner(System.in);
//         boolean inputValid2 = false;
//         do {
//             try {
//                 System.out.print("Enter the movie name to search: ");
//                 String searchString = scanner.nextLine();
//                 boolean found = false;
//                 for (int i = 0; i < moviesCollection.length; i++) {
//                     String movie = moviesCollection[i];
//                     if (movie != null && movie.contains(searchString)) {
//                         System.out.println("Movie found: " + movie);
//                         displayMovieStats(i);
//                         found = true;
//                         break;
//                     }
//                 }
//                 if (!found) {
//                     System.out.println("Movie not found.");
//                 }
//                 inputValid2 = true;
//             } catch (NoSuchElementException ex) {
//                 System.out.println("Input not found. Please enter the required input.");
//                 scanner.nextLine(); // Consume the invalid input
//             } catch (Exception ex) {
//                 System.out.println("An unexpected error occurred while searching for the movie. Please try again.");
//                 scanner.nextLine(); // Consume the invalid input
//             }
//         } while (!inputValid2);
//     }

//     public static void customerSection() {
//         Scanner scanner = new Scanner(System.in);
//         boolean loggedIn = false;
//         do {
//             try {
//                 if (!loggedIn) {
//                     System.out.println("Customer Section:");
//                     System.out.println("1. Register");
//                     System.out.println("2. Login");
//                     System.out.println("3. Exit to Main Menu");
//                     System.out.print("Enter your choice: ");
//                     int customerChoice = scanner.nextInt();
//                     scanner.nextLine(); // Consume the newline character
//                     switch (customerChoice) {
//                         case 1:
//                             registration();
//                             login();
//                             loggedIn = true;
//                             break;
//                         case 2:
//                             login();
//                             loggedIn = true;
//                             break;
//                         case 3:
//                             return; // Return to the main menu
//                         default:
//                             System.out.println("Invalid choice. Please enter a valid option.");
//                     }
//                 } else {
//                     System.out.println("Customer Section:");
//                     System.out.println("1. Book a Ticket");
//                     System.out.println("2. All Movies with Timing");
//                     System.out.println("3. History");
//                     System.out.println("4. Logout");
//                     System.out.print("Enter your choice: ");
//                     int customerChoice = scanner.nextInt();
//                     scanner.nextLine(); // Consume the newline character
//                     switch (customerChoice) {
//                         case 1:
//                             bookTicket(scanner);
//                             break;
//                         case 2:
//                             displayAvailableMovies();
//                             break;
//                         case 3:
//                             displayBookingHistory();
//                             break;
//                         case 4:
//                             System.out.println("Logged out successfully!");
//                             return; // Return to the main menu
//                         default:
//                             System.out.println("Invalid choice. Please enter a valid option.");
//                     }
//                 }
//             } catch (InputMismatchException ex) {
//                 System.out.println("Invalid input. Please enter a valid value.");
//                 scanner.nextLine(); // Consume the invalid input
//             } catch (Exception ex) {
//                 System.out.println("An unexpected error occurred. Please try again.");
//                 scanner.nextLine(); // Consume the invalid input
//             }
//         } while (true);
//     }

//     public static void bookTicket(Scanner scanner) {
//         boolean inputValid4 = false;
//         double totalPrice = 0.0;

//         String selectedMovieName = ""; // Variable to store the selected movie name
//         double basePrice = 0.0; // Variable to store the selected movie base price
//         int quantity = 0; // Variable to store the selected movie quantity

//         do {
//             try {
//                 for (int i = 0; i < moviesCollection.length; i++) {
//                     if (moviesCollection[i] != null) {
//                         int displayNumber = i + 1; // Adding 1 to convert from zero-based index to human-readable number
//                         System.out.println(displayNumber + ". " + moviesCollection[i] + " - Price: $" + movieStats[i][0] + " - Available Seats: " + (int)movieStats[i][1]);
//                     }
//                 }

//                 System.out.print("Enter the number of the movie you want to book a ticket for: ");
//                 int selectedNumber = scanner.nextInt();
//                 scanner.nextLine(); // Consume the newline character

//                 int movieIndex = selectedNumber - 1;

//                 if (movieIndex >= 0 && movieIndex < moviesCollection.length && moviesCollection[movieIndex] != null) {
//                     selectedMovieName = moviesCollection[movieIndex];
//                     basePrice = movieStats[movieIndex][0];
//                     quantity = (int) movieStats[movieIndex][1];

//                     System.out.println("You selected: " + selectedMovieName);

//                     if (quantity > 0) {
//                         System.out.print("Enter the number of seats you want to book: ");
//                         int seatsToBook = scanner.nextInt();
//                         while (seatsToBook > quantity) {
//                             System.out.print("Not enough seats available. Enter a smaller number: ");
//                             seatsToBook = scanner.nextInt();
//                         }
                        
//                         totalPrice = basePrice * seatsToBook;
//                         System.out.println("Total Price: $" + totalPrice);
//                         System.out.print("Please enter the amount to pay: ");
//                         double paidAmount = scanner.nextDouble();
//                         if (paidAmount == totalPrice) {
//                             generateInvoice(selectedMovieName, basePrice, totalPrice, seatsToBook);
//                             movieStats[movieIndex][1] -= seatsToBook; // Decrease the quantity
//                             writeMoviesToFile();
//                             System.out.println("Thank you for your purchase!");
//                         } else if (paidAmount > totalPrice) {
//                             System.out.println("You entered more than the total price. Please enter the correct amount.");
//                             paidAmount = scanner.nextDouble();
//                         } else {
//                             System.out.println("You entered less than the total price. Purchase canceled.");
//                             System.out.print("Do you want to book another ticket? (1 for yes, 0 for no): ");
//                             int purchaseChoice = scanner.nextInt();
//                             if (purchaseChoice == 0) {
//                                 System.out.println("Returning to the main menu.");
//                                 return;
//                             }
//                         }
//                     } else {
//                         System.out.println("Sorry, the selected movie is out of stock.");
//                     }
//                 } else {
//                     System.out.println("Movie not found.");
//                 }
//                 inputValid4 = true;
//             } catch (InputMismatchException ex) {
//                 System.out.println("Invalid input. Please enter a valid value.");
//                 scanner.nextLine();
//             } catch (Exception ex) {
//                 System.out.println("An unexpected error occurred. Please try again.");
//                 scanner.nextLine();
//             }
//         } while (!inputValid4);
//     }

//     public static void generateInvoice(String selectedMovieName, double basePrice, double totalPrice, int seatsToBook) {
//         try (PrintWriter writer = new PrintWriter(new FileWriter(BOOKINGS_FILE, true))) {
//             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//             String dateTime = dateFormat.format(new Date());
//             int invoiceNumber = generateRandomInvoiceNumber();
//             writer.println("**************************************************");
//             writer.println("*****            CINEMA MANAGEMENT         *****");
//             writer.println("**************************************************");
//             writer.println("\nINVOICE");
//             writer.write("Invoice Number:              " + invoiceNumber + "\n");
//             writer.println("\nDate and Time:           " + dateTime);
//             writer.println("\nMovie Information:");
//             writer.println("-----------------------");
//             writer.println("Customer's Email:         " + userLogin[0]);
//             writer.println("Movie Name:                 " + selectedMovieName);
//             writer.println("Base Price:               $" + basePrice);
//             writer.println("Seats Booked:             " + seatsToBook);
//             writer.println("\nPayment Information:");
//             writer.println("-----------------------");
//             writer.println("Total Amount Due:         $" + totalPrice);
//             writer.println("\nThank you for choosing Cinema Management System!");
//             writer.println("\n**************************************************");
//             writer.println("** Enjoy Your Show **");
//             writer.println("**************************************************");
//             writer.println("Invoice Number: " + invoiceNumber++);
//             writer.println("----------");
//             System.out.println("Invoice generated successfully!");
//             bookings.add(new Booking(userLogin[0], selectedMovieName, dateTime, totalPrice, seatsToBook));
//         } catch (IOException e) {
//             System.out.println("Error generating invoice: " + e.getMessage());
//         }
//     }

//     public static int generateRandomInvoiceNumber() {
//         return new Random().nextInt(1000) + 1;
//     }

//     public static void writeMoviesToFile() {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(MOVIES_FILE))) {
//             for (int i = 0; i < moviesCollection.length; i++) {
//                 if (moviesCollection[i] != null) {
//                     writer.write(moviesCollection[i] + "," + movieStats[i][0] + "," + movieStats[i][1]);
//                     writer.newLine();
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error writing movies to file: " + e.getMessage());
//         }
//     }

//     public static void showReport() {
//         try {
//             if (fileExists(BOOKINGS_FILE)) {
//                 try (BufferedReader reader = new BufferedReader(new FileReader(BOOKINGS_FILE))) {
//                     String line;
//                     System.out.println("-------- All Invoices --------");
//                     while ((line = reader.readLine()) != null) {
//                         System.out.println(line);
//                     }
//                     System.out.println("------------------------------");
//                 }
//             } else {
//                 System.out.println("No invoices available.");
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     public static boolean fileExists(String filePath) {
//         return new File(filePath).exists();
//     }

//     public static void readMoviesInformation() {
//         try (BufferedReader reader = new BufferedReader(new FileReader(MOVIES_FILE))) {
//             String line;
//             int index = 0;
//             while ((line = reader.readLine()) != null) {
//                 String[] movieInfo = line.split(",");
//                 if (movieInfo.length == 3) {
//                     moviesCollection[index] = movieInfo[0];
//                     movieStats[index][0] = Double.parseDouble(movieInfo[1]);
//                     movieStats[index][1] = Double.parseDouble(movieInfo[2]);
//                     index++;
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error reading movie information from file: " + e.getMessage());
//         }
//     }

//     public static void registration() {
//         Scanner input = new Scanner(System.in);
//         // Index 0: First Name
//         System.out.print("Enter your first name: ");
//         userRegistration[0] = input.next();
//         userRegistration[0] = userRegistration[0].substring(0, 1).toUpperCase() + userRegistration[0].substring(1).toLowerCase();
//         // Index 1: Last Name
//         System.out.print("Enter your last name: ");
//         userRegistration[1] = input.next();
//         userRegistration[1] = userRegistration[1].substring(0, 1).toUpperCase() + userRegistration[1].substring(1).toLowerCase();
//         // Index 2: Contact
//         int contactCheck = -1;
//         while (contactCheck != 0) {
//             System.out.print("Enter your Contact: \nFormat : +92331-2345678 or 0331-2345678: ");
//             userRegistration[2] = input.next();
//             if (userRegistration[2].matches("^\\+?\\d{5}-?\\d{7}$") || userRegistration[2].matches("^0?\\d{4}-?\\d{7}$")) {
//                 contactCheck = 0;
//             } else {
//                 System.out.println("Wrong Input. Please enter a valid contact number in the format +92331-2345678 or 0331-2345678");
//             }
//         }
//         boolean emailCheck = false;
//         while (!emailCheck) {
//             System.out.print("Enter your Email Address: ");
//             userRegistration[3] = input.next();

//             // Check if the email already exists
//             if (isEmailExists(userRegistration[3])) {
//                 System.out.println("This email is already registered. Please use a different email.");
//             } else {
//                 if (userRegistration[3].matches("^[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\\.[a-zA-Z]{2,}$")) {
//                     emailCheck = true;
//                 } else {
//                     System.out.print("Wrong format for Email Address. Enter Email Address Again: ");
//                 }
//             }
//         }
//         // Index 4: Password
//         boolean validPassword = false;
//         while (!validPassword) {
//             System.out.print("Enter your Password: ");
//             userRegistration[4] = input.next();
//             if (userRegistration[4].length() >= 8 && containsUpperCase(userRegistration[4]) && containsLowerCase(userRegistration[4])) {
//                 validPassword = true;
//             } else {
//                 System.out.println("Invalid Password. Password must be at least 8 characters and include at least one upper case and one lower case letter.");
//             }
//         }
//         // Index 5: Confirm Password
//         System.out.print("Confirm your Password: ");
//         String confirmPassword = input.next();
//         // Check if the confirmed password matches the original password
//         while (!userRegistration[4].equals(confirmPassword)) {
//             System.out.print("Passwords do not match. Enter your Password again: ");
//             confirmPassword = input.next();
//         }
//         // AGE CHECKER
//         int age = -1;
//         boolean thirdException = true;
//         do {
//             try {
//                 System.out.println("Enter your Age: \nMinimum Age for Registration is 18\nMaximum Age for Registration is 100\n");
//                 age = input.nextInt();
//                 thirdException = false;
//             } catch (ArithmeticException ex) {
//                 System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                 input.nextLine();
//             } catch (InputMismatchException ex) {
//                 System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                 input.nextLine();
//             } catch (NoSuchElementException ex) {
//                 System.out.println("Enter Again. Nothing Entered.");
//                 input.nextLine();
//             }
//         } while (thirdException);
//         // MAXIMUM RANGE OF AGE = 99 AND MINIMUM RANGE = 18
//         boolean innerException2 = true;
//         int ageChecker = -1;
//         int ageCounter = -1;
//         boolean innerException3 = true;
//         if (age < 18 || age > 100) {
//             do {
//                 try {
//                     System.out.println("Sorry! We cannot Register you. Your age is not Valid for Registration.");
//                     System.out.println("Do you want to Register Again or Exit?\nEnter 1 to Register Again\nEnter 0 to Exit\n");

//                     ageChecker = input.nextInt();
//                     innerException2 = false;
//                 } catch (ArithmeticException ex) {
//                     System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                     input.nextLine();
//                 } catch (InputMismatchException ex) {
//                     System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                     input.nextLine();
//                 } catch (NoSuchElementException ex) {
//                     System.out.println("Enter Again. Nothing Entered.");
//                     input.nextLine();
//                 }
//             } while (innerException2);

//             while (ageCounter != 0) {
//                 switch (ageChecker) {
//                     case 1:
//                         registration();
//                         ageCounter = 0;
//                         break;
//                     case 0:
//                         System.exit(1);
//                         ageCounter = 0;
//                         break;
//                     default:
//                         do {
//                             try {
//                                 ageCounter = -1;
//                                 System.out.println("Wrong input. Enter either 0 or 1:");
//                                 ageChecker = input.nextInt();
//                                 innerException3 = false;
//                                 break;
//                             } catch (ArithmeticException ex) {
//                                 System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                                 input.nextLine();
//                             } catch (InputMismatchException ex) {
//                                 System.out.println("Wrong Input. Integer is required\nEnter Again:\n");
//                                 input.nextLine();
//                             } catch (NoSuchElementException ex) {
//                                 System.out.println("Enter Again. Nothing Entered.");
//                                 input.nextLine();
//                             }
//                         } while (innerException3);
//                 }
//             }
//         } else {
//             System.out.println("Registered Successfully!");
//             writeUserToFile(userRegistration);
//         }
//     }

//     public static void writeUserToFile(String[] userRegistration) {
//         try {
//             FileWriter writer = new FileWriter(USERS_FILE, true); // Append mode
//             BufferedWriter bufferedWriter = new BufferedWriter(writer);

//             String userData = userRegistration[3] + ", " + userRegistration[4] + "\n";

//             bufferedWriter.write(userData);
//             bufferedWriter.close();
//         } catch (IOException e) {
//             System.out.println("Error writing to file: " + e.getMessage());
//         }
//     }

//     public static boolean isEmailExists(String email) {
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

//     public static void login() {
//         Scanner input = new Scanner(System.in);

//         boolean loginSuccessful = false;

//         while (!loginSuccessful) {
//             try {
//                 System.out.print("Enter your email address: ");
//                 userLogin[0] = input.next();

//                 System.out.print("Enter your password: ");
//                 userLogin[1] = input.next();

//                 // Check if the entered email and password match any registered user
//                 if (checkUserCredentials(userLogin)) {
//                     System.out.println("Login successful!");
//                     loginSuccessful = true;
//                 } else {
//                     System.out.print("Invalid email or password. Please try again: ");
//                 }
//             } catch (Exception e) {
//                 System.out.println("An error occurred: " + e.getMessage());
//                 input.nextLine(); // Consume the remaining newline character
//             }
//         }
//     }

//     public static boolean checkUserCredentials(String[] userLogin) {
//         try {
//             Scanner scanner = new Scanner(new File(USERS_FILE));
//             while (scanner.hasNextLine()) {
//                 String line = scanner.nextLine();
//                 String[] userData = line.split(", ");
//                 if (userData.length == 2 && userData[0].equals(userLogin[0]) && userData[1].equals(userLogin[1])) {
//                     scanner.close();
//                     return true;
//                 }
//             }
//             scanner.close();
//         } catch (FileNotFoundException e) {
//             System.out.println("Error reading user data file: " + e.getMessage());
//         }
//         return false;
//     }

//     public static boolean containsUpperCase(String str) {
//         for (char c : str.toCharArray()) {
//             if (Character.isUpperCase(c)) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     public static boolean containsLowerCase(String str) {
//         for (char c : str.toCharArray()) {
//             if (Character.isLowerCase(c)) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     public static void displayBookingHistory() {
//         System.out.println("Booking History:");
//         for (Booking booking : bookings) {
//             if (booking.getEmail().equals(userLogin[0])) {
//                 System.out.println(booking);
//             }
//         }
//     }

//     static class Booking {
//         private String email;
//         private String movieName;
//         private String dateTime;
//         private double totalPrice;
//         private int seats;

//         public Booking(String email, String movieName, String dateTime, double totalPrice, int seats) {
//             this.email = email;
//             this.movieName = movieName;
//             this.dateTime = dateTime;
//             this.totalPrice = totalPrice;
//             this.seats = seats;
//         }

//         public String getEmail() {
//             return email;
//         }

//         @Override
//         public String toString() {
//             return "Booking{" +
//                     "email='" + email + '\'' +
//                     ", movieName='" + movieName + '\'' +
//                     ", dateTime='" + dateTime + '\'' +
//                     ", totalPrice=" + totalPrice +
//                     ", seats=" + seats +
//                     '}';
//         }
//     }
// }
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CinemaTicketManagementSystem {
    static final String USERS_FILE = "users.txt";
    static final String MOVIES_FILE = "movies.txt";
    static final String BOOKINGS_FILE = "bookings.txt";

    static List<String[]> users = new ArrayList<>();
    static List<String> bookings = new ArrayList<>();
    static String[] userLogin = new String[2];
    static String[] adminUser = {"admin@cinema.com", "admin123"};
    static String[][] movies = new String[12][6]; // title, genre, duration, rating, available seats, price

    public static void main(String[] args) {
        loadMovies();
        loadUsers();
        loadBookings();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Cinema Ticket Management System!");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int userType = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (userType) {
                case 1:
                    adminLogin(scanner);
                    break;
                case 2:
                    customerMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void loadMovies() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MOVIES_FILE))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] movieData = line.split(",");
                movies[index++] = movieData;
            }
        } catch (FileNotFoundException e) {
            initializeMovies();
            saveMovies();
        } catch (IOException e) {
            System.out.println("Error loading movies: " + e.getMessage());
        }
    }

    public static void initializeMovies() {
        movies[0] = new String[]{"Inception", "Sci-Fi", "148", "8.8", "100", "800"};
        movies[1] = new String[]{"The Dark Knight", "Action", "152", "9.0", "100", "850"};
        movies[2] = new String[]{"Interstellar", "Sci-Fi", "169", "8.6", "100", "750"};
        movies[3] = new String[]{"The Matrix", "Sci-Fi", "136", "8.7", "100", "700"};
        movies[4] = new String[]{"Avatar", "Fantasy", "162", "7.8", "100", "900"};
        movies[5] = new String[]{"Avengers: Endgame", "Action", "181", "8.4", "100", "950"};
        movies[6] = new String[]{"Titanic", "Romance", "195", "7.8", "100", "700"};
        movies[7] = new String[]{"Jurassic Park", "Adventure", "127", "8.1", "100", "650"};
        movies[8] = new String[]{"The Lion King", "Animation", "88", "8.5", "100", "600"};
        movies[9] = new String[]{"Toy Story", "Animation", "81", "8.3", "100", "550"};
        movies[10] = new String[]{"Frozen", "Animation", "102", "7.4", "100", "650"};
        movies[11] = new String[]{"Finding Nemo", "Animation", "100", "8.1", "100", "600"};
    }

    public static void saveMovies() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MOVIES_FILE))) {
            for (String[] movie : movies) {
                if (movie[0] != null) {
                    writer.write(String.join(",", movie));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
        }
    }

    public static void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                users.add(userData);
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    public static void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (String[] user : users) {
                writer.write(String.join(",", user));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public static void loadBookings() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKINGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bookings.add(line);
            }
        } catch (FileNotFoundException e) {
            // Create the file if it doesn't exist
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKINGS_FILE))) {
                // File created, no need to write anything initially
            } catch (IOException ex) {
                System.out.println("Error creating bookings file: " + ex.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error loading bookings: " + e.getMessage());
        }
    }

    public static void saveBookings() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKINGS_FILE))) {
            for (String booking : bookings) {
                writer.write(booking);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving bookings: " + e.getMessage());
        }
    }

    public static void adminLogin(Scanner scanner) {
        System.out.print("Enter admin email: ");
        String email = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (email.equals(adminUser[0]) && password.equals(adminUser[1])) {
            System.out.println("Admin login successful!");
            adminMenu(scanner);
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    public static void customerMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void register(Scanner scanner) {
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        users.add(new String[]{firstName, lastName, email, password, "false"});
        saveUsers();
        System.out.println("Registration successful!");
    }

    public static void login(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (String[] user : users) {
            if (user[2].equals(email) && user[3].equals(password)) {
                userLogin = user;
                System.out.println("Login successful!");
                customerActions(scanner);
                return;
            }
        }
        System.out.println("Invalid email or password. Please try again.");
    }

    public static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Movie");
            System.out.println("2. Update Movie");
            System.out.println("3. Delete Movie");
            System.out.println("4. View All Movies");
            System.out.println("5. View All Bookings");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addMovie(scanner);
                    break;
                case 2:
                    updateMovie(scanner);
                    break;
                case 3:
                    deleteMovie(scanner);
                    break;
                case 4:
                    viewAllMovies();
                    break;
                case 5:
                    viewAllBookings();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void addMovie(Scanner scanner) {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter movie genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter movie duration (in minutes): ");
        String duration = scanner.nextLine();
        System.out.print("Enter movie rating: ");
        String rating = scanner.nextLine();
        System.out.print("Enter ticket price: ");
        String price = scanner.nextLine();

        for (int i = 0; i < movies.length; i++) {
            if (movies[i][0] == null) {
                movies[i] = new String[]{title, genre, duration, rating, "100", price};
                break;
            }
        }
        saveMovies();
        System.out.println("Movie added successfully!");
    }

    public static void updateMovie(Scanner scanner) {
        System.out.print("Enter movie title to update: ");
        String title = scanner.nextLine();

        for (int i = 0; i < movies.length; i++) {
            if (movies[i][0] != null && movies[i][0].equalsIgnoreCase(title)) {
                System.out.print("Enter new genre: ");
                movies[i][1] = scanner.nextLine();
                System.out.print("Enter new duration: ");
                movies[i][2] = scanner.nextLine();
                System.out.print("Enter new rating: ");
                movies[i][3] = scanner.nextLine();
                System.out.print("Enter new price: ");
                movies[i][5] = scanner.nextLine();
                saveMovies();
                System.out.println("Movie updated successfully!");
                return;
            }
        }

        System.out.println("Movie not found.");
    }

    public static void deleteMovie(Scanner scanner) {
        System.out.print("Enter movie title to delete: ");
        String title = scanner.nextLine();

        for (int i = 0; i < movies.length; i++) {
            if (movies[i][0] != null && movies[i][0].equalsIgnoreCase(title)) {
                movies[i] = new String[6]; // Clear the movie details
                saveMovies();
                System.out.println("Movie deleted successfully!");
                return;
            }
        }

        System.out.println("Movie not found.");
    }

    public static void viewAllMovies() {
        System.out.println("\nAll Movies:");
        for (String[] movie : movies) {
            if (movie[0] != null) {
                System.out.println("Title: " + movie[0] + ", Genre: " + movie[1] + ", Duration: " + movie[2] +
                        " mins, Rating: " + movie[3] + ", Available Seats: " + movie[4] + ", Price: $" + movie[5]);
            }
        }
    }

    public static void viewAllBookings() {
        System.out.println("\nAll Bookings:");
        for (String booking : bookings) {
            System.out.println(booking);
        }
    }

    public static void customerActions(Scanner scanner) {
        while (true) {
            System.out.println("\nCustomer Actions:");
            System.out.println("1. Book a Ticket");
            System.out.println("2. View All Movies");
            System.out.println("3. View Booking History");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    bookTicket(scanner);
                    break;
                case 2:
                    viewAllMovies();
                    break;
                case 3:
                    viewBookingHistory();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void bookTicket(Scanner scanner) {
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.length; i++) {
            if (movies[i][0] != null) {
                System.out.println((i + 1) + ". " + movies[i][0] + " - $" + movies[i][5] + " - Available Seats: " + movies[i][4]);
            }
        }

        System.out.print("Enter the number of the movie you want to book a ticket for: ");
        int selectedNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (selectedNumber < 1 || selectedNumber > movies.length || movies[selectedNumber - 1][0] == null) {
            System.out.println("Invalid movie number.");
            return;
        }

        String[] selectedMovie = movies[selectedNumber - 1];

        System.out.print("Enter the number of seats you want to book: ");
        int seatsToBook = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        int availableSeats = Integer.parseInt(selectedMovie[4]);
        if (seatsToBook > availableSeats) {
            System.out.println("Not enough seats available. Please try again.");
            return;
        }

        double totalPrice = seatsToBook * Double.parseDouble(selectedMovie[5]);
        System.out.println("Total Price: $" + totalPrice);
        System.out.print("Please enter the amount to pay: ");
        double paidAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (paidAmount != totalPrice) {
            System.out.println("Incorrect amount. Booking canceled.");
            return;
        }

        String bookingTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String booking = userLogin[2] + "," + selectedMovie[0] + "," + bookingTime + "," + totalPrice + "," + seatsToBook;
        bookings.add(booking);
        selectedMovie[4] = String.valueOf(availableSeats - seatsToBook);
        saveMovies();
        saveBookings();
        System.out.println("Booking successful! Enjoy your movie.");

        generateInvoice(booking, selectedMovie, seatsToBook, totalPrice);

        // Send notification (console-based for now)
        System.out.println("Notification: Booking confirmation sent to " + userLogin[2]);
    }

    public static void generateInvoice(String booking, String[] movie, int seats, double totalPrice) {
        String[] bookingDetails = booking.split(",");
        String customerEmail = bookingDetails[0];
        String movieTitle = bookingDetails[1];
        String bookingTime = bookingDetails[2];

        String invoiceContent = "********** CINEMA INVOICE **********\n" +
                "Customer Email: " + customerEmail + "\n" +
                "Movie Title: " + movieTitle + "\n" +
                "Booking Time: " + bookingTime + "\n" +
                "Seats Booked: " + seats + "\n" +
                "Total Price: $" + totalPrice + "\n" +
                "*************************************\n";

        String invoiceFileName = "invoice_" + bookingTime.replace(" ", "_").replace(":", "-") + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(invoiceFileName))) {
            writer.write(invoiceContent);
            System.out.println("Invoice generated: " + invoiceFileName);
        } catch (IOException e) {
            System.out.println("Error generating invoice: " + e.getMessage());
        }
    }

    public static void viewBookingHistory() {
        System.out.println("\nBooking History:");
        for (String booking : bookings) {
            if (booking.startsWith(userLogin[2])) {
                System.out.println(booking);
            }
        }
    }
}


