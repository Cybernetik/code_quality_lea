
import static org.junit.Assert.*;

import junit.framework.*;


public class mainTest extends TestCase {
    LinkedList<String> test = new LinkedList<String>("a");
    public void testCreation() throws Exception {
        assertNotNull(test);
    }
    public void testAddTail() throws Exception {
        test.addTail(new LinkedList<String>("b"));
        assertEquals("b", test.getTail().getData());
    }
    public void testHead() throws Exception {
        test.addHead(new LinkedList<String>("b"));
        assertEquals("b", test.getHead().getData());
    }
}