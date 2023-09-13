import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();

        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            String csvFilePath = selectedFile.getAbsolutePath();

            ArrayList<String> data = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    data.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Predicate<String> shortWordFilter = word -> word.length() < 5;
            List<String> shortWords = ShortWordFilter.collectAll(data, shortWordFilter);

            System.out.println("Short words in the file:");
            for (String word : shortWords) {
                System.out.println(word);
            }
        } else {
            System.out.println("No file selected.");
        }
    }


}
