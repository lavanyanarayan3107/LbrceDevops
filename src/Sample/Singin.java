package Sample;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Singin {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
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
        
        // Assuming a successful signup if all validations pass
        System.out.println("Signup successful!");
        
        scanner.close();
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
