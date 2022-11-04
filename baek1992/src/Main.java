import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] matrix;

    static void Tree(int startRow, int startCol, int N){
        if(N == 1){
            for(int i = startRow; i < startRow + N; i++)
                for(int j = startCol; j < startCol + N; j++)
                    System.out.print(matrix[i][j]);
        }
        else{
            int base = matrix[startRow][startCol];
            boolean recurse = false;
            for(int i = startRow; i < startRow + N; i++) {
                if(!recurse) {
                    for (int j = startCol; j < startCol + N; j++) {
                        if(matrix[i][j] != base){
                            recurse = true;
                            break;
                        }
                    }
                }
                else
                    break;
            }
            if(!recurse)
                System.out.print(base);
            else{
                System.out.print('(');
                int rowMid = (startRow + startRow + N -1) / 2;
                int colMid = (startCol + startCol + N-1) / 2;
                Tree(startRow, startCol, N/2);
                Tree(startRow, colMid + 1, N/2);
                Tree(rowMid + 1, startCol, N/2);
                Tree(rowMid + 1, colMid + 1, N/2);
                System.out.print(')');
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());

        matrix = new int[N][N];

        for(int i = 0;i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String temp = stringTokenizer.nextToken();
            for(int j = 0; j < N; j++)
                matrix[i][j] = temp.charAt(j) - '0';
        }

        Tree(0,0,N);

    }
}
