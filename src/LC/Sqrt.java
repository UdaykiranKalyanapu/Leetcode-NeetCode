package LC;
class Sqrt {
    public static void main (String [] args){
        int x = 800;
        System.out.println(mySqrt(x));

    }


    public static int mySqrt(int x) {
        if (x < 2) {
            return x;  // sqrt(0)=0, sqrt(1)=1
        }

        int left = 1, right = x / 2, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; // prevents overflow
            long sq = (long) mid * mid; // use long to avoid overflow

            if (sq == x) {
                return mid; // perfect square
            } else if (sq < x) {
                ans = mid; // store best candidate
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
