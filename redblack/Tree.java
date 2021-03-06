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
        System.out.print(node.data + "(" + node.color + ")" + " "); 
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
                            recolor(nuNode);
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
                            recolor(nuNode);
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
                    redred = true;
                }
                else if(p.parent.parent.left.color == 0 && p.parent.parent.left != p.parent){
                    p.parent.parent.left.color = 1;
                    redred = true;
                }
                p.parent.color = 1;
                if(p.parent.parent!=null && p.parent.parent!=this.root){
                    p.parent.parent.color = 0;
                }
            }
            //change p=p's grandparent
            if(redred == true){
                p = p.parent.parent;
            }
            else{
                return;
            }
        }
        //red parent and black uncle case
        boolean redblack = false;
        while(p!=this.root){
            redblack = false;
            if(p.parent.parent != null){
                if(p.parent.parent.right != p.parent && (p.parent.parent.right==null || p.parent.parent.right.color==1)){
                    if(p.parent.left != p){
                        //left
                        Node temp = p.parent.left;
                        p.parent.left = p.parent.parent;
                        p.parent.parent = p.parent.parent.parent;
                        p.parent.parent.parent = p.parent;
                    }
                    else{
                        //right-left

                    }
                }
                if(p.parent.parent.left!=p.parent && (p.parent.parent.left==null || p.parent.parent.left.color==1)){
                    if(p.parent.right != p){
                        //right
                        Node temp = p.parent.right;
                        p.parent.right = p.parent.parent;
                        p.parent.parent = p.parent.parent.parent;
                        p.parent.parent.parent = p.parent;
                    }
                    else{
                        //left-right
                        Node temp = p.left;
                        p.left = p.parent;
                        p.parent.right = p.left;
                        p.parent.parent.left = 
                    }
                }
            }
        }
    }
}