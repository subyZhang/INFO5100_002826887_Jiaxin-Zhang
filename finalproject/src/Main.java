import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.awt.image.BufferedImage;

public class Main extends Application {
    // VBox to hold the images and their details
    private VBox imageContainer;

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }

    // The start method for the JavaFX application
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Image Management Tool");

        // Initialize the container for images and their properties
        imageContainer = new VBox(10);

        // Button to upload images
        Button uploadButton = new Button("Upload Image");
        uploadButton.setOnAction(e -> uploadImage(primaryStage)); // Attach event handler to upload images

        // ScrollPane to allow scrolling through the images container
        ScrollPane  scrollPane = new ScrollPane(imageContainer);

        // Layout the UI with VBox
        VBox root = new VBox(20, uploadButton, scrollPane);
        Scene scene = new Scene(root, 800, 600);  // Create the scene with root container

        primaryStage.setScene(scene); // Set the scene on the primary stage
        primaryStage.show(); // Show the primary stage
    }

    // Method to upload an image and display its properties
    private void uploadImage(Stage stage) {
        // FileChooser to select one or more image files
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.bmp")
        );
        List<File> files = fileChooser.showOpenMultipleDialog(stage); // Allow multiple file selection

        // If files are selected, process each file
        if (files != null) {
            for (File file : files) {
                try {
                    // Create a container for the image and its properties
                    HBox imageBox = new HBox(5);
                    // Load the selected image
                    Image originImage = new Image(file.toURI().toString());
                    ImageView imageView = new ImageView(originImage);
                    imageView.setFitWidth(100); // Set thumbnail width
                    imageView.setFitHeight(100); // Set thumbnail height

                    // Display image properties (width, height, and file path)
                    VBox textBox = new VBox(10);
                    textBox.getChildren().add(new Text("Width: " + originImage.getWidth()));
                    textBox.getChildren().add(new Text("Height: " + originImage.getHeight()));
                    Text path = new Text("Location: " + file.getAbsolutePath());
                    path.setWrappingWidth(400); // Set path text wrapping
                    textBox.getChildren().add(path);
                    textBox.setPrefWidth(400);

                    // Dropdown for image format selection (for conversion)
                    VBox convertContainer = new VBox(10);
                    ComboBox<String> formatComboBox = new ComboBox<>();
                    formatComboBox.getItems().addAll("png", "jpeg", "jpg", "bmp");
                    formatComboBox.setValue("png");  // Default format

                    // Filter buttons to apply image filters
                    VBox filterBtns = new VBox(10);
                    Button noFilterButton = new Button("No Filter");
                    Button grayscaleFilterButton = new Button("Grayscale Filter");
                    Button contrastFilterButton = new Button("Contrast Filter");

                    final boolean[] isGrayscaleFilter = {false};
                    final boolean[] isBrightnessFilter = {false};

                    // Convert button with action handler to convert image to selected format
                    Button convertButton = new Button("Convert");
                    convertButton.setOnAction(e -> {
                        if (!imageContainer.getChildren().isEmpty()) {
                            // DirectoryChooser to select a location to save the converted image
                            DirectoryChooser directoryChooser = new DirectoryChooser();
                            directoryChooser.setTitle("Save Converted Image");
                            File selectedDirectory = directoryChooser.showDialog(stage);

                            if (selectedDirectory != null) {
                                try {
                                    BufferedImage bufferedImage = ImageConverterFactory.javafxImageToBufferedImage(originImage);

                                    // Apply the selected filter (if any) to the image
                                    if (isGrayscaleFilter[0]) {
                                        bufferedImage = GrayscaleFilter.getInstance().convert(bufferedImage);
                                    } else if (isBrightnessFilter[0]) {
                                        bufferedImage = ContrastFilter.getInstance().convert(bufferedImage);
                                    }

                                    // Get the appropriate image converter based on the selected format
                                    ImageConverter converter = ImageConverterFactory.getConverter(formatComboBox.getValue());
                                    converter.convert(selectedDirectory, bufferedImage, formatComboBox.getValue());

                                    showAlert("Success", "Image converted and saved successfully.");
                                } catch (IOException ex) {
                                    showAlert("Conversion Error", "An error occurred during conversion: " + ex.getMessage());
                                }
                            }
                        } else {
                            showAlert("No Image", "Please upload an image before converting.");
                        }
                    });
                    convertContainer.getChildren().addAll(formatComboBox, convertButton);

                    // Reset the image to the original (no filter)
                    noFilterButton.setOnAction(e -> {
                        isGrayscaleFilter[0] = false;
                        isBrightnessFilter[0] = false;
                        imageView.setImage(originImage);
                    });

                    // Apply grayscale filter
                    grayscaleFilterButton.setOnAction(e -> {
                        isGrayscaleFilter[0] = true;
                        isBrightnessFilter[0] = false;
                        BufferedImage bufferedImage = GrayscaleFilter.getInstance().convert(ImageConverterFactory.javafxImageToBufferedImage(originImage));
                        imageView.setImage(ImageConverterFactory.bufferedImageToJavaFXImage(bufferedImage));
                    });

                    // Apply contrast filter
                    contrastFilterButton.setOnAction(e -> {
                        isGrayscaleFilter[0] = false;
                        isBrightnessFilter[0] = true;
                        BufferedImage bufferedImage = ContrastFilter.getInstance().convert(ImageConverterFactory.javafxImageToBufferedImage(originImage));
                        imageView.setImage(ImageConverterFactory.bufferedImageToJavaFXImage(bufferedImage));
                    });

                    filterBtns.getChildren().addAll(noFilterButton, grayscaleFilterButton, contrastFilterButton);

                    // Create a layout for the image and its properties
                    imageBox.setPadding(new Insets(10, 10, 10, 10));
                    imageBox.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px;");
                    imageBox.getChildren().addAll(imageView, textBox, filterBtns,convertContainer);

                    // Store the image and file using ImageWrapper
                    ImageWrapper wrapper = new ImageWrapper(imageView, file);
                    imageBox.setUserData(wrapper);

                    imageContainer.getChildren().add(imageBox);
                } catch (Exception ex) {
                    showAlert("Error uploading image", "An error occurred: " + ex.getMessage());
                }
            }
        }
    }

    // Method to display error or success alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}