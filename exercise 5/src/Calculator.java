import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Calculator extends Application {

    public static void launchApp(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label inputLabel = new Label("Enter an integer (n):");
        TextField inputField = new TextField();

        ToggleGroup operationGroup = new ToggleGroup();
        RadioButton sumButton = new RadioButton("Calculate the sum from 1 to n");
        sumButton.setToggleGroup(operationGroup);
        sumButton.setSelected(true);

        RadioButton primeButton = new RadioButton("Count the number of primes up to n");
        primeButton.setToggleGroup(operationGroup);

        RadioButton fibonacciButton = new RadioButton("Find the nth Fibonacci number");
        fibonacciButton.setToggleGroup(operationGroup);

        RadioButton factorialButton = new RadioButton("Calculate the factorial of n");
        factorialButton.setToggleGroup(operationGroup);

        VBox radioButtons = new VBox(5, sumButton, primeButton, fibonacciButton, factorialButton);

        Button calculateButton = new Button("Calculate");
        Label resultLabel = new Label("Result:");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setPrefHeight(100);

        calculateButton.setOnAction(e -> {
            String input = inputField.getText();
            try {
                int n = Integer.parseInt(input);
                String result;
                if (sumButton.isSelected()) {
                    result = "The sum is: " + calculateSum(n);
                } else if (primeButton.isSelected()) {
                    result = "The primes count is: " + primeCountCalculator(n);
                } else if (fibonacciButton.isSelected()) {
                    result = "The " + n + "th Fibonacci number is: " + fibonacciCalculator(n);
                } else if (factorialButton.isSelected()) {
                    result = "The factorial of " + n + " is: " + factorialsCalculator(n);
                } else {
                    result = "Please select an operation.";
                }
                resultArea.setText(result);
            } catch (NumberFormatException ex) {
                resultArea.setText("Invalid input! Please enter a valid integer.");
            }
        });

        root.getChildren().addAll(inputLabel, inputField, radioButtons, calculateButton, resultLabel, resultArea);

        // Set up the stage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Calculate the sum
    private int calculateSum(int n) {
        return n * (n + 1) / 2;
    }

    // Count the primes
    private int primeCountCalculator(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    // Check if a number is a prime
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Calculate the nth Fibonacci number
    private int fibonacciCalculator(int n) {
        int a = 0;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return a;
    }

    // Calculate the factorial of n
    private int factorialsCalculator(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}