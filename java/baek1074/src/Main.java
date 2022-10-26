import java.util.Scanner;
import java.lang.Math;

public class Main {
    static int row,col;
    static int count = 0;
    static boolean found = false;
    public static void Z(int startRow, int startCol, int n){
        if (found == true)
            return;
        else{
            if (n == 1){
                if (startRow + 1 < row || startCol + 1 < col){
                    count += 4;
                    return;
                }
                else{
                    for (int i = startRow; i <= startRow +1;i++){
                        for (int j = startCol; j <= startCol+1;j++){
                            if (i == row && j == col){
                                found = true;
                                return;
                            }
                            else
                                count++;
                        }
                    }
                }
            }
            else{
                if((startRow + (int)Math.pow(2,n) -1) < row || (startCol + (int)Math.pow(2,n) -1) < col){
                    count += Math.pow(4,n);
                    return;
                }
                else{
                    int midRow = (startRow + startRow + (int) Math.pow(2, n) - 1) / 2;
                    int midCol = (startCol + startCol + (int) Math.pow(2, n) - 1) / 2;
                    Z(startRow, startCol, n - 1);
                    Z(startRow, midCol + 1, n - 1);
                    Z(midRow + 1, startCol, n - 1);
                    Z(midRow + 1, midCol + 1, n - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        row = scanner.nextInt();
        col = scanner.nextInt();

        Z(0,0,N);
        System.out.println(count);
    }
}
