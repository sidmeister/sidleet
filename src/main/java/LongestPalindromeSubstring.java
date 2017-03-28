/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb
*/

public class LongestPalindromeSubstring
{
    /*
    The simple approach is to check each substring whether the substring is a palindrome or not. We can run three loops, the outer two loops pick all substrings one by one by fixing the corner characters, the inner loop checks whether the picked substring is palindrome or not.

    Time complexity: O ( n^3 )
    Auxiliary complexity: O ( 1)

    */
    public String longestPalindromebf(String s) {
        //BruteForce Complexity is O(n3)
            //Variable to keep max length of palindrome so far
            int lengthSofar = 0;
            //Variable to keep longest palindrome so far
            String resultstring = "";
            //Loop to get substring which starts with i char
            for (int i = 0; i < s.length();i++)
            {
                String substring = "" + s.charAt(i);
                for (int j = i+1; j < s.length();j++)
                {
                    substring += s.charAt(j);
                    //Check is the substring is palndrome or not
                    if(IsPalindrome(substring))
                    {
                        if (lengthSofar < substring.length())
                        {
                            lengthSofar = substring.length();
                            resultstring = substring;
                        }
                    }
                }
            }
            return resultstring;
        }

        //Method to check whether string is palindrome or not
        public boolean IsPalindrome(String input) {
            if (input == null)
                return false;

            if (input.length() == 1)
                return true;

            int halflen = input.length() / 2;
            int len = input.length() - 1;

            //Basically it compares the first char and last char until it reached the halflength of the string
            for (int i = 0; i < halflen; i++) {
                if (input.charAt(i) != input.charAt(len)) {
                    return false;
                }
                len--;
            }
            return true;

        }

        /*
        The time complexity can be reduced by storing results of subproblems.
        The idea is similar to this post. We maintain a boolean table[n][n] that is filled in bottom up manner.
        The value of table[i][j] is true, if the substring is palindrome, otherwise false.
        To calculate table[i][j], we first check the value of table[i+1][j-1],
        if the value is true and str[i] is same as str[j],
        then we make table[i][j] true. Otherwise, the value of table[i][j] is made false.
         */
    public String longestPalindromedp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0,maxlen = Integer.MIN_VALUE;
        int n = s.length();
        //base case for bottom up
        for(int row =0; row<n;row++)
            dp[row][row] = true;
        //base for case for 2 char long string
        for(int row =0; row<n -1;row++)
        {
            if(s.charAt(row) == s.charAt(row+1)) {
                dp[row][row + 1] = true;
                start = row;
                maxlen = 2;
            }
        }
        int col;
        //case for length > 3
        for(int len =3; len<=n;len++)
        {
            for(int row=0;row < n- len + 1;row++)
            {
                col = row + len -1;
                if (s.charAt(row) == s.charAt(col) && dp[row+1][col-1] == true)
                {
                    dp[row][col] = true;
                    start = row;
                    maxlen = len;
                }
            }
        }
        return maxlen == Integer.MIN_VALUE ? s.substring(start,start+1) : s.substring(start,start+maxlen);
    }

    public static void main (String[] args)
    {
        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        LongestPalindromeSubstring l = new LongestPalindromeSubstring();
        //System.out.println(l.longestPalindromebf(input));
        System.out.println(l.longestPalindromedp(input));

    }
}