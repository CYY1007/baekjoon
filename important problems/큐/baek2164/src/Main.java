import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(cin.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            queue.offer(i);

        while (queue.size() > 1){
            Integer getter = null;
            queue.poll();
            getter = queue.poll();
            queue.offer(getter);
        }

        System.out.println(queue.poll());
    }
}
