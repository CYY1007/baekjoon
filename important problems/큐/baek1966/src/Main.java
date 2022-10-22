import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int time = Integer.parseInt(st.nextToken());

        for (int i =0; i < time; i++){
            st = new StringTokenizer(br.readLine()," ");
            int nums = Integer.parseInt(st.nextToken());
            int where = Integer.parseInt(st.nextToken());

            Queue<Integer> priority = new LinkedList<>();
            Queue<Integer> real = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < nums; j++){
                int num = Integer.parseInt(st.nextToken());
                priority.offer(num);
                real.offer(j);
            }

            int count = 1;
            while(!priority.isEmpty()){
                int maxPriority = Collections.max(priority);
                int getPriority = priority.poll();
                int current = real.poll();
                if (getPriority == maxPriority) {
                    if (current == where){
                        System.out.println(count);
                        break;
                    }
                    else
                        count++;
                }
                else{
                    priority.offer(getPriority);
                    real.offer(current);
                }
            }
        }
    }
}
