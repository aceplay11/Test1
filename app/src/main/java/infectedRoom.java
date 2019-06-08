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
