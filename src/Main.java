import java.util.*;

public class Main {
    public static <string> void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = in.nextLine();
        if (expression.isEmpty()){
            System.out.println("Вы не ввели выражение");
        }
        String result = calс(expression);
        System.out.println(result);
    }
    public static String calс (String input) {
        TreeMap<Integer ,String > map = new TreeMap<>();
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(1,"I");
        String[] arabicArray  = new String[] {"1", "2", "3", "4","5", "6", "7", "8", "9", "10"};
        String[] rimArray  = new String[] {"I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] words = input.split(" ");
        int counterInt = 0;
        int counterRim = 0;
        for (String string : arabicArray) {
            if (words[0].equals(string)) {
                counterInt = counterInt + 1;
            }
            if (words[2].equals(string)) {
                counterInt = counterInt + 1;
            }
            if (counterInt == 2) {
                break;
            }
        }
            for (int i = 0; i< rimArray.length;i++){
                if (words[0].equals(rimArray[i]) ){
                    words[0] = arabicArray[i];
                    counterRim = counterRim+1;
                }
                if (words[2].equals(rimArray[i]) ){
                    words[2] = arabicArray[i];
                    counterRim = counterRim+1;
                }
                if (counterRim==2){
                    break;
                }
            }
        if (counterRim != 2 && counterInt != 2 ){
            throw new RuntimeException(" Неверный ввод чисел - арабские или только римские цифры от 1 до 10 включительно");
        }
        int firstVariable = Integer.parseInt(words[0]);
        int secondVariable = Integer.parseInt(words[2]);
        String result = null;
            result = switch (words[1]) {
                case "+" -> String.valueOf(firstVariable + secondVariable);
                case "-" -> String.valueOf(firstVariable - secondVariable);
                case "*" -> String.valueOf(firstVariable * secondVariable);
                case "/" -> String.valueOf(firstVariable / secondVariable);
                default -> throw new RuntimeException("Неверный знак арифметической операции");
            };
        if (counterRim == 2 ){
            int endResult = Integer.parseInt(result);
            if (endResult<= 0){
                throw new RuntimeException("Ответ меньше 1");
            }
            int arabkey;
            String str = "";
            while (endResult != 0){
                arabkey = map.floorKey(endResult);
                str += map.get(arabkey);
                endResult -= arabkey;
            }
            result = str;
        }
        return result;
    }
}


