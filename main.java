package code_quality_lea;

public class main {
    public static void main(String[] args){
        LinkedList<String> test = new LinkedList<String>("a");
        System.out.println(test.getData());
        test.addTail("b");
        System.out.println(test.getTailData());
        test.addHead("c");
        System.out.println(test.getHeadData());
        test.addTail("d");
        System.out.println(test.getTailData());

        LinkedList<String> list_test = test.getHead();
        System.out.printf("[");
        while (list_test.getNext() != null){
            System.out.printf(list_test.getData());
            System.out.printf(", ");
            list_test = list_test.getNext();
        }
        System.out.printf(list_test.getData());
        System.out.println("]");
    }
}
