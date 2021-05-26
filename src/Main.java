import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String str = "yxz yx ghxyxh";
    static char[] result = str.toCharArray();

    public static void main(String[] args) {
        try {
            text1();

        } catch (CheckException exception) {
            exception.printStackTrace();
        }

        try {
            text2();

        } catch (CheckException exception) {
            exception.printStackTrace();
        }

        changeText();

        polText();

        reversText();

        reversText2();

        mas();

        charReplacer(str);

        findMaxAndMin();

        delSpace();

    }

    public static void text1() throws CheckException{
        System.out.println("Задача номер 1");
        System.out.print("Введите слово (проверка на начальный символ \"Е\"");
        System.out.println(" и на конечный символ \"р\") : ");

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(".*р$");

        Matcher matcher = pattern.matcher(text);

        boolean b = matcher.matches();

        if (b == true) {
            System.out.println("TRUE 1 : " + text);
        }else {
            throw  new CheckException(" Конечный символ не совпадает");
        }

        Pattern pattern1 = Pattern.compile("^Е.*");

        matcher = pattern1.matcher(text);

        b = matcher.matches();

        if (b == true) {
            System.out.println("TRUE 2 : " + text);
        }else {
            throw  new CheckException(" Начальный символ не совпадает ");
        }
        System.out.println("");
    }

    public static void text2() throws CheckException {
        String text = " Я програмист ";

        Pattern pattern = Pattern.compile("п.+т");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            int start = matcher.start();

            int end = matcher.end();

            System.out.println("Проверка на подстроку и её позицию в тексте ");
            System.out.println("Найдено совпадение : " + text.substring(start,end) + " - c " + start
                    + " по " + (end - 1) + " символ");
        }
        System.out.println("");
    }

    public static void changeText() {
        System.out.println("Задача номер 2");
        System.out.println("");
        System.out.println("Изменение символа");
        System.out.println(" Введите любой символ");

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(".");

        Matcher matcher = pattern.matcher(text);

        System.out.println(matcher.replaceFirst("X"));
        System.out.println("");
    }

    public static String reverseString(String s){
        String r = "";
        for (int i = s.length() - 1; i >= 0; --i)
            r += s.charAt(i);
        return r;
    }

    public static boolean polText() {
        System.out.println("Задача номер 3");

        System.out.println("Введите палиндром: ");

        Scanner scan = new Scanner(System.in);
        String s = scan.next();

        if(s.equals(reverseString(s))){
            System.out.println("Полиндром");
        }else{
            System.out.println("Не полиндром");
        }
        return s.equals(reverseString(s));
    }

    public static void reversText() {
        System.out.println("");
        System.out.println("Задача номер 4");
        System.out.println("");

        String initial;
        String rev = "";

        Scanner in = new Scanner(System.in);

        System.out.println("Разворачиваем строку с помощью метода");
        System.out.println("Введите строку: ");

        initial = in.nextLine();

        int length = initial.length();

        for(int i = length-1; i>=0; i--)

            rev = rev + initial.charAt(i);

        System.out.println("Перевернутая строка: " +rev);
    }

    public static void reversText2() {
        StringBuffer text = new StringBuffer("Hello Egor");

        System.out.println("И вручную: " + text.reverse() );
        System.out.println();
    }

    public static void mas() {
        System.out.println("Задача номер 5");
        String[] str = new String[]{"Hello","hello","other"};
        str[0] = "Hello";
        str[1] = "hello";
        str[2] = "other";

        System.out.println(str[0]);
        System.out.println(str[1]);
        System.out.println(str[2]);
    }

    public static String charReplacer(String word) {
        System.out.println();
        System.out.println("Задача номер 6");
        System.out.println("");

        System.out.println("Заменить, в yx, x на X, если это не конец слова : ");


        for (int i = 0; i + 3 < word.length(); i++) {
            if(result[i] == 'x' && result[i + 1] != ' ') {
                result[i] = 'X';
            }
            System.out.print(result[i]);
        }return word;
    }

    public static void findMaxAndMin() {
        System.out.println();
        System.out.println("Задание номер 7");
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        while ( true ) {
            System.out.print("Введте строку: ");
            String text = scanner.nextLine();
            if ( "".equals(text) )
                break;

            Map<Integer, Set<String>> string = new HashMap();
            for ( String s: text.split("\\s+") ) {
                if ( ! string.containsKey(s.length()) )
                    string.put(s.length(), new HashSet());
                string.get(s.length()).add(s);
            }

            Integer[] keys = string.keySet().toArray(new Integer[string.size()]);
            Arrays.sort(keys);

            System.out.print("Слово с минимальной длинной: ");
            for ( String s : string.get(keys[0]) )
                System.out.print(s + " ");
            System.out.print("\nСлово с максимальной длинной: ");
            for ( String s : string.get(keys[keys.length - 1]) )
                System.out.print(s + " ");
            System.out.println();
            break;
        }
    }

    public static void delSpace(){
        System.out.println();
        System.out.println("Задание 8");
        System.out.println("Введите строку: ");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.println(text.replaceAll("\\s+"," "));
    }
}
