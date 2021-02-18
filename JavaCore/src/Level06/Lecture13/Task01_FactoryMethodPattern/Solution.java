package Level06.Lecture13.Task01_FactoryMethodPattern;

import Level06.Lecture13.Task01_FactoryMethodPattern.common.ImageReader;
import Level06.Lecture13.Task01_FactoryMethodPattern.common.ImageTypes;

/*
1. Внимательно посмотри, какие классы у тебя есть.
2. В отдельных файлах в пакете common создай JpgReader, PngReader, BmpReader,
которые реализуют интерфейс ImageReader.
3. В отдельном файле в основном пакете создай класс ImageReaderFactory с одним методом.
3.1. Подумай, как он должен называться.
3.2. Подумай, какие модификаторы должны быть у этого метода.
4. Этот метод должен:
4.1. Для каждого значения из ImageTypes озвращать соответсвующий Reader,
например, для ImageTypes.JPG - JpgReader;
4.2. Если передан неправильный параметр, то выбрасывать исключение IllegalArgumentException("Неизвестный тип картинки").
 */
public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.DOC);
    }
}
