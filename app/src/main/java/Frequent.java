import java.util.Arrays;

public class Frequent {
    public static void numOccur(int x[]) {
        Arrays.sort(x);


        int count = 1;


        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] == x[i + 1])
                count++;
            else {
                System.out.println(x[i] + " occured this many times: " + count);
                count = 1;

            }

        }
    }  public static void main (String[]args){
            int test[] = {1, 3, 22, 5, 3, 7, 2, 6};
            int test1[] = {1, 1, 1, 1, 3, 22, 5, 3, 7, 2, 6};
            int test2[] = {1, 3, 22, 5, 3, 7, 2, 66, 6, 6, 6, 6};

            numOccur(test);
            numOccur(test1);
            numOccur(test2);

        }
}