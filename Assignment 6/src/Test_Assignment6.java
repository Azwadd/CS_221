import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Test_Assignment6 {

    public static void main(String[] args) {

        Stack<Character> stackChar = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();

        // adds upper-case letters to stackChar
        IntStream.rangeClosed(65, 90).forEach(i -> stackChar.add((char) i));

        // adds 150 numbers stackInt
        IntStream.rangeClosed(50, 200).forEach(stackInt::add);

        StackOperations stackOperations = new StackOperations();

        out.print("1. Testing toQueue using an empty stack. Values: ");
        stackOperations.toQueue(new Stack<>()).forEach(out::print);

        out.println("\n");

        out.print("2. Testing toQueue using stackChar. Values: ");
        stackOperations.toQueue(stackChar).forEach(out::print);

        out.println("\n");

        out.print("3. Testing reverseStack using stackChar. Values: ");
        stackOperations.reverseStack(stackChar).forEach(out::print);

        out.println("\n");

        out.print("4. Testing sumBetween using stackInt. Sum between 2 and 0: ");
        out.print(stackOperations.sumBetween(stackInt, 2, 0));

        out.println("\n");

        out.print("5. Testing sumBetween using stackInt. Sum between 10 and 20: ");
        out.print(stackOperations.sumBetween(stackInt, 10, 20));

        out.println("\n");

        out.print("6. Testing sumBetween using stackInt. Sum between 1000 and 2000: ");
        out.print(stackOperations.sumBetween(stackInt, 1000, 2000));

        out.println("\n");

        out.print("7. Testing readNumericFromFile. 1st 10 Numeric characters found: ");
        out.println(stackOperations.readNumericFromFile("InputFile.txt")
                .stream()
                .limit(10)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}