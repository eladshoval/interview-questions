package StackQueue;

import java.util.List;
import java.util.Stack;

public class EvaluateExpression {

    private static List<String> operands = List.of("+", "-", "*", "/");

    private Stack<String> expressions = new Stack<String>();

    public int eval(String[] arr) {
        return evalLoop(arr, arr.length - 1);
    }

    private boolean isNumber(String val) {
        return operands.contains(val);
    }

    private int evalLoop(String[] arr, int index) {

        String curr = arr[index];
        int result = 0;
        if (!isNumber(curr)) {
            expressions.push(curr);
            return evalLoop(arr, index - 1);
        }

        int num = Integer.parseInt(curr);
        if (isNumber(arr[index + 1])) {
                return num;
        }

        while (!expressions.empty()) {
            String operand = expressions.pop();
            if (operand.equals("*")) {
                result = (num) * (evalLoop(arr, index - 1));
            } else if (operand.equals("+")) {
                result = (num) + (evalLoop(arr, index - 1));
            } else if (operand.equals("-")) {
                result = (num) - (evalLoop(arr, index - 1));
            } else if (operand.equals("/")) {
                result = (num) / (evalLoop(arr, index - 1));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        EvaluateExpression ee = new EvaluateExpression();

        String[] arr = new String[]{"4", "13", "5", "/", "+"};

        System.out.println("EvaluateExpression - " + ee.eval(arr));
    }
}
