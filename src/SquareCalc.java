import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SquareCalc {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File("input1.txt"));

            while(sc.hasNext()){
                list.add(sc.nextInt());
            }
            sc.close();
        }catch(FileNotFoundException e){e.printStackTrace();}
        if(list.size()%3!=0){
            System.out.println("Last room parameters are not fully entered");
        }

        SquareCalc(list);

    }

    private static void SquareCalc(ArrayList<Integer> list) {
        double SquareFloor;
        double SquareWall;
        double SquareWalll;
        double SquareRoom;
        double TransferRatio=0.092903; //Conversion factor from square feet to square meters
        double SumSquare=0;
        int k=1;
        for (int i=0; i<list.size()-2; i+=3 ){
            SquareFloor=(list.get(i))*list.get(i+1);
            SquareWall=list.get(i+2)*list.get(i+1);
            SquareWalll=list.get(i)*list.get(i+2);
            SquareRoom= 2*(SquareWalll+SquareFloor+SquareWall);
            SumSquare+=TransferRatio*(MinSquare(SquareFloor,SquareWall,SquareWalll)+SquareRoom);
            System.out.println( "Wallpaper stock for room  "+ k +" - "+MinSquare(SquareFloor,SquareWall,SquareWalll)*TransferRatio);
            System.out.println("Square room "+ k + " - "+SquareRoom*TransferRatio);
            System.out.println("All wallpaper for  room  "+k+" - " + TransferRatio*(MinSquare(SquareFloor,SquareWall,SquareWalll)+SquareRoom));
            System.out.println("-----------------------------------------");

            k++;



        }
        System.out.println( "Company should order for all rooms " +SumSquare +" square meters");

    }
    private static double MinSquare(double x, double y, double z){
        double [] array = {x, y, z};
        Arrays.sort(array);

        double value = array[0];
        return value;
    }



}