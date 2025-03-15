package dataStruct2;
import java.util.*;
public class BinarySeachTrees {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    static class BST{
        static Node insert(Node root, int val){
            if(root==null){
                return (new Node(val));
            }
            if(root.data>val){
                root.left = insert(root.left, val);
            }else{
                root.right = insert(root.right, val);
            }
            return root;
        }
        static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        static  boolean search(Node root, int key){
            if(root==null){
                return false;
            }
            if(root.data>key){
                return search(root.left, key);
            }else if(root.data<key){
                return search(root.right, key);
            }else{
                return true;
            }
        }
        static Node delete(Node root, int val){
            if(root.data>val){
                root.left = delete(root.left, val);
            }else if(root.data<val){
                root.right = delete(root.right, val);
            }else{
                if(root.left==null && root.right==null){
                    return null;
                }
                if(root.left==null){
                    return root.right;
                }else if(root.right==null){
                    return root.left;
                }else{
                    Node IS = inorderSuccessor(root.right);
                    root.data = IS.data;
                    root.right = delete(root.right, IS.data);
                }
            }
            return root;
        }
        static Node inorderSuccessor(Node root){
            if(root.left==null){
                return root.left;
            }
            return inorderSuccessor(root.left);
        }
        static void printInRange(Node root, int X, int Y){
            if(root==null){
                return;
            }
            if(root.data>=X && root.data<=Y){
                printInRange(root.left, X, Y);
                System.out.print(root.data+" ");
                printInRange(root.right, X, Y);
            }else if(root.data>=Y){
                printInRange(root.left, X, Y);
            }else{
                printInRange(root.right, X, Y);
            }
        }
        static void pathToLeaf(Node root, ArrayList<Integer> path){
            if(root==null){
                return;
            }
            path.add(root.data);
            if(root.right==null && root.left==null){
                for(int i=0;i<path.size();i++){
                    System.out.print(path.get(i)+"->");
                }
                System.out.println();
            }else{
                pathToLeaf(root.left, path);
                pathToLeaf(root.right, path);
            }
            path.remove(path.size()-1);
        }
    }
    public static void main(String args[]){
        int[] nodes = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for(int i=0;i<nodes.length;i++){
            root = BST.insert(root,nodes[i]);
        }
        BST.inorder(root);
        System.out.println(BST.search(root, 5));
        System.out.println(BST.search(root, 7));
        System.out.println(BST.search(root, 10));
        BST.delete(root, 4);
        BST.inorder(root);
        System.out.println();
        BST.printInRange(root, 5, 10);
        ArrayList<Integer> path = new ArrayList<>();
        System.out.println();
        BST.pathToLeaf(root, path);
    }
}
