import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;
public class TestCollectionUtil {
    @Test
    public void getOrEmpty_nullInput_emptyList(){
        assertTrue(CollectionUtil.getOrEmpty(null).isEmpty());
    }

    @Test
    public void getOrEmpty_nonEmptyStringList_inputValue(){
        List<String> ls = List.of("good","morning");
        assertEquals(ls,CollectionUtil.getOrEmpty(ls));
    }

    @Test
    public void getFirst_nonEmptyStringList_firstListItem(){
        List<String> ls = List.of("good","morning");
        assertEquals("good",CollectionUtil.getFirst(ls).get());
    }

    @Test
    public void getFirst_nullInput_notPresentOptionalObject(){
        assertFalse(CollectionUtil.getFirst(null).isPresent());
    }

    @Test
    public void getFirst_emptyList_notPresentOptionalObject(){
        List<String> ls = List.of();
        assertFalse(CollectionUtil.getFirst(ls).isPresent());
        // if list is empty return not present Optional object
    }

    @Test
    public void nullSafeStream_listWithSomeNullValue_listWithoutNullValue(){
        List<String> ls = new ArrayList<String>(List.of("a","b"));
        ls.add(null);
        ls.add("c");
        List<String> exc = List.of("a","b","c");
        assertEquals(exc,CollectionUtil.nullSafeStream(ls).collect(Collectors.toList()));
    }
    @Test
    public void nullSafeStream_emptyList_emptyList(){
        List<String> ls = List.of();
        assertTrue(CollectionUtil.nullSafeStream(ls).collect(Collectors.toList()).isEmpty());
    }

    @Test
    public void nullSafeStream_listContainOnlyNullValue_emptyList(){
        List<String> ls = new ArrayList<String>();
        ls.add(null);
        assertTrue(CollectionUtil.nullSafeStream(ls).collect(Collectors.toList()).isEmpty());
    }

    @Test
    public void getRandom_notEmptyStringList_notNullValue(){
        Collection<String> ls = List.of("good","morning");
        assertTrue(CollectionUtil.getRandom(ls).isPresent());
    }

    @Test
    public void getRandom_emptyList_returnValueIsNull(){
        Collection<String> ls = List.of();
        assertFalse(CollectionUtil.getRandom(ls).isPresent());
    }
}
