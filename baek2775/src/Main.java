import java.util.*;

public class Main {
    public static int calc(int floor, int room) {
        if (floor == 0)
            return room;
        else {
            int sum = 0;
            for (int i = 1; i <= room; i++)
                sum += calc(floor-1, i);
            return sum;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int time = cin.nextInt();
        for (int i = 0; i < time; i++){
            int floor = cin.nextInt();
            int room = cin.nextInt();
            int people = calc(floor, room);
            System.out.println(people);
        }
    }
}

