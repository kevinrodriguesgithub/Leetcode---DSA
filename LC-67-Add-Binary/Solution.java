class Solution {
    public String addBinary(String a, String b) {

    // Better approach
        int n1 = a.length() -1;
        int n2 = b.length() -1;

        StringBuilder ans = new StringBuilder();
        int sum = 0;
        int carry = 0;

        while(n1 >= 0 || n2 >= 0){
            sum = carry;

            // If 'a' has digits left
            if(n1 >= 0){
                sum += (a.charAt(n1) - '0');
                n1--;
            }

            // If 'b' has digits left
            if(n2 >= 0){
                sum += (b.charAt(n2) - '0');
                n2--;
            }

            if(sum % 2 == 0){
                ans.append("0");
            }
            else{
                ans.append("1");
            }

            // Update carry
            if(sum > 1){     // means sum is 2 or 3
                carry = 1;
            }
            else{
                carry = 0;
            }
        } 
        // If carry remains after both strings are finished
        if(carry == 1){
            ans.append("1");
        }
        return ans.reverse().toString();

    // Another method - But Used too many if-else   
    /*    int n1 = a.length();
        int n2 = b.length();

        int end1 = n1 -1;
        int end2 = n2 -1;
        
        StringBuilder ans = new StringBuilder();
        boolean carryOne = false;

        while(end1 >= 0 || end2 >= 0){
            if(end1 < 0){
                if(b.charAt(end2) == '1' && carryOne){
                    ans.append("0");
                    carryOne = true;
                }
                else if(b.charAt(end2) == '1' && !carryOne){
                    ans.append("1");
                    carryOne = false;
                }
                else if(b.charAt(end2) == '0' && carryOne){
                    ans.append("1");
                    carryOne = false;
                }
                else if(b.charAt(end2) == '0' && !carryOne){
                    ans.append("0");
                    carryOne = false;
                }
            }
            else if(end2 < 0){
                if(a.charAt(end1) == '1' && carryOne){
                    ans.append("0");
                    carryOne = true;
                }
                else if(a.charAt(end1) == '1' && !carryOne){
                    ans.append("1");
                    carryOne = false;
                }
                else if(a.charAt(end1) == '0' && carryOne){
                    ans.append("1");
                    carryOne = false;
                }
                else if(a.charAt(end1) == '0' && !carryOne){
                    ans.append("0");
                    carryOne = false;
                }
            }
            else if(a.charAt(end1) == '1' && b.charAt(end2) == '1' && carryOne){
                ans.append("1");
                carryOne = true;
            }
            else if(a.charAt(end1) == '1' && b.charAt(end2) == '1' && !carryOne){
                ans.append("0");
                carryOne = true;
            }
            else if(a.charAt(end1) == '1' && b.charAt(end2) == '0' && carryOne){
                ans.append("0");
                carryOne = true;
            }
            else if(a.charAt(end1) == '1' && b.charAt(end2) == '0' && !carryOne){
                ans.append("1");
                carryOne = false;
            }
            else if(a.charAt(end1) == '0' && b.charAt(end2) == '1' && carryOne){
                ans.append("0");
                carryOne = true;
            }
            else if(a.charAt(end1) == '0' && b.charAt(end2) == '1' && !carryOne){
                ans.append("1");
                carryOne = false;
            }
            else if(a.charAt(end1) == '0' && b.charAt(end2) == '0' && carryOne){
                ans.append("1");
                carryOne = false;
            }
            else if(a.charAt(end1) == '0' && b.charAt(end2) == '0' && !carryOne){
                ans.append("0");
                carryOne = false;
            }
            end1--;
            end2--;
        }
        if(carryOne){       // Eg: 4 digits each of a and b done, but carryOne is remaining
            ans.append("1");
        }
        return ans.reverse().toString();
            */
    }
}

/* Explanation - Method 1:
1. Initialize end pointer n1 and n2 for both string a and string b respectively
2. Continue the while loop until both of them are < 0, it means no digits left in either string
3. In the while loop, Store the current carry in sum
4. if String 'a' has any characters left, add current char to sum
5. If String 'b' has any characters left, add current char to sum
6. If sum is even (would be either 0 or 2), then append "0" to the answer
   If sum is even (would be either 1 or 3), then append "1" to the answer
7. If sum > 1 (would be either 2 or 3), then set carry to 1, which will used for next iteration
else, set carry to 0
8. After both strings are processed, check if any carry is left, if it's still there (1), append it to the answer
9. Finally reverse the answer, as we were adding and processing from the end.
*/