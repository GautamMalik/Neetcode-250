package ArrayString.BinarySearch;

// ques: https://neetcode.io/problems/guess-number-higher-or-lower/question?list=neetcode250

public class GuessNumber {

    // their method
    private int guess(int num){
        if(10 == num)
            return 0;
        else if (10 < num) {
            return 1;
        } else
            return -1;
    }

    public int guessNumber(int n) {
        int low =0, high = n;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) == 1)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}
