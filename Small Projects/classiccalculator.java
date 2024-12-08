/*
 * This program is a classic calculator that can evaluate arithmetic expressions.
 * It uses the shunting-yard algorithm to convert infix expressions to postfix expressions
 * and then evaluates the postfix expression.
 * The program supports the following operators: +, -, *, /
 * The program also supports parentheses.
 * Java 12 is required to run this program.
 */



import java.util.Scanner;
import java.util.Stack;

public class classiccalculator {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the expression: ");
        String expression = sc.nextLine();
        System.out.printf("Result: %.2f%n", calculate(expression));
    }

    static double calculate(String expression) {
        String postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();
        String [] tokens = expression.split(" ");
        for (String token: tokens) {
            char c = token.charAt(0);
            if (Character.isDigit(c)) {
                stack.push(Double.valueOf(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                switch (c) {
                    case '+' -> stack.push(operand1 + operand2);
                    case '-' -> stack.push(operand1 - operand2);
                    case '*' -> stack.push(operand1 * operand2);
                    case '/' -> stack.push(operand1 / operand2);
                }
            }
        }
        return stack.pop();
    }

    static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();
        String [] tokens = expression.split(" ");
        for (String token: tokens) {
            char c = token.charAt(0);

            if (Character.isDigit(c)) {
                result.append(token).append(" ");
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    result.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    result.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            result.append(operatorStack.pop());
        }

        return result.toString();
    }

    static int precedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }
}
