import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    char value;
    TreeNode left, right;

    TreeNode(char item) {
        value = item;
        left = right = null;
    }
}

public class ExpressionTree2
{

    static boolean isOperand(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    TreeNode constructTree(char[] prefix) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = prefix.length - 1; i >= 0; i--) {
            char ch = prefix[i];

            if (isOperand(ch)) {
                stack.push(new TreeNode(ch));
            } else {
                
                TreeNode node = new TreeNode(ch);
                if (!stack.isEmpty()) {
                    node.left = stack.pop();
                }
                    if (!stack.isEmpty()) {
                    node.right = stack.pop(); 
                }
                stack.push(node);
            }
        }
        return stack.peek();
    }
    void nonRecursivePostorder(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            output.push(curr);

            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        while (!output.isEmpty()) {
            TreeNode node = output.pop();
            System.out.print(node.value + " ");
        }
    }

    void deleteTree(TreeNode node) {
        if (node == null) return;

        deleteTree(node.left);
        deleteTree(node.right);

        node.left = null;
        node.right = null;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ExpressionTree2 e=new ExpressionTree2();
        System.out.print("Enter the prefix expression: ");
        String expression = s.nextLine();
        char[] prefixChars = expression.replaceAll("\\s+", "").toCharArray();
        
        TreeNode root = e.constructTree(prefixChars);

        System.out.print("Postorder traversal of the constructed tree: ");
        e.nonRecursivePostorder(root);
        System.out.println();

        e.deleteTree(root);
        System.out.println("Expression tree has been deleted.");
        
}
}

