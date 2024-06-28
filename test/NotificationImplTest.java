import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NotificationImplTest {

  private NotificationImpl notificationService;
  private MockNotification mockNote;

  @Before
  public void setup() {
    notificationService = new NotificationImpl();
    mockNote = new MockNotification();
  }

  @Test
  public void testNotification() {
    // call a notification
    mockNote.showNotification("Time's up!");

    assertEquals("Time's up!", mockNote.getLastMess());
  }

  private static class MockNotification implements INotification {
    private String lastMess;

    public MockNotification() {
      this.lastMess = lastMess;
    }
    /**
     * @param message Represents the message that the user will see when the timer is finished
     */
    @Override
    public void showNotification(String message) {
      this.lastMess = message;
    }

    private String getLastMess() {
      return this.lastMess;
    }
  }
}
