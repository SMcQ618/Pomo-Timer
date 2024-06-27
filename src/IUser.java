import java.awt.Color;
import java.io.File;
import java.util.List;

/**
 *
 */
public interface IUser {
  /**
   *
   */
  void setupUI();
  /**
   *
   * @param duration
   */
  void setTimerDuration(int duration);
  /**
   *
   * @param color
   */
  void setBackground(Color color);
  /**
   *
   * @param imageFile
   */
  void setBackgroundImage(File imageFile);
  /**
   *
   * @param percent
   */
  void displayProgress(int percent);
  /**
   *
   * @param message
   */
  void displayNotification(String message);
  /**
   *
   * @param websites
   */
  void blockWebsites(List<String> websites);
  /**
   *
   */
  void unblockWebsites();
}
