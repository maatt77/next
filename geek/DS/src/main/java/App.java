public class App {

    public static void main(String[] args) {

        /*

                                      100
                                 /         \
                               1           2
                             /   \        /   \
                            3     4      5     6
                          /  \   /  \   /  \  /  \
                         7    8  9  10 11  12 13 14
                        /
                       15

         */

        Node root = new Node(100);

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirteen = new Node(13);
        Node fourteen = new Node(14);
        Node fifteen = new Node(15);

        root.setLeft(one);
        root.setRight(two);
        one.setLeft(three);
        one.setRight(four);
        two.setRight(six);
        two.setLeft(five);
        three.setLeft(seven);
        three.setRight(eight);
        four.setLeft(nine);
        four.setRight(ten);
        five.setLeft(eleven);
        five.setRight(twelve);
        six.setLeft(thirteen);
        six.setRight(fourteen);
        seven.setLeft(fifteen);

    }


}
