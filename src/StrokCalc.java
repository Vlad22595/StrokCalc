import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class StrokCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input:");
        Main result = new Main();
        String n = input.nextLine();
        String answer = result.cals(n);
        System.out.println("Output:\n" + "\"" + answer + "\"");
    }
}
class Main {
    public String cals(String input) {
        String result;
        String[] znak = {"+", "-", "*", "/"};

        for (int i = 0; i < znak.length; i++) {
            boolean zn = input.contains(znak[i]);
            if (zn){
                znak = new String[]{znak[i]};
            }
        }

        String[] inputSplit = input.split(Arrays.toString(znak));

        if (inputSplit.length != 2) {
            throw new RuntimeException("Неправильно введено выражение");
        }

        boolean b = (inputSplit[0].startsWith("\"") && inputSplit[0].endsWith("\" "));
        if (!b){
            throw new RuntimeException("Неправильно введено выражение");}

        String x = inputSplit[0].replace("\"", "").replace(" ", "");
        String y = inputSplit[1].replace("\"", "").replace(" ","");

        if ( x.length() > 10 || y.length() > 10) {
            throw new RuntimeException("Максимальное число символов 10");
        }

        if (Objects.equals(znak[0], "+")) {
            boolean b1 = (inputSplit[1].endsWith("\"") && inputSplit[1].startsWith(" \""));
            if (!b1){
                throw new RuntimeException("Неправильно введено выражение");}
            result = x + y;
        } else if (Objects.equals(znak[0], "-")) {
            boolean b2 = (inputSplit[1].endsWith("\"") && inputSplit[1].startsWith(" \""));
            if (!b2){
                throw new RuntimeException("Неправильно введено выражение");}
            result = x.replace(y, "");
        } else if (Objects.equals(znak[0], "*")) {
            int y1 = Integer.parseInt(y);
            if (y1 < 1 || y1 > 10) {
                throw new RuntimeException("Множитель от 1 до 10");}
            result = x.repeat(y1);
        } else if (Objects.equals(znak[0], "/" )) {
            int y2 = Integer.parseInt(y);
            if (y2 < 1 || y2 > 10) {
              throw new RuntimeException(" Делитель от 1 до 10");
            }
            int x2 = x.length();
            int ch = x2 / y2;
            String sum = "";
            for (int i = 0; i <= ch; i++) {
                sum += x.charAt(i);}
            result = sum;
        } else {
            throw new RuntimeException("Неправильный ввод знака");}

        if (Objects.requireNonNull(result).length() > 40) {
            String sum = "";
            for (int i = 0; i <= 40; i++) {
                sum += result.charAt(i);
            }result = sum + "...";
        }
        return result;
    }
}