package String;

public class Palindrome {
    public static void main (String[] args){
        System.out.println("Palindrome");
        String str = "maam";
        int len = str.length();
        int left=0,right=len-1;
        boolean res = true;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                res = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println("Result "+res);
    }
}
