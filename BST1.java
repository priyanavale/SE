import java.util.*;
class tree
{
    int data;
    tree left,right;
    tree(int data)
    {
        this.data=data;
        left=right=null;
    }
}

public class BST1 {
    tree root;
    BST1()
    {
        root=null;
    }

    void insertnode(int x)
    {
        root=insert(root,x);
    }
    tree insert(tree root,int x)
    {
        if(root==null)
        {
            return new tree(x);
        }
        if(x<root.data)
        {
            root.left=insert(root.left, x);
        }
        else if (x>root.data)
        {
            root.right=insert(root.right, x);
        }
        return root;
    }
    
    boolean search(int key){
        return searchrec(root,key);
    }
    boolean searchrec(tree root,int key)
    {
        if(root==null)
        {return false;}
        else if(root.data==key)
        {
            System.out.print("value is found");
            return true;
        }
        else if(key<root.data)
        {return searchrec(root.left, key);}
        else 
        {return searchrec(root.right, key);}
    }
    void inorder()
    {
        inOrder(root);
        System.out.println();
    }
    void inOrder(tree root)
    {
        if(root!=null)
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    void Preorder()
    {
        preorder(root);
        System.out.println();
    }
    void preorder(tree root)
    {
        if(root!=null)
        {
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    void Postorder()
    {
        postorder(root);
        System.out.println();
    }
    void postorder(tree root)
    {
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args) {
        BST1 B=new BST1();
        Scanner s=new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert new node");
            System.out.println("2. Search a value");
        
            System.out.println("3. Inorder traversal");
            System.out.println("4. Preorder traversal");
            System.out.println("5. Postorder traversal");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int value = s.nextInt();
                    B.insertnode(value);
                    System.out.println("Node inserted successfully!");
                    break;
                case 2:
                    System.out.print("Enter the value to search: ");
                    int searchValue = s.nextInt();
                    B.search(searchValue);
                    System.out.println("Value " + searchValue + " " );

                case 3:
                    System.out.print("Inorder Traversal:");
                    B.inorder();
                    break;

                case 4:
                    System.out.print("Preorder Traversal:");
                    B.Preorder();
                    break;

                case 5:
                    System.out.print("Postorder Traversal:");
                    B.Postorder();
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);

        
}
}

