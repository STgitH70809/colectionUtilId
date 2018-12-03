import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class TestCollectionUtil {
    @Test
    public void testGetOrEmpty1(){
        List<String> ls = null;
        assertTrue(CollectionUtil.getOrEmpty(ls).isEmpty());
        // if input is null getOrEmpty return a Empty List
    }

    @Test
    public void testGetOrEmpty2(){
        List<String> ls = new ArrayList<String>();
        ls.add("good");
        ls.add("morning");
        assertEquals(ls,CollectionUtil.getOrEmpty(ls));
        // if input is not null getOrEmpty return a list like input
    }

    @Test
    public void testFist1(){
        List<String> ls = new ArrayList<String>();
        ls.add("good");
        ls.add("morning");
        assertEquals("good",CollectionUtil.getFirst(ls).get());
        // if list not empty getFirst return the first vaule of the list
    }

    @Test
    public void testFist2(){
        List<String> ls = null;
        assertFalse(CollectionUtil.getFirst(ls).isPresent());
        // if list is getFirst return not present Optional object
    }

    @Test
    public void testFist3(){
        List<String> ls = new ArrayList<String>();;
        assertFalse(CollectionUtil.getFirst(ls).isPresent());
        // if list is empty return not present Optional object
    }

    @Test
    public void testNullSafeStream1(){
        List<String> ls = new ArrayList<String>();
        ls.add("a");
        ls.add("b");
        ls.add(null);
        ls.add("c");
        List<String> exp = new ArrayList<String>();
        exp.add("a");
        exp.add("b");
        exp.add("c");
        assertEquals(exp,CollectionUtil.nullSafeStream(ls).collect(Collectors.toList()));
    }
    @Test
    public void testNullSafeStream2(){
        List<String> ls = new ArrayList<String>();
        assertTrue(CollectionUtil.nullSafeStream(ls).collect(Collectors.toList()).isEmpty());
    }

    @Test
    public void testNullSafeStream3(){
        List<String> ls = new ArrayList<String>();
        ls.add(null);
        assertTrue(CollectionUtil.nullSafeStream(ls).collect(Collectors.toList()).isEmpty());
    }

    @Test
    public void testGetRandom1(){
        Collection<String> ls = new ArrayList<String>();
        ls.add("good");
        ls.add("morning");
        assertTrue(CollectionUtil.getRandom(ls).isPresent());
        // if list is not empty return value will be Present
    }

    @Test
    public void testGetRandom2(){
        Collection<String> ls = new ArrayList<String>();
        assertFalse(CollectionUtil.getRandom(ls).isPresent());
        // if list is empty return value will be not Present
    }
}
