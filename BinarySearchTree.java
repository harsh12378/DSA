public class BinarySearchTree {
   private static class  Node{
        int value;
        Node left;
        Node right;
        int height;

       public Node(int value) {
           this.value=value;
       }
       public int getValue(){
           return value;
       }
   }
    BinarySearchTree(){
    }
    Node root;
    public void insert(int value){
       root= insert(root,value);
    }
    public Node insert(Node node, int value){
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
        return node;
    }
    public boolean isEmpety(){
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
    public void display(Node node,String details){
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
    public void populateSorted(int[] nums){
        populateSorted( nums, 0, nums.length);
    }
    public void populateSorted(int[] nums,int start, int end){
        if(start>=end) return;
        int mid= (start+end)/2;
        insert(nums[mid]);
        populateSorted(nums,start,mid);
        populateSorted(nums,mid+1,end);

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



}
