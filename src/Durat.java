/**
 * This class represents My way of how the user will be able to input time.
 */
public class Durat {
  private int hours;
  private int minutes;
  private int seconds;

  public Durat(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  public Durat(int minutes, int seconds) {
    this(0, minutes, seconds);
  }

  public Durat(int seconds) {
    this(0, 0, seconds);
  }

  public int getTotalSec() {
    return hours * 3600 + minutes * 60 + seconds;
  }
}
