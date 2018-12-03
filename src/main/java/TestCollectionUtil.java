import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;
public class TestCollectionUtil {
    @Test
    public void GetOrEmpty_NullInput_EmptyList(){
        assertTrue(CollectionUtil.getOrEmpty(null).isEmpty());
        // if input is null getOrEmpty return a Empty List
    }

    @Test
    public void GetOrEmpty_NonEmptyStringList_InputValue(){
        List<String> ls = List.of("good","morning");
        assertEquals(ls,CollectionUtil.getOrEmpty(ls));
        // if input is not null getOrEmpty return a list like input
    }

    @Test
    public void GetFirst_NonEmptyStringList_FirstListItem(){
        List<String> ls = List.of("good","morning");
        assertEquals("good",CollectionUtil.getFirst(ls).get());
        // if list not empty getFirst return the first value of the list
    }

    @Test
    public void GetFirst_NullInput_NotPresentOptionalObject(){
        assertFalse(CollectionUtil.getFirst(null).isPresent());
        // if list is getFirst return not present Optional object
    }

    @Test
    public void GetFirst_EmptyList_NotPresentOptionalObject(){
        List<String> ls = List.of();
        assertFalse(CollectionUtil.getFirst(ls).isPresent());
        // if list is empty return not present Optional object
    }

    @Test
    public void NullSafeStream_ListWithSomeNullValue_ListWithoutNullValue(){
        List<String> ls = new ArrayList<String>(List.of("a","b"));
        ls.add(null);
        ls.add("c");
        List<String> exc = List.of("a","b","c");
        assertEquals(exc,CollectionUtil.nullSafeStream(ls).collect(Collectors.toList()));
    }
    @Test
    public void NullSafeStream_EmptyList_EmptyList(){
        List<String> ls = List.of();
        assertTrue(CollectionUtil.nullSafeStream(ls).collect(Collectors.toList()).isEmpty());
    }

    @Test
    public void NullSafeStream_ListContainOnlyNullValue_EmptyList(){
        List<String> ls = new ArrayList<String>();
        ls.add(null);
        assertTrue(CollectionUtil.nullSafeStream(ls).collect(Collectors.toList()).isEmpty());
    }

    @Test
    public void GetRandom_NotEmptyStringList_NotNullValue(){
        Collection<String> ls = List.of("good","morning");
        assertTrue(CollectionUtil.getRandom(ls).isPresent());
        // if list is not empty return value will be Present
    }

    @Test
    public void GetRandom_EmptyList_ReturnValueIsNull(){
        Collection<String> ls = List.of();
        assertFalse(CollectionUtil.getRandom(ls).isPresent());
        // if list is empty return value will be not Present
    }
}
