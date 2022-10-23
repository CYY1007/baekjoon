import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(cin.readLine());

        Integer N = Integer.parseInt(st.nextToken());
        Integer M = Integer.parseInt(st.nextToken());
        Queue<Integer> myqueue = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            myqueue.offer(i);

        int count = 1;
        System.out.print('<');
        while(!myqueue.isEmpty()){
            Integer getter = myqueue.poll();
            if (count != M) {
                myqueue.offer(getter);
                count++;
            }
            else if (count == M)
            {
                if (myqueue.isEmpty())
                    System.out.print(getter + ">");
                else
                    System.out.print(getter + ", ");
                count = 1;
            }
        }
    }
}
