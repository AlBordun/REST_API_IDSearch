import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:

public class Class2Solution2 {


    public static void main(String[] args) {
        Filecheck("T:\\GeekBrains\\Java\\Class 2");
    }

    private static void Filecheck(String pathDir) {
        File file = new File(pathDir);
        if (!(file.exists() || file.isDirectory())) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String fileName : file.list()) {
            sb.append(fileName).append(System.lineSeparator());
            System.out.print(sb);
        }
    }
}
