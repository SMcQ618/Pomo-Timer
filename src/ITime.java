/**
 * This interface holds the methods for them Time class.
 */
public interface ITime {
  /**
   *
   * @param duration the length the user wants the time to begin at
   */
  void startTimer(int duration);

  /**
   *
   */
  void pauseTimer();

  /**
   *
   */
  void resetTimer();

  /**
   *
   * @return an integer representing the amount of time that remains
   */
  int getTimeRemaining();

  /**
   *
   * @return a boolean indicating if the timer is still running
   */
  boolean isTimerOn();
}
