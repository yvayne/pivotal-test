package org.fundacionjala.pivotal.cucumber.assertions;

import org.junit.Assert;

/**
 * Created by Ruber Cuellar on 6/2/2017.
 */
public final class Assertions {

    /**
     * Constructor.
     */
    private Assertions() {
    }

    /**
     * To compare two ints.
     * @param actualResult actual int
     * @param expectedResult expected int
     */
    public static void equals(final int actualResult, final int expectedResult) {
        Assert.assertEquals(actualResult, expectedResult);
    }

}
