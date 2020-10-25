class Test{
    public static void main(String[] args) {
        Tree redwood = new Tree();
        redwood.insert(7);
        redwood.insert(8);
        redwood.insert(3);
        redwood.insert(-1);
        redwood.insert(15);
        redwood.printInorder(redwood.root);
    }
}