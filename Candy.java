import java.util.*;



//There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

// You are giving candies to these children subjected to the following requirements:

// 1. Each child must have at least one candy.
// 2. Children with a higher rating get more candies than their neighbors.

//Return the minimum number of candies you need to have to distribute the candies to the children.

public class Candy {
    public int candyCount(int[] rating) {
        int n = rating.length;
        int[] candies = new int[n];

        // Step 1: Give every child at least one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Step 2: Left to Right Pass
        for (int i = 1; i < n; i++) {
            if (rating[i] > rating[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Right to Left Pass
        for (int i = n - 2; i >= 0; i--) {
            if (rating[i] > rating[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: Total up the candies
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += candies[i];
            System.out.println("Child " + i + " with rating " + rating[i] + " gets " + candies[i] + " candies");
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of children
        System.out.print("Enter the number of children: ");
        int n = scanner.nextInt();

        // Create array to store ratings
        int[] arr = new int[n];
        System.out.println("Enter the ratings of the children:");

        // Read ratings from user
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call method and print result
        Candy obj = new Candy();
        int res = obj.candyCount(arr);
        System.out.println("Total candies needed: " + res);

        scanner.close();
    }
}
