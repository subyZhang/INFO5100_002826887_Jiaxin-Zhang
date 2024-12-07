import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class ImageConverterFactory {

    // Returns an appropriate ImageConverter based on the requested format
    public static ImageConverter getConverter(String format) {
        // Check if the format is one of the supported types
        if (format.equalsIgnoreCase("png") || format.equalsIgnoreCase("jpeg")
            || format.equalsIgnoreCase("jpg") || format.equalsIgnoreCase("bmp")
        ) {
            return new BasicImageConverter(); // Return a new BasicImageConverter for supported formats
        }

        // If the format is unsupported, throw an exception
        throw new IllegalArgumentException("Unsupported format: " + format);
    }

    // Converts a JavaFX Image to a BufferedImage
    public static BufferedImage javafxImageToBufferedImage(Image fxImage) {
        // Use SwingFXUtils to convert from JavaFX Image to AWT BufferedImage
        return SwingFXUtils.fromFXImage(fxImage, null);
    }

    // Converts a BufferedImage to a JavaFX Image
    public static Image bufferedImageToJavaFXImage(BufferedImage bufferedImage) {
        // Use SwingFXUtils to convert from AWT BufferedImage to JavaFX Image
        return SwingFXUtils.toFXImage(bufferedImage, null);
    }

}

