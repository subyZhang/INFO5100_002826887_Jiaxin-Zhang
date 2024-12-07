import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.UUID;

public class BasicImageConverter implements ImageConverter {

    // Converts the input image to the specified format and saves it to the provided directory
    @Override
    public void convert(File directory, BufferedImage inputFile, String outputFormat) throws IOException {

        // Generate a random UUID
        UUID uuid = UUID.randomUUID();

        // Create the output file by replacing the extension of the input file with the desired output format
        File outputFile = new File(directory, uuid.toString() + "." + outputFormat);

        // Write the image in the specified output format to the output file
        ImageIO.write(inputFile, outputFormat, outputFile);
    }
}

