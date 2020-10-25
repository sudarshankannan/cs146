class Tree{
    Node root;
    //constructors
    Tree(){
        this.root = null;
    }
    //traverse inorder
    void printInorder(Node node) { 
        if (node == null) 
            return;
        printInorder(node.left); 
        System.out.print(node.data + " "); 
        printInorder(node.right); 
    } 
    //insert
    void insert(int data){
        Node nuNode = new Node(data);
        if(this.root == null){
            this.root = nuNode;
            this.root.color = 1;
        }
        else{
            Node p = this.root;
            while(p != null){
                if(data < p.data){
                    if(p.left == null){
                        p.left = nuNode;
                        nuNode.parent = p;
                        //RECOLOR LOGIC
                        if(nuNode.parent.color == 0){
                            //recolor(nuNode);
                        }
                        return;
                    }
                    else{
                        p = p.left;
                    }
                }
                else if(data > p.data){
                    if(p.right == null){
                        p.right = nuNode;
                        nuNode.parent = p;
                        //RECOLOR LOGIC
                        if(nuNode.parent.color == 0){
                            //recolor(nuNode);
                        }
                        return;
                    }
                    else{
                        p = p.right;
                    }
                }
            }
        }
    }
    void recolor(Node p){
        //red parent & red uncle case
        boolean redred = false;
        while(p!=this.root){
            redred = false;
            if(p.parent.parent != null){
                if(p.parent.parent.right.color == 0 && p.parent.parent.right != p.parent){
                    p.parent.parent.right.color = 1;
                    p.parent.color = 1;
                    redred = true;
                }
                else if(p.parent.parent.left.color == 0 && p.parent.parent.left != p.parent){
                    p.parent.parent.left.color = 1;
                    p.parent.color = 1;
                    redred = true;
                }
            }
            //change p=p's grandparent
            if(redred == true){
                p = p.parent.parent;
            }
            else{
                break;
            }
        }
        //red parent and black uncle case
        while(p!=this.root){
            redred = false;
            if(p.parent.parent != null){
                if(p.parent.parent.right.color == 0 && p.parent.parent.right != p.parent){
                    //insert
                }
                else if(p.parent.parent.left.color == 0 && p.parent.parent.left != p.parent){
                    //insert
                }
            }
        }
    }
}