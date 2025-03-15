package dataStruct2;
import java.util.*;
public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTrees{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        public static void preOrder(Node root){
            if(root==null){
                return;
            }
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
        public static int countOfNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftNodes = countOfNodes(root.left);
            int rightNodes = countOfNodes(root.right);
            return leftNodes+rightNodes+1;
        }
        public static int sumOfNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum+rightSum+root.data;
        }
        public static int heightOfNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftHeight = heightOfNodes(root.left);
            int rightHeight = heightOfNodes(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int leftDiam = heightOfNodes(root.left);
            int rightDiam = heightOfNodes(root.right);
            int diam = leftDiam+rightDiam+1;
            return Math.max(diam,Math.max(leftDiam,rightDiam));
        }
        static class TreeInfo{
            int ht;
            int diam;
            TreeInfo(int ht, int diam){
                this.ht=ht;
                this.diam=diam;
            }
        }
        // public static TreeInfo diameter2{
        //     TreeInfo left = diameter2(root.left);
        //     TreeInfo
        // }
        public static void levelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }

            }
        }
    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //BinaryTrees tree = new BinaryTrees();
        Node root = BinaryTrees.buildTree(nodes);
        System.out.println(root.data);
        BinaryTrees.preOrder(root);
        BinaryTrees.levelOrder(root);
        System.out.println(BinaryTrees.countOfNodes(root));
        System.out.println(BinaryTrees.sumOfNodes(root));
        System.out.println(BinaryTrees.heightOfNodes(root));
    }
}
