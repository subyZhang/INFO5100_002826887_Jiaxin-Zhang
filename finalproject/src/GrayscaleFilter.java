import java.awt.*;
import java.awt.image.BufferedImage;

class GrayscaleFilter extends Filter {
    // Singleton instance of the GrayscaleFilter
    public static GrayscaleFilter instance = null;

    // Method to convert the given image to grayscale
    @Override
    public BufferedImage convert(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth(); // Get the width of the image
        int height = bufferedImage.getHeight(); // Get the height of the image

        // Create a new BufferedImage to store the grayscale result with the same dimensions
        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Iterate through each pixel of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Get the color of the current pixel
                Color color = new Color(bufferedImage.getRGB(x, y));

                // Calculate the grayscale value using the standard luminance formula
                int gray = (int) (color.getRed() * 0.3 + color.getGreen() * 0.59 + color.getBlue() * 0.11);

                // Create a new color with the grayscale value for all RGB channels
                Color grayColor = new Color(gray, gray, gray);

                // Set the grayscale color to the corresponding pixel in the output image
                grayImage.setRGB(x, y, grayColor.getRGB());
            }
        }
        return grayImage;
    }

    // Method to get the singleton instance of the GrayscaleFilter
    public static GrayscaleFilter getInstance() {
        // If the instance is null, create a new instance
        if (instance == null) {
            instance = new GrayscaleFilter();
        }
        return instance; // Return the singleton instance
    }
}

