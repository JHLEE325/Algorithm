import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            
            while (line.contains("BUG")) {
                line = line.replaceAll("BUG", "");
            }
            
            System.out.println(line);
        }
    }
}