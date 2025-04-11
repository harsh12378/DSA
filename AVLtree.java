public class AVLtree {

    private static class  Node{
        int value;
        private Node left;
        private Node right;
        int height;

        private Node(int value) {
            this.value=value;
        }
        public int getValue(){
            return value;
        }
    }
    AVLtree(){
    }
    Node root;
    public void insert(int value){
        root= insert(root,value);
    }
    private Node insert(Node node, int value){
        if(node==null){
            node=new Node(value);
            return node;
        }
        if(value<node.value){
            node.left=insert(node.left,value);
        }
        if(value> node.value){
            node.right=insert(node.right,value);
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return rotate(node);
    }
    private Node rotate(Node node){
        if(height(node.left)-height(node.right)>1) {  //left-left case
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rotateRight(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){//left-right case
                node.left=rotateLeft(node.left);
                return rotateRight(node);
            }
        }
        if(height(node.right)-height(node.left)>1){
            if(height(node.right.right)-height(node.right.left)>0){ //right-right case
                return rotateLeft(node);
            }
            if(height(node.right.left)-height(node.right.right)>0){ //right left case
                node.right=rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }
    private Node rotateRight(Node p){
        Node c=p.left;
        Node t=c.right;
        c.right=p;
        p.left=t;
        p.height = 1 + Math.max(height(p.left), height(p.right));
        c.height = 1 + Math.max(height(c.left), height(c.right));
        return c;
    }
    private Node rotateLeft(Node c){
       Node p=c.right;
       Node t=p.left;
       p.left=c;
       c.right=t;
        p.height = 1 + Math.max(height(p.left), height(p.right));
        c.height = 1 + Math.max(height(c.left), height(c.right));
       return p;
    }

    public boolean isEmpty(){
        return root==null;
    }
    private int height(Node node){
        if(node==null) return -1;
        return node.height;
    }
    public void display(){
        display(root,"Root node= ");
        print(root);
    }
    public void display(Node node, String details){
        if(node==null) return;
        System.out.println(details+node.getValue());
        display(node.left,"Left child of= "+node.getValue()+" is ");
        display(node.right,"right child of= "+node.getValue()+" is ");
    }
    public void populate(int[]nums){
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }
    public void getHeight(){
        System.out.println("height of root is= "+ root.height);
    }


    public void print(Node root) {
        print(root, 0);
    }

    private void print(Node node, int level) {
        if (node == null) return;

        // Print right child first (appears to the right in output)
        print(node.right, level + 1);

        // Print current node with indentation
        System.out.println("    ".repeat(level) + node.value);

        // Print left child
        print(node.left, level + 1);
    }
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) return true;

        int balanceFactor = Math.abs(height(node.left) - height(node.right));
        if (balanceFactor > 1) return false;

        return isBalanced(node.left) && isBalanced(node.right);
    }

}
