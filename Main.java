Ось приклад базового оброблювання даних в Java. Цей код виконує декілька операцій: зчитування даних з файла, перетворення даних, фільтрація та запис даних до іншого файла.

```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicDataProcessing {

    public static void main(String[] args) {
        List<String> inputData = readFile("input.txt");
        List<String> processedData = processData(inputData);
        writeFile("output.txt", processedData);
    }

    public static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static List<String> processData(List<String> inputData) {
        return inputData.stream()
                .map(String::toLowerCase)
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
    }

    public static void writeFile(String fileName, List<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
Зауважте, що цей код має менше 150 рядків, оскільки Java - це мова з сильним використанням бібліотек, яка не вимагає великої кількості коду для виконання базових операцій обробки даних.