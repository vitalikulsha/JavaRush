package Level06.Lecture13;

import java.io.*;

/*
1. Разберись, что делает программа.
2. В статическом блоке считай 2 имени файла firstFileName и secondFileName
3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует интерфейс ReadFileInterface
(Подумай, что больше подходит Thread или Runnable)
3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содерживое.
3.2. Метод getFileName должен возвращать содержимое файла.
3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить последовательный вывод файлов
4.1. Для этого добавь вызов соответствующего метода.
 */
public class Task13_FileOutputSequence {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here
    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {
        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String content;

        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String str = reader.readLine();
                StringBuilder file = new StringBuilder();
                while (str != null) {
                    file.append(str + " ");
                }
                content = file.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileName;
        }
    }
}
