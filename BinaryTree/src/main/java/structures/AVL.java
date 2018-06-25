package structures;

public class AVL {

    public class Node {
        private int h;
        private int balance;
        private int key;

        public int getKey() {
            return key;
        }

        private Node left, right, father;
        public Node (int key, Node father) {
            this.key = key;

            this.left = this.right = null;
            this.father = father;
            this.h = 1;
            this.balance = 0;
        }

        public Node next(){
            return getHigherNode(this.key);
        }

        public Node previus(){
            return getLowerNode(this.key);
        }
    }

    private Node root;

    //Возвращает ближайщий узел , больше данного ключа,
//если узла с таким ключом нет, то возвращает ближайщий узел, больше заданного ключа.
//Если нет ближайщего большего позначению,чем заданый ключ, то возвращает null
    private Node getHigherNode(int key) {
        Node p = root;
        while (p != null)
        {
            //int cmp = key.compareTo(p.key);
            if (key < p.key)
            {
                if (p.left != null)
                    p = p.left;
                else
                    return p;
            }
            else
            {
                if (p.right != null) {
                    p = p.right;
                } else {
                    Node father = p.father;
                    Node ch = p;
                    while (father != null && ch == father.right) {
                        ch = father;
                        father = father.father;
                    }
                    return father;
                }
            }
        }
        return null;
    }


    public Node getFirstNode(){
        return min(root);
    }

    //Возвращает ближайщий узел , меньше данного ключа,
//если узла с таким ключом нет, то возвращает ближайщий узел, меньше заданного ключа.
//Если нет ближайщего большего позначению,чем заданый ключ, то возвращает null
    private Node getLowerNode(int key) {
        Node p = root;
        while (p != null) {
            // int cmp = key.compareTo(p.key);
            if (key> p.key) {
                if (p.right != null)
                    p = p.right;
                else
                    return p;
            } else {
                if (p.left != null) {
                    p = p.left;
                } else {
                    Node father = p.father;
                    Node ch = p;
                    while (father != null && ch == father.left) {
                        ch = father;
                        father = father.father;
                    }
                    return father;
                }
            }
        }
        return null;
    }


    private int height(Node x, Node y){
        if(x == null && y == null) return 0;
        else if(x == null) return y.h;
        else if(y == null) return x.h;
        else return Math.max(x.h, y.h);
    }

    private int balance(Node x, Node y){
        if(x == null && y == null) return 0;
        else if(x == null) return - y.h;
        else if(y == null) return x.h;
        else return x.h - y.h;
    }

    private Node add (Node node,int key, Node father){
        if (node == null){
            Node newnode = new Node(key, father);
            return newnode;
        }
        //int compareResult = key.compareTo(node.key);
        //if (compareResult > 0)
        if (key > node.key)
        {
            node.right = add(node.right, key,  node);
            node.h = height(node.left, node.right) + 1;
        }
        else if(key < node.key)
        {
            node.left = add(node.left, key,node);
            node.h = height(node.left, node.right) + 1;
        }
//        else
//        {
//            node.value = value;
//        }
        node.balance = balance(node.left, node.right);
        if(node.balance == -2){
            node = leftRotation(node);
        }else if(node.balance == 2){
            node = rightRotation(node);
        }
        return node;
    }

    private Node leftRotation(Node node) {
        if(node.right.right == null && node.right.left != null){
            node.right = rightRotation(node.right);
            node = leftRotation(node);
        }else if(node.right.left == null || node.right.left.h <= node.right.right.h){
            Node newnode = node.right;
            newnode.father = node.father;
            node.right = newnode.left;
            if(node.right != null)
                node.right.father = node;
            node.h = height(node.left, node.right)+1;
            node.father = newnode;
            node.balance = balance(node.left, node.right);
            newnode.left = node;
            node = newnode;
            node.balance = balance(node.left, node.right);
            node.h = height(node.left, node.right)+1;
        }else{
            node.right = rightRotation(node.right);
            node = leftRotation(node);
        }
        return node;
    }

    private Node rightRotation(Node node){
        if(node.left.right != null && node.left.left == null){
            node.left = leftRotation(node.left);
            node = rightRotation(node);
        }else if(node.left.right == null || node.left.right.h <= node.left.left.h){
            Node newnode = node.left;
            newnode.father = node.father;
            node.left = newnode.right;
            if(node.left != null)
                node.left.father = node;
            node.h = height(node.left, node.right)+1;
            node.father = newnode;
            node.balance = balance(node.left, node.right);
            newnode.right = node;
            node = newnode;
            node.balance = balance(node.left, node.right);
            node.h = height(node.left, node.right)+1;
        }else{
            node.left = leftRotation(node.left);
            node = rightRotation(node);
        }
        return node;
    }

    public void add(int key) {
        root = add(root, key,  null);
    }

    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }

    private Node max(Node node){
        if(node.right == null) return node;
        return min(node.right);
    }

    private void print(Node node, int level) {
        if (node != null)
        {
            print(node.right,level+1);
            for (int i=0;i<level;i++)
            {
                System.out.print("\t");
            }
            System.out.println(node.key +" ");
            print(node.left,level+1);
        }
    }

    public void print() {
        print(root,0);
    }
}
