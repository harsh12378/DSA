import java.util.Scanner;

public class BinaryTree {
  private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }
    public BinaryTree(){

    }

    private Node root;
    public void populate(Scanner scanner){
        System.out.println("enter root value=");
        int value= scanner.nextInt();
        root=new Node(value);
        populate(scanner,root);
    }

    public void populate(Scanner scanner, Node node){
        System.out.println("Do you want to add left of this node= "+node.value);
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("enter value of node= ");
            int value= scanner.nextInt();
            node.left =new Node(value);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to add right of this node= "+node.value);
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("enter value of node= ");
            int value= scanner.nextInt();
            node.right =new Node(value);
            populate(scanner,node.right);
        }
    }
    public void display(){
        display(root," ");
    }
    public void display(Node node, String indent){
        if(node!=null) {
            System.out.println(indent + node.value);

            display(node.left, " " + "\t");
            display(node.right, " " + "\t");
        }
    }



}