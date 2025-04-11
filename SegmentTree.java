public class SegmentTree {
    private class Node {
        int data;
        Node left;
        Node right;
        int startInterval;
        int endInterval;
        public  Node(int startInterval,int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }
    Node root;
    public SegmentTree(int [] arr){
        this.root=constructTree(arr,0,arr.length-1);
    }
    private Node constructTree(int[] arr,int startInterval, int endInterval){
        if(startInterval==endInterval){
            Node leaf=new Node(startInterval,endInterval);
            leaf.data=arr[startInterval];
            return leaf;
        }
        Node node=new Node(startInterval,endInterval);
        int mid=(startInterval+endInterval)/2;
        node.left=constructTree(arr,startInterval,mid);
        node.right=constructTree(arr,mid+1,endInterval);
        node.data=node.left.data+node.right.data;
        return node;

    }
    public int query(int qsi,int qei){
        return query(this.root,qsi,qei);
    }
    private int query(Node node, int qsi,int qei){
        if(node.startInterval>=qsi&&node.endInterval<=qei){
            return node.data;
        } else if (node.startInterval>qei||node.endInterval<qsi) {
            return 0;
        }
        else{
            return this.query(node.left,qsi,qei)+this.query(node.right,qsi,qei);
        }
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str ="";
        if(node.left!=null){
            str=str+"internal data of right node=[ range= "+node.left.startInterval+","+node.left.endInterval+" and data is "+node.left.data+" ]\n";
            }
        else{
            str=str+"no left child";
        }
        str=str+"internal data of node=[range= "+node.startInterval+","+node.endInterval+" and data is "+node.data+" ]\n";
        if(node.right!=null){
            str=str+"internal data of left node=[range= "+node.right.startInterval+","+node.right.endInterval+" and data is "+node.right.data+" ]\n";
        }
        else{
            str=str+"no right child";
        }
        System.out.println(str);
        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }
    }


}
