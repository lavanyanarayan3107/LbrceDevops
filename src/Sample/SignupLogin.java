package Sample;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupLogin {

    // In-memory user credentials storage (username -> password)
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the system!");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    signup(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    // Method for user signup
    public static void signup(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        String email;
        while (true) {
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }

        String password;
        while (true) {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            if (isValidPassword(password)) {
                break;
            } else {
                System.out.println("Password must be at least 8 characters long.");
            }
        }

        String confirmPassword;
        while (true) {
            System.out.print("Confirm your password: ");
            confirmPassword = scanner.nextLine();
            if (password.equals(confirmPassword)) {
                break;
            } else {
                System.out.println("Passwords do not match. Please try again.");
            }
        }

        // Store user credentials
        users.put(username, password);
        System.out.println("Signup successful! You can now log in.");
    }

    // Method for user login
    public static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Perform login validation
        if (validateLogin(username, password)) {
            System.out.println("Login successful! Welcome, " + username + ".");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    // Method to validate the login
    private static boolean validateLogin(String username, String password) {
        // Check if the username exists
        if (users.containsKey(username)) {
            // Check if the provided password matches the stored password
            return users.get(username).equals(password);
        }
        return false;
    }

    // Method to validate email format
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to validate password (minimum 8 characters)
    public static boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
}
