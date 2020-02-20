import java.util.ArrayList;
import java.util.List;

public class Pizza {

    int pizzaTypes = 0;
    List<Integer> pizzaNumbers = new ArrayList<>();


    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    public void knapSack(int W, List<Integer> wt, List<Integer> val, int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt.get(i - 1) <= w)
                    K[i][w] = max(val.get(i - 1) + K[i - 1][w - wt.get(i - 1)], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        System.out.println(K[n][W]);

        while (n!=0){
            if (K[n][W] == K[n-1][W]){
                pizzaTypes++;
                pizzaNumbers.add(n);
                n--;
            }
            W--;
        }

        return;
    }



    public void MOARPIZZA(int M, int N, List<Integer> Slices){

        knapSack(M, Slices, Slices, N);

        return;
    }
}