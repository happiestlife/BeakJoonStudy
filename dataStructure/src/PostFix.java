import java.io.*;
import java.util.Stack;
public class PostFix {
    static double calculate(double operand1, double operand2, char operator){
        double result = 0;
        switch(operator){
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }
        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> postfixStack = new Stack<>();

        double result = 0;
        int operandCount = Integer.parseInt(br.readLine());

        String postfix = br.readLine();

        double operandArray[] = new double[operandCount];
        for(int i = 0; i < operandCount; i++)
            operandArray[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i<postfix.length(); i++){
            char c = postfix.charAt(i);
            if(c == '*' || c == '/' || c == '+' || c == '-'){
                double secondOperand = postfixStack.pop();
                double firstOperand = postfixStack.pop();
                result = calculate(firstOperand, secondOperand, c);
                postfixStack.push(result);
            }else
                postfixStack.push(operandArray[c-'A']);
        }
        System.out.printf("%.2f%n", result);
    }
}
