package problenofthedays;

import java.util.Stack;

public class RemoveBalls {

    public static void main(String[] args) {
        int[] color = {2, 2, 5};
        int[] radius = {3, 3, 5};

        System.out.println(findLength(color, radius));
    }

    static int findLength(int[] color, int[] radius) {
        int n = color.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!stack.empty() && color[i] == color[stack.peek()] && radius[i] == radius[stack.peek()])
                stack.pop();
            else
                stack.push(i);
        }

        return stack.size();
    }
}
