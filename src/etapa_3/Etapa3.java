package etapa_3;

import java.io.IOException;
import java.util.Stack;

public class Etapa3 {

    public static void main(String[] args) throws IOException {
        // Cria uma pilha de caracteres
        Stack<Character> stack = new Stack<>();
        stack.push('(');
        stack.push('(');
        stack.push('A');
        stack.push('+');
        stack.push('B');
        stack.push(')');

        // Verifica se os parênteses estão balanceados
        boolean estaCorreto = checkBrackets(stack);
        System.out.println("Os parênteses estão balanceados? " + estaCorreto);
    }

    public static boolean checkBrackets(Stack<Character> stack) {
        Stack<Character> auxiliar = new Stack<>();
    
        // Verifica cada caractere na pilha
        while (!stack.isEmpty()) {
            Character atual = stack.pop();
            System.out.println("Atual: " + atual + ", Stack: " + stack + ", Auxiliar: " + auxiliar);
            if (atual == '(') {
                
                auxiliar.push(atual);
            } else if (atual == ')') {
                
                if (auxiliar.isEmpty()) {
                    
                    return false;
                } else {
                    
                    auxiliar.pop();
                }
            }
        }
        
        return auxiliar.isEmpty();
    }
}






