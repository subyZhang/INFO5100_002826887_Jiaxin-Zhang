import java.awt.*;
import java.awt.image.BufferedImage;

public class ContrastFilter extends Filter {
    // Singleton instance of the ContrastFilter
    public static ContrastFilter instance = null;

    // Default Constructor
    public ContrastFilter() {
    }

    // Method to apply a contrast filter to the given image
    @Override
    public BufferedImage convert(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth(); // Get the width of the image
        int height = bufferedImage.getHeight(); // Get the height of the image

        // Create a new BufferedImage to store the result with the same dimensions and type
        BufferedImage contrastImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Iterate through each pixel of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Get the color of the current pixel
                Color color = new Color(bufferedImage.getRGB(x, y));

                // Compute the inverted color values for contrast adjustment
                Color invertedColor = new Color((255.0f - color.getRed()) / 255.0f, (255.0f - color.getGreen()) / 255.0f, (255.0f - color.getBlue()) / 255.0f, (color.getAlpha()) / 255.0f);
                // Set the inverted color to the corresponding pixel in the output image
                contrastImage.setRGB(x, y, invertedColor.getRGB());
            }
        }
        return contrastImage;
    }

    // Method to get the singleton instance of the ContrastFilter
    public static ContrastFilter getInstance() {
        // If the instance is null, create a new instance
        if (instance == null) {
            instance = new ContrastFilter();
        }
        return instance; // Return the singleton instance
    }
}
