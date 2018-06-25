package app;

import structures.AVL;

public class Program {
    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.add(10);
        tree.add(11);
        tree.add(15);
        tree.add(13);
        tree.add(16);
        tree.add(12);
        tree.add(3);
        tree.add(1);
        tree.add(0);
        tree.add(14);
        tree.add(2);
        tree.add(14);

        tree.print();

        for (AVL.Node e = tree.getFirstNode(); e != null; e = e.next()) {
            System.out.print(e.getKey() + " ");
        }
        System.out.println("");
    }
}
