import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] ignored = {"i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"};

        if (!sc.hasNextLine()) return;
        String line = sc.nextLine();
        String[] words = line.split(" ");

        StringBuilder sb = new StringBuilder();

        sb.append(Character.toUpperCase(words[0].charAt(0)));

        for (int i = 1; i < words.length; i++) {
            boolean isIgnored = false;
            for (String skip : ignored) {
                if (words[i].equals(skip)) {
                    isIgnored = true;
                    break;
                }
            }

            if (!isIgnored) {
                sb.append(Character.toUpperCase(words[i].charAt(0)));
            }
        }

        System.out.println(sb.toString());
        sc.close();
    }
}