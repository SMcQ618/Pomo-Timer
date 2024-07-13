//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
    WebsiteBlockerImpl blocker = new WebsiteBlockerImpl();
    PomodoroTimer timer = new PomodoroTimer(blocker);

    // 2 minutes
    Durat duration = new Durat(2, 0);

    timer.startTimer(duration);
    }
  }
}
