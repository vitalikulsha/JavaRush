package Level06.Lecture13.Task01_FactoryMethodPattern;

import Level06.Lecture13.Task01_FactoryMethodPattern.common.*;

public class ImageReaderFactory {
    protected static ImageReader getImageReader(ImageTypes type) {
        if (ImageTypes.BMP == type) {
            return new BmpReader();
        } else if (ImageTypes.JPG == type) {
            return new JpgReader();
        } else if (ImageTypes.PNG == type) {
            return new PngReader();
        } else {
            throw (new IllegalArgumentException("Неизвестный тип картинки"));
        }
    }
}
