package net.ictcampus.fangis;

import org.junit.Assert;
import org.junit.Test;

public class JUnitTest {
    JUnit j = new JUnit();

    @Test
    public void findInListTest() {
        j.addToList("Hund");
        Assert.assertEquals(j.findInList("Hund"), 0);
    }

    @Test
    public void findInListTest2() {
        Assert.assertEquals(j.findInList("Affe"), 99);
    }
}