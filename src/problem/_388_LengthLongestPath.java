package problem;

import java.util.Arrays;

public class _388_LengthLongestPath {
    public int lengthLongestPath(String input) {
        int[] height = new int[100001];
        String[] strings = input.split("\n");
        Arrays.fill(height, 0);
        int length = 0;
        for (String str : strings) {
            int ix = str.lastIndexOf("\t") + 2;
            if (str.contains(".")) {
                length = Math.max(length, height[ix - 1] + str.replaceAll("\t", "").length());
            } else {
                height[ix] = height[ix - 1] + str.replaceAll("\t", "").length() + 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        new _388_LengthLongestPath().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
    }
}
