import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Temp {
    private List<String> listOfInputs;

    public static void main(String[] args) {

    }

//    public void ConsoleApplication() {
//        this.listOfInputs = new ArrayList<>();

//    }

    public void addStringToMemory(String string) {
        this.listOfInputs.add(string);
    }

    public void printStringsInReverseOrder() {
        List<String> reverseList = new ArrayList<>(listOfInputs);
        Collections.reverse(reverseList);

        for (String string : reverseList) {
            System.out.println(string);
        }
    }

    public void removeLastStringFromMemory() {
        if (!listOfInputs.isEmpty()) {
            listOfInputs.remove(listOfInputs.size() - 1);
        }
    }

    public void inputReader() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("print")) {
                printStringsInReverseOrder();
            } else if (input.equals("revert")) {
                removeLastStringFromMemory();
            } else {
                addStringToMemory(input);
            }
        }
    }
}

