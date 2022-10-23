import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(cin.readLine());

        Integer N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(cin.readLine(), " ");
        for (int i =0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        st = new StringTokenizer(cin.readLine());

        Integer M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(cin.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch2(arr, target) - binarySearch1(arr, target)).append(' ');
        }
        System.out.println(sb);
    }
    public  static int binarySearch1(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = (left + right) / 2;
            if (target <= arr[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static int binarySearch2(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        while (left < right){
            int mid = (left + right) / 2;
            if (target >= arr[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    // 그냥 이분 탐색해서 인덱스 지우는 방법은 느린것 같고 발견 된 원소 중 가장 끝 값 - 처음 값 이렇게 해야할듯

//    public static int binarySearch(ArrayList<Integer> arr, int target){
//        int left = 0;
//        int right = arr.size() - 1;
//        int result = -1;
//        while(left <= right){
//            int mid = (left + right) / 2;
//            if (arr.get(mid) < target)
//                left = mid + 1;
//            else if (arr.get(mid) > target)
//                right = mid - 1;
//            else
//            {
//                result = mid;
//                break;
//            }
//        }
//        return result;
//    }
}
