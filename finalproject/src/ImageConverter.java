import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface ImageConverter {
    void convert(File directory, BufferedImage inputFile, String outputFormat) throws IOException;
}

