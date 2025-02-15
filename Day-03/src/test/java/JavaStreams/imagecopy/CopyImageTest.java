package JavaStreams.imagecopy;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class CopyImageTest {

    private static final String SOURCE_IMAGE = "E:\\source_image.png";
    private static final String DEST_IMAGE = "E:\\copied_image.png";
    private static final String NON_EXISTENT_IMAGE = "E:\\non_existent.png";

    @Test
    void testImageCopy_Success() throws IOException {
        byte[] imageData = CopyImage.ImageToByteArray(SOURCE_IMAGE);
        CopyImage.BytesToImage(imageData, DEST_IMAGE);

        File copiedImage = new File(DEST_IMAGE);
        assertTrue(copiedImage.exists(), "Copied image should exist.");
        assertEquals(new File(SOURCE_IMAGE).length(), copiedImage.length(), "File sizes should match.");
    }

    @Test
    void testImageCopy_NonExistentFile() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            CopyImage.ImageToByteArray(NON_EXISTENT_IMAGE);
        });
        assertTrue(exception.getCause() instanceof IOException, "Should throw IOException for missing file.");
    }

    @Test
    void testImageCopy_EmptyFile() throws IOException {
        File emptyFile = new File(SOURCE_IMAGE);
        if (emptyFile.exists()) {
            emptyFile.delete();
        }
        emptyFile.createNewFile();

        byte[] imageData = CopyImage.ImageToByteArray(SOURCE_IMAGE);
        CopyImage.BytesToImage(imageData, DEST_IMAGE);

        File copiedImage = new File(DEST_IMAGE);
        assertTrue(copiedImage.exists(), "Copied empty image should exist.");
        assertEquals(0, copiedImage.length(), "Copied file should also be empty.");
    }
}
