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
public class atoi {
    public int atoi(String x) {
        int remainder = 0;
        int i =0;
        for(;i<x.length() && x.charAt(i) == ' ';i++);
        if(x.length() == i)
            return 0;
        boolean plus = true;
        int len = x.length();
        if(x.charAt(i) == '-') {
            plus = false;
            i++;
        }
        else if(x.charAt(i) == '+') i++;
        int num_dig =0,y =0 ;

        while(i < x.length() && isDig(x.charAt(i)))
        {
            num_dig++;
            remainder = remainder * 10;
            y = (int) x.charAt(i) - 48;
            remainder = remainder + y;
            if (remainder > Integer.MAX_VALUE) break;
            i++;
        }

        if (plus) {
            if(num_dig > 10) return Integer.MAX_VALUE;
            if (remainder > Integer.MAX_VALUE  || remainder < 0 ) return Integer.MAX_VALUE;
            return remainder;
        } else {
            if(num_dig > 10) return Integer.MIN_VALUE;
            if (remainder <0) return Integer.MIN_VALUE;
            return -remainder;
        }
    }

    public boolean isDig(char c) {
        return (c >= '0') && (c <= '9');
    }

    public static void main(String[] args) {
        atoi rev = new atoi();
        System.out.println(rev.atoi("0"));
        System.out.println(rev.atoi("1"));
        System.out.println(rev.atoi("123"));
        System.out.println(rev.atoi("-123"));
        System.out.println(rev.atoi(""));
        System.out.println(rev.atoi(" "));
        System.out.println(rev.atoi("A"));
        System.out.println(rev.atoi("+1"));
        System.out.println(rev.atoi("+-2"));
        System.out.println(rev.atoi("    010"));
        System.out.println(rev.atoi("  -0012a42"));
        System.out.println(rev.atoi("2147483648"));
        System.out.println(rev.atoi("-2147483649"));
        System.out.println(rev.atoi("    10522545459"));
        System.out.println(rev.atoi("-12147483649"));

    }

}

