# Test1
1. Create a singleton class and make it thread safe.
   
    public class Singleton
    {
        // private makes access by only by getInstance() method
        private static Singleton instance;

        private Singleton() {
        }

        //synchronized method to control simultaneous access
        synchronized public static Singleton getInstance()
        {
            if (instance == null) {
                // if instance is null, create new singleton
                instance = new Singleton();
            }
            return instance;
        }
    }
2. Create a function to find the most occurrence of an integer value given an integer array.
Question modified to print the occurence of each number in the array

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


![Screen Shot 2019-06-08 at 12 04 43 AM](https://user-images.githubusercontent.com/51377336/59141794-4c930200-8981-11e9-868d-2f77023433ed.png)


3. Simple Java Program to check or find if a number is Armstrong number or not. An Armstrong number of three digit is a number whose sum of cubes of its digit is equal to its number. 
For example 153 is an Armstrong number of 3 digit because 1^3+5^3+3^3 or 1+125+27=153

public class Armstrong {

    public static void checkArmstrong(int x){
        int remind;
        int org = x;
        int number = x;
        int res = 0;

        //loop to get reminder and math
        while(org != 0){
            remind = org % 10;
            res = res + remind * remind * remind;
            org = org / 10;
        }
        if(res == number)
            System.out.println(number + " is an Armstrong");

        else
            System.out.println(number + " is not an Armstrong");
    }

    public static void main(String[] args) {
        int c = 153;
        int d = 342;
        int e = 405;
        int f = 371;

        checkArmstrong(c);
        checkArmstrong(d);
        checkArmstrong(e);
        checkArmstrong(f);

    }
}


![Screen Shot 2019-06-08 at 12 03 51 AM](https://user-images.githubusercontent.com/51377336/59141793-4c930200-8981-11e9-86f5-61024d4e1c61.png)


4. Complete the infected Room code challenge
public class infectedRoom {

    public final boolean isInfected;
    public boolean visited = false;
    infectedRoom (boolean infected) {

        isInfected = infected;
    }
}

class Outbreak{
    public static boolean isOutbreak(infectedRoom [][] floor){
        int numInfected = 0;

        // loop through multi-dimension array
        for (int i = 0; i < floor.length ; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                //temp variable of checked infected rooms. If temp is more set infected.
                int temp = checkedRoom(floor, i, j, 0);
                if (temp > numInfected)
                    numInfected = temp;
            }
        }
        System.out.println("The number of connected infected rooms is " + numInfected);
        return
                numInfected > 5;
    }

    public static int checkedRoom(infectedRoom[][]floor,int x, int y,int num) {
        int result = num;

        if (x < 0 || x > floor.length) return 0;
        if (y < 0 || y > floor[0].length) return 0;

        if ((floor[x][y]).visited == true) return 0;
        if ((floor[x][y]).isInfected == false) return 0;

        floor[x][y].visited =true;

        result = result + 1;

        return result + checkedRoom(floor,x+1, y,0) + checkedRoom(floor,x-1, y,0)
                + checkedRoom(floor,x, y+1,0) + checkedRoom(floor,x, y-1,0);

    }

    public static void main(String[] args) {
        infectedRoom[][] verticalTrue = new infectedRoom[][] {
                {new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) },
                {new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) },
                {new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) },
                {new infectedRoom(false), new infectedRoom(true), new infectedRoom(false), new infectedRoom(true), new infectedRoom(true), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) },
                {new infectedRoom(false), new infectedRoom(true), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) },
                {new infectedRoom(false), new infectedRoom(true), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) },
                {new infectedRoom(false), new infectedRoom(true), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) },
                {new infectedRoom(false), new infectedRoom(true), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) },
                {new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) },
                {new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false), new infectedRoom(false) }
        };

        isOutbreak(verticalTrue);

        
    }
}


![Screen Shot 2019-06-08 at 12 00 45 AM](https://user-images.githubusercontent.com/51377336/59141792-4c930200-8981-11e9-9734-45e4ff25b3a2.png)
