import java.util.HashMap;
import java.util.Map;

public class MissingNumber {
    public static void main (String[] args){
        System.out.println("Missing Number");
        int[] arr = {1,3,5,6};
        int n = 9;
        Map<Integer,Boolean> numToHasMap = new HashMap<>();
        for(int i=1;i<=n;i++){
            numToHasMap.put(i,false);
        }
        for(int val : arr){
            numToHasMap.put(val,true);
        }
        for(int i=1;i<=n;i++){
            if(!numToHasMap.get(i)){
                System.out.print(i+", ");
            }
        }

    }
}
