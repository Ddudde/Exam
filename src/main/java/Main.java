import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        String[] exam = new String[0], config = new String[0];
        try {
            exam = Files.readString(Paths.get("exam.txt")).split("\n");
            config = Files.readString(Paths.get("config.txt")).split("\n");
        } catch (IOException e) {
            Scanner in = new Scanner(System.in);
            System.out.print("Нужны файлы: exam.txt, config.txt");
            System.out.print("Введи что-нибудь для выхода...");
            in.next();
            in.close();
        }
        System.out.println("Билет:");
        for (int i = 0; i < config.length; i++){
            config[i] = config[i].replaceAll("[^\\,-0123456789]","");
        }
        int l = Integer.parseInt(config[0]) + 1;
        for(int i = 1; i < l; i++){
            String[] s = config[i].split(",");
            String[] s1 = s[ThreadLocalRandom.current().nextInt(0, s.length)].split("-");
            if(s1.length > 1)
                System.out.println(exam[ThreadLocalRandom.current().nextInt(Integer.parseInt(s1[0])-1, Integer.parseInt(s1[1]))]);
            else
                System.out.println(exam[Integer.parseInt(s1[0])-1]);
        }
        Scanner in = new Scanner(System.in);
        System.out.print("Введи что-нибудь для выхода...");
        in.next();
        in.close();
    }
}
