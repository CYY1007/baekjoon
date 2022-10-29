import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.lang.Math;


public class Main {

    static Integer[] cache;
    static Integer[] S;

    static int LIS(int loc){
        int result = 1;
        if (cache[loc] != null) return cache[loc];
        else{
            cache[loc] = result;
            for (int i = loc + 1; i< S.length; i++){
                if (S[loc] < S[i]) {
                    result = Math.max(result, LIS(i) + 1);
                    cache[loc] = result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());

        S = new Integer[N];
        cache = new Integer[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < N; i++)
            S[i] = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++)
            LIS(i);

        Arrays.sort(cache);
        System.out.println(cache[N - 1]);
    }
}
