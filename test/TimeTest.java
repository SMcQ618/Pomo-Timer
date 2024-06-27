import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

public class TimeTest {

  private Time timer;

  @Before
  public void setup() {
    // initialize the timer object
    timer = new Time();
  }

  @Test
  public void teststartTimer() {
    // start the time at 10 seconds
    timer.startTimer(10);
    assertTrue(timer.isTimerOn());
    assertEquals(10, timer.getTimeRemaining());
  }

  @Test
  public void testpauseTimer() {
    timer.startTimer(10);
    assertTrue(timer.isTimerOn());
    timer.pauseTimer();
    assertFalse(timer.isTimerOn());
  }

  @Test
  public void testResetTimer() {
    timer.startTimer(10);
    assertTrue(timer.isTimerOn());
    timer.resetTimer();
    assertFalse(timer.isTimerOn());
    assertEquals(10, timer.getTimeRemaining());
  }

  @Test(expected = AssertionError.class)
  public void testnonresetTimer() {
    timer.startTimer(10);
    assertTrue(timer.isTimerOn());
    timer.resetTimer();
    assertTrue("This test is designed to fail", timer.isTimerOn());
  }

  @Test
  public void testgetTimeRemaining() throws InterruptedException {
    timer.startTimer(20);
    assertEquals(20, timer.getTimeRemaining());
    // slee for ~15 milliseconds
    Thread.sleep(12100);
    assertTrue(timer.isTimerOn());
    assertEquals(8, timer.getTimeRemaining());
  }

  @Test
  public void testisTimerOn() {
    assertFalse(timer.isTimerOn());
    timer.startTimer(10);
    assertTrue(timer.isTimerOn());
    timer.pauseTimer();
    assertFalse(timer.isTimerOn());
  }
}