public class AVLTreeDriver {
	public static void main(String[] args) {
                System.out.println("\nSINGLE LEFT ROTATION EXAMPLE: ");
                System.out.println("Insert 45 in the following AVL tree:");
                AVLTree<Integer> avlTree2 = new AVLTree<Integer>();
                Integer[] array1 = new Integer[] { 30, 5, 35, 32, 40 };
                for (int i = 0; i < array1.length; i++)
                        avlTree2.insertAVL(array1[i]);
                // avlTree2.printTree();
                System.out.println("\nInsertion result: ");
                avlTree2.insertAVL(45);
                System.out.println();
                // avlTree2.printTree();
                // ========================= TASK01=========================================
                AVLTree<Integer> avlTreeTask1 = new AVLTree<Integer>();
                Integer[] arrayTask1 = new Integer[] { 5, 2, 7, 1, 4, 6, 9, 3, 16 };
                for (int i = 0; i < arrayTask1.length; i++)
                        avlTreeTask1.insertAVL(arrayTask1[i]);



                avlTreeTask1.printTree();
                System.out.println("Inserting result : ");
                avlTreeTask1.insertAVL(15);
                avlTreeTask1.printTree();


                
                // ================================ TASK02 ================================
                AVLTree<Integer> avlTreeTask2 = new AVLTree<Integer>();
                Integer[] arrayTask2 = new Integer[] { 7, 2, 15, 1, 3, 10, 17, 5, 9, 13, 18, 11 };
                for (int i = 0; i < arrayTask2.length; i++)
                        avlTreeTask2.insertAVL(arrayTask2[i]);
                avlTreeTask2.printTree();

                avlTreeTask2.deleteAVL(1);
                avlTreeTask2.printTree();
                // =============================== TASK03 =====================================
                System.out.println("\n task3: ");
                System.out.println("Insert the required maximum key in the following AVL tree:");
                AVLTree<Integer> avlTreeTask3 = new AVLTree<Integer>();
                Integer[] arrayTask3 = new Integer[] { 32, 26, 54, 14, 30, 44, 27 };
                for (int i = 0; i < arrayTask3.length; i++)
                        avlTreeTask3.insertAVL(arrayTask3[i]);
                avlTreeTask3.printTree();
                System.out.println("Insertion result: ");
                avlTreeTask3.insertAVL(43);
                avlTreeTask3.printTree();
                // ================================= TASK04 ==========================
                System.out.println("\n task 4:");
                System.out.println("Insert the required minimum key in the following AVL tree:");

                AVLTree<Integer> avlTreeTask4 = new AVLTree<Integer>();
                for (int i = 0; i < arrayTask3.length; i++)
                        avlTreeTask4.insertAVL(arrayTask3[i]);
                avlTreeTask4.printTree();
                System.out.println("Insertion result: ");
                avlTreeTask4.insertAVL(28);
                avlTreeTask4.printTree();}
}