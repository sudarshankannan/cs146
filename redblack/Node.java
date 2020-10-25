class Node{
    int data;
    Node left;
    Node right;
    Node parent;
    // 0 - red, 1 - black
    int color;
    //constructor
    Node(){
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = 0;
    }
    Node(int data){
        this.data = data;
        this.color = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}