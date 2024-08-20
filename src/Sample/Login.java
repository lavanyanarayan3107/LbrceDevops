package Sample;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    // In-memory user credentials storage (username -> password)
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Sample user for demonstration purposes
        users.put("user1", "password123");
        users.put("user2", "securePass456");

        Scanner scanner = new Scanner(System.in);

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

        scanner.close();
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
}
