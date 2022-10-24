import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.Math;
import java.util.List;

public class Main {
    static List<Integer> unableArr = new ArrayList<>();
    public static int isNotBroken(int target){
        int count = 0;
        if (target == 0)
            count = unableArr.contains(target) ? 0 : 1;
        while (target > 0){
            if (unableArr.contains(target % 10))
                return 0;
            else{
                count++;
                target /= 10;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        int unablenums = scan.nextInt();

        for (int i =0; i < unablenums; i++)
            unableArr.add(scan.nextInt());
        int worstCase = Math.abs(target - 100);

        int min = worstCase;
        for (int i = 0;i < 1000000; i++){
            int count = isNotBroken(i);
            if (count > 0)
                min = Math.min(min,Math.abs(i - target) + count);
        }
        System.out.println(min);
    }
}