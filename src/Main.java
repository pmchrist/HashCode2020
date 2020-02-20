import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        FileReader inputFile = null;
        FileWriter outputFile = null;

        try {
            //Setting Input
            inputFile = new FileReader("b_small.in");
            outputFile = new FileWriter("answer.out");

            Scanner scanner = new Scanner(inputFile);

            //Setting Variables
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            List<Integer> pizzaSlices = new ArrayList<Integer>();
            while (scanner.hasNextInt())
                pizzaSlices.add(scanner.nextInt());

            //Calling Method
            Pizza pizza = new Pizza();
            pizza.MOARPIZZA(M,N,pizzaSlices);

            //Outputting
            outputFile.write(Integer.toString(pizza.pizzaTypes));
            outputFile.write("\n");
            for (int i=0; i<pizza.pizzaNumbers.size(); i++){
                outputFile.write(Integer.toString(pizza.pizzaNumbers.get(i)));
                outputFile.write(" ");
            }
            //Clearing
        }finally {
            if (inputFile != null) {
                inputFile.close();
            }
            if (outputFile != null) {
                outputFile.close();
            }
        }
    }
}
