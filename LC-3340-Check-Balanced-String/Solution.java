class Solution {
    public boolean isBalanced(String num) {
        
        int n = num.length();

        int sumEven = 0, sumOdd = 0;

        for(int i=0;i<n;i++){
            char ch = num.charAt(i);
            int digit = (int)(ch - '0');
            if(i%2 == 0){
                sumEven += digit;
            }
            else{
                sumOdd += digit;
            }
        }
        if(sumEven == sumOdd){
            return true;
        }
        else{
            return false;
        }
    }
}
/* Explanation
1. Calculate the length of the string
2. Declare 2 variables - sumEven and sumOdd, which will store the sum of digits at even place and sum of digits at odd place respectively
3. After the iteration, if both the sum are equal, return true; else return false
*/