import java.util.*;

public class Test2 {

    public static void main(String args[]){
        int[] a = new int[]{11,1,5,5,6};
        List<Integer>a2 = new ArrayList<>();
        a2.add(11);
        a2.add(1);
        a2.add(5);
        a2.add(5);
        a2.add(6);
        System.out.println(solution(a,28));
        System.out.println(solution2(a2,7));

    }
    /*
    Jupiter money
    {} {11} {11,1} {11,1,5} {11,1,5,5}
    0  t   t
    1  f   f
    2  f   f
    3  f   f
    4  f   f
    5  f

     */
    static boolean solution(int[] arr, int sum){
        int n = arr.length;
        if(sum%2!=0){
            return false;
        }
        int target= sum/2;
        boolean[][] dp = new boolean [target+1][n+1];

        for(int i =0; i < target+1 ; i++){
            for(int j =0 ; j<n+1;j++){
                if(i==0){
                    dp[0][j]=true;
                    continue;
                }
                if(j==0){
                    dp[i][0]= false;
                    continue;
                }


                if(arr[j-1] > i){
                    dp[i][j]= dp[i][j-1];
                }
                else{
                    dp[i][j] =  dp[i][j-1] || dp[i-arr[j-1]][j-1];
                }
            }
        }
        return dp[target][n];
    }
    static boolean solution2(List<Integer> list, int sum){
        Set<Integer> reverse = new HashSet<>();
        for(int num : list){
            int rev= sum - num;
            if(reverse.contains(rev)){
                return true;
            }
            reverse.add(rev);
        }
        return false;
    }
}
