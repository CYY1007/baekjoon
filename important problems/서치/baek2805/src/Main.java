import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int max = tree[N - 1];
        int min = 0;
        int ans = -1;

        while(min < max) {
            int mid = (min + max) / 2;
            Long sum = 0L;
            for (int i : tree) {
                if (i - mid > 0)
                    sum += i - mid;
            }

            if (sum < M)
                max = mid;
            else
                min = mid + 1;
        }

        System.out.println(min - 1);
    }
}
