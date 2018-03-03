
import static org.junit.Assert.*;

import junit.framework.*;


public class mainTest extends TestCase {

    public void showList(LinkedList test) {
    LinkedList<String> listtest = test.getHead();
        System.out.printf("[");
        while(listtest.getNext()!=null)

    {
        System.out.printf(listtest.getData());
        System.out.printf(", ");
        listtest = listtest.getNext();
    }
        System.out.printf(listtest.getData());
        System.out.println("]");
    }

    public void testNumberOfElements(int number) throws Exception {
        showList(test);
        assertEquals(number, test.getNumberOfElements());
    }

    LinkedList<String> test = new LinkedList<String>("a");
    public void testCreation() throws Exception {
        assertNotNull(test);
    }
    public void testAddNull() throws Exception {
        assertNull(new LinkedList<String>(null).getData());
    }
    public void testAddTail() throws Exception {
        test.addTail(new LinkedList<String>("b"));
        assertEquals("b", test.getTail().getData());
        testNumberOfElements(2);
    }
    public void testHead() throws Exception {
        test.addHead(new LinkedList<String>("c"));
        assertEquals("c", test.getHead().getData());
        testNumberOfElements(3);
    }
    public void testTail() throws Exception {
        test.addTail(new LinkedList<String>("c"));
        assertEquals("c", test.getTail().getData());
        testNumberOfElements(4);
    }
    public void testDelete() throws Exception {
        test.deleteIndex(0);
        assertEquals("a", test.getHead().getData());
    }

}