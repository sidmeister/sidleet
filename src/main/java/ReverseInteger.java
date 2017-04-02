import java.util.Stack;

/**
 * Created by sidmeister on 4/1/17.
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Note:
 The input is assumed to be a 32-bit signed integer.
 Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
     public int reverse(int x) {

            Stack<Integer> stk = new Stack<>();
            boolean sign = false;
            int remainder = 0;

            if(x < 0) {
                sign = true;
            }
            int carry = Math.abs(x);
            while(!(carry >= 0 && carry < 10))
            {
                remainder =  Math.abs(carry%10);
                carry =  Math.abs(carry/10);
                stk.push(remainder);
            }

            x = carry;
            int i =1;
            while(!stk.empty())
            {
                remainder = stk.pop();
                x = (int) (x + remainder*Math.pow(10,i));
                i++;
            }
            x = x >= Integer.MAX_VALUE ? 0 : x;
            if(sign)
                x = x*(-1);
            return x;

        }

    public static void main(String[] args) {
        ReverseInteger rev = new ReverseInteger();
//        System.out.println(rev.reverse(0));
//        System.out.println(rev.reverse(-1));
//        System.out.println(rev.reverse(1));
        System.out.println(rev.reverse(Integer.MIN_VALUE));
        System.out.println(rev.reverse(Integer.MAX_VALUE));
        //System.out.println(rev.reverse(-123));
    }

}

