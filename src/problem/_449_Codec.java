package problem;

import util.TreeNode;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _449_Codec {
    // Encodes a tree to a single string.
    String sep = ",";
    String nullString = "#";

    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isDone = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    sb.append(nullString);
                    queue.add(null);
                    queue.add(null);
                } else {
                    isDone = false;
                    sb.append(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                sb.append(sep);
            }
            if(isDone) {
                break;
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] elements = data.split(sep);
        TreeNode[] nodes = new TreeNode[elements.length];
        int i = 0;
        while (2 * i + 2 < elements.length) {
            if (!Objects.equals(elements[i], nullString)) {
                nodes[i] = new TreeNode(Integer.parseInt(elements[i]));
            }
            i++;
        }
        i = 0;
        while (2 * i + 2 < elements.length) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[2 * i + 1];
                nodes[i].right = nodes[2 * i + 2];
            }
            i++;
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        new _449_Codec().deserialize("2,1,3,#,#,#,#");
    }
}
