/**
 *
 */
public interface ITime {
  /**
   *
   * @param duration
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
   * @return
   */
  int getTimeRemaining();

  /**
   *
   * @return
   */
  boolean isTimerOn();
}
