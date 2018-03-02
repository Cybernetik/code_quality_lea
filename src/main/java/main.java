
public class main {

    public static void main(String[] args) {
        LinkedList<String> test = new LinkedList<String>("a");
        System.out.println(test.getData());
        test.addTail("b");
        System.out.println(test.getTailData());
        test.addHead("c");
        System.out.println(test.getHeadData());
        test.addTail("d");
        System.out.println(test.getTailData());

        LinkedList<String> listtest = test.getHead();
        System.out.printf("[");
        while (listtest.getNext() != null) {
            System.out.printf(listtest.getData());
            System.out.printf(", ");
            listtest = listtest.getNext();
        }
        System.out.printf(listtest.getData());
        System.out.println("]");

    }
}
