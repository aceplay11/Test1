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
