package de.dhbwka.theoinf.datenstukturen;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by cem on 19.06.16.
 */
public class JListTest {

    @Test
    public void appendTest() {
        JList<Integer> integerJList = new JList<>();
        integerJList.append(2);
        integerJList.append(4);
        integerJList.append(5);

        assertTrue(integerJList.length() == 3);
        assertEquals("erste wert muss 2 sein", new Integer(2), integerJList.get(0));
        assertEquals("erste wert muss 4 sein", new Integer(4), integerJList.get(1));
        assertEquals("erste wert muss 5 sein", new Integer(5), integerJList.get(2));
    }

    @Test
    public void containsTest() {
        JList<Boolean> booleanJList = new JList<>();
        booleanJList.append(true);
        booleanJList.append(false);
        booleanJList.append(false);

        assertTrue(booleanJList.contains(true));
        assertTrue(booleanJList.contains(false));

        JList<Boolean> booleanJList2 = new JList<>();
        booleanJList2.append(false);
        booleanJList2.append(false);
        booleanJList2.append(false);
        assertFalse(booleanJList2.contains(true));


    }


    @Test
    public void deleteTest() {
        JList<String> stringJList = new JList<>();
        stringJList.append("Hallo");
        stringJList.append("du");
        stringJList.append("da");

        assertTrue(stringJList.length() == 3);
        stringJList.delete("du");
        assertTrue(stringJList.length() == 2);
        assertFalse(stringJList.contains("du"));

        stringJList.delete("IM NOT PART OF THIS");
        assertTrue(stringJList.length() == 2);


    }


}
