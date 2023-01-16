package problem;

import java.util.List;

public class _385_Deserialize {
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

/**
 * 输入：s = "[123,[456,[789]]]",
 * 输出：[123,[456,[789]]]
 * 解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 *     i.  一个 integer 包含值 456
 *     ii. 一个包含一个元素的嵌套列表
 *          a. 一个  integer 包含值 789
 *          "[123,456,[788,799,833],[[]],10,[]]"
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            if (s.isBlank()) {
                return null;
            }
            return new NestedInteger(Integer.parseInt(s));
        } else {
            int last = 1;
            int brake = 0;
            NestedInteger nestedInteger = new NestedInteger();
            for (int i = 1; i < s.length() - 1; i++) {
                if (brake == 0 && s.charAt(i) == ',') {
                    nestedInteger.add(deserialize(s.substring(last, i)));
                    last = i + 1;
                }
                if (s.charAt(i) == '[') {
                    brake++;
                }
                if (s.charAt(i) == ']') {
                    brake--;
                }
            }
            String substring = s.substring(last, s.length() - 1);
            if (!substring.isBlank()) {
                nestedInteger.add(deserialize(substring));
            }
            return nestedInteger;
        }
    }

    public static void main(String[] args) {
        new Solution().deserialize("[123,[456,[789]]]");
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {

    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}
