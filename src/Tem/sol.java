package Tem;

public class sol {

        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int maxArea = 0;

            while (left < right) {
                int width = right - left;
                int minHeight = Math.min(height[left], height[right]);
                int area = width * minHeight;
                maxArea = Math.max(maxArea, area);

                // Move the pointer of the smaller line
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
    }
