import javafx.scene.image.ImageView;

import java.io.File;

public class ImageWrapper {
    // The ImageView associated with the image
    private ImageView imageView;

    // The File representing the image source
    private File file;

    // Constructor to initialize the ImageWrapper with an ImageView and a File
    public ImageWrapper(ImageView imageView, File file) {
        this.imageView = imageView;
        this.file = file;
    }

    // Getter method to retrieve the ImageView
    public ImageView getImageView() {
        return imageView;
    }

    // Getter method to retrieve the File associated with the ImageView
    public File getFile() {
        return file;
    }
}
