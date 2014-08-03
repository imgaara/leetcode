import java.util.Stack;

/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int idx = 0; idx <= height.length;) {
            int cur = (idx == height.length ? 0 : height[idx]);
            if (stack.isEmpty() || cur > height[stack.peek()]) {
                stack.push(idx++);
            } else {
                int lastIdx = stack.pop();
                int toIdx = idx - 1;
                int fromIdx = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height[lastIdx] * (toIdx - fromIdx));
            }
        }

        return maxArea;
    }
}
