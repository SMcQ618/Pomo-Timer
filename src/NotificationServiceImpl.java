import java.awt.*;
import java.awt.TrayIcon.MessageType;

/**
 *
 */
public class NotificationServiceImpl implements NotificationService {


  /**
   * @param message Represents the message that the user will see when the timer is finished
   */
  @Override
  public void showNotification(String message) {
    // this means if
    if (SystemTray.isSupported()) {
      SystemTray tray = SystemTray.getSystemTray();
      Image img = Toolkit.getDefaultToolkit().createImage(
          "\"C:\\Users\\steph\\Downloads\\The_Pomodoro_timer.jpeg\"");
      TrayIcon ticon = new TrayIcon(img, "Pomodoro Timer");
      ticon.setImageAutoSize(true);
      ticon.setToolTip("Pomodoro Timer Notification");

      try {
        tray.add(ticon);
        ticon.displayMessage("Pomodoro timer", message, MessageType.INFO);
      } catch (AWTException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("SystemTray not supported");
    }
  }
}
