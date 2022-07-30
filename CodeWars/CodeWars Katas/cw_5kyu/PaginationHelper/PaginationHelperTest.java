package cw_5kyu.PaginationHelper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class PaginationHelperTest {
    @Test
    public void testSomething() {
        PaginationHelper<Character> helper = new PaginationHelper<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals("pageCount", 2, helper.pageCount());
        assertEquals("itemCount", 6, helper.itemCount());
        assertEquals("pageItemCount", 4, helper.pageItemCount(0));
        assertEquals("pageItemCount", 2, helper.pageItemCount(1));
        assertEquals("pageItemCount", -1, helper.pageItemCount(2));
        assertEquals("pageIndex", 1, helper.pageIndex(5));
        assertEquals("pageIndex", 0, helper.pageIndex(2));
        assertEquals("pageIndex", -1, helper.pageIndex(20));
        assertEquals("pageIndex", -1, helper.pageIndex(-10));
    }
}