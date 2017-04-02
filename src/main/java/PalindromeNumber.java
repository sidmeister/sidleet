/**
 * Created by sidmeister on 4/1/17.
 * Determine whether an integer is a palindrome. Do this without extra space
 */



public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) {  //negative numbers cannot be palindrome
            return false;
        }
        if(x >=0 && x < 10)
            return true;
        int num = x;
        int sum =0, remainder =0;
        while(num > 0) {
            remainder = num % 10;
            sum = (sum*10) + remainder;
            num = num /10;
        }
        if(sum >= Integer.MAX_VALUE) return false;
        return x==sum;

    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(10));
        System.out.println(p.isPalindrome(-1));
        System.out.println(p.isPalindrome(-2147447412));
        System.out.println(p.isPalindrome(Integer.MIN_VALUE));
        System.out.println(p.isPalindrome(Integer.MAX_VALUE));
    }

}
