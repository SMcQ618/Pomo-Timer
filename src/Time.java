import java.util.Timer;
import java.util.TimerTask;

/**
 * Manages the logic and the state of the timer.
 */
public class Time implements ITime {

  private int duration; // this will be in seconds
  private int timeRemaining;
  private Timer timer;
  private boolean isRunning;

  /**
   * Constructor that initializes the objects.
   */
  public Time() {
    this.duration = 0;
    this.timeRemaining = 0;
    this.isRunning = false;
  }
  /**
   * @param duration
   */
  @Override
  public void startTimer(int duration) {
    if (this.isRunning) {
      return;
    }
    this.duration = duration;
    this.timeRemaining = this.duration;
    this.isRunning = true;
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
      /**
       * The action to be performed by this timer task.
       */
      @Override
      public void run() {
        if (timeRemaining > 0) {
          timeRemaining--;
        } else {
          stopTimer();
        }
      }
    }, 1000, 1000);
  }

  /**
   *
   */
  @Override
  public void pauseTimer() {
    if (!this.isRunning) {
      return;
    }
    stopTimer();
  }

  /**
   *
   */
  @Override
  public void resetTimer() {
    stopTimer();
    this.timeRemaining = this.duration;
  }

  /**
   * @return
   */
  @Override
  public int getTimeRemaining() {
    return this.timeRemaining;
  }

  /**
   * @return
   */
  @Override
  public boolean isTimerOn() {
    return this.isRunning;
  }

  private void stopTimer() {
    if (timer != null) {
      timer.cancel();
      timer = null;
    }
    this.isRunning = false;
  }
}
