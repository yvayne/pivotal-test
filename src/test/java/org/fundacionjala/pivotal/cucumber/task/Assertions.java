package org.fundacionjala.pivotal.cucumber.task;

import org.junit.Assert;

/**
 * Created by Administrator on 6/2/2017.
 */
public final class Assertions {

  /**
   * Assertions Constructor.
   */
  private Assertions() {
  }

  /**
   * @param actualResult int value.
   * @param expectedResult int value.
   */
  public static void equals(final int actualResult, final int expectedResult) {
    Assert.assertEquals(actualResult, expectedResult);
  }
}
