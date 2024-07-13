import java.util.List;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

//TODO: Implement the websiteblocker
// Should be able to restrict access to a specified(customizable) website(s) during teh timer's
// active period.
// Once the timer ends access is restored
// handle website blocking using either the host file manipulation or an API or through proxy
// server or JPcap

/**
 * This class handles implementation of the {@link IWebBlocker} interface using host files
 * manipulation.
 */
public class WebsiteBlockerImpl implements IWebBlocker {

  protected static String HOST_FILE_PATH = "/etc/hosts";
  private static final String BLOCKED_IP = "127.0.0.1";
  private List<String> websitesToBlock;

  public WebsiteBlockerImpl() {
    this.websitesToBlock = new ArrayList<>();
  }

  /**
   * Allows the user to add a single website to block.
   *
   * @param site
   * @throws Exception if the given string is incorrect.
   */
  @Override
  public void blockSite(String site) throws Exception {
    modifySite(site, true);
    /*if (!this.websitesToBlock.contains(site)) {
      this.websitesToBlock.add(site);
      updateHostFile();
    }*/
  }

  /**
   * Allows user to remove a single website that was blocked to be unblocked.
   *
   * @param site
   * @throws Exception if the given string is incorrect.
   */
  @Override
  public void unblockSite(String site) throws Exception {
    modifySite(site, false);
    /*if(this.websitesToBlock.contains(site)) {
      this.websitesToBlock.remove(site);
      updateHostFile();
    }*/
  }

  /**
   * Allow the user to input multiple sites to block.
   *
   * @param websites
   */
  @Override
  public void addblockWebsites(List<String> websites) throws IOException {
    modifyWebsites(websites, true);
    /*for (String site : websites) {
      if (!this.websitesToBlock.contains(site)) {
        this.websitesToBlock.add(site);
      }
    }
    updateHostFile();*/

    /*try {
      updateHostFile();
    } catch (IOException e) {
      e.getMessage();
      e.printStackTrace();
    }*/
  }

  /**
   * Allow the user to input a list of websites to unblock.
   *
   * @param websites
   */
  @Override
  public void unblockWebsites(List<String> websites) throws IOException {
    modifyWebsites(websites, false);
    /*try {
      updateHostFile();
    } catch (IOException e) {
      e.getMessage();
      e.printStackTrace();
    }*/
  }

  /**
   * Modifies the site
   */
  private void modifySite(String site, boolean block) throws IOException {
    if (block && !this.websitesToBlock.contains(site)) {
      this.websitesToBlock.add(site);
    } else if (!block && this.websitesToBlock.contains(site)) {
      this.websitesToBlock.remove(site);
    }

    updateHostFile();
  }

  private void modifyWebsites(List<String> websites, boolean block) throws IOException {
    for (String site : websites) {
      if (block && !this.websitesToBlock.contains(site)) {
        this.websitesToBlock.add(site);
      } else if (!block && this.websitesToBlock.contains(site)) {
        this.websitesToBlock.remove(site);
      }
    }
    updateHostFile();
  }

  /**
   * Helper method to update the host file of the sites accordingly.
   */
  private void updateHostFile() throws IOException {
    Path path = Paths.get(HOST_FILE_PATH);
    List<String> lines = new ArrayList<>(Files.readAllLines(path));
    List<String> updateLines = new ArrayList<>();

    for (String line : lines) {
      boolean isBlocked = false;
      for (String website : this.websitesToBlock) {
        if (line.contains(website)) {
          isBlocked = true;
          break;
        }
      }
      if (!isBlocked) {
        updateLines.add(line);
      }
    }

    for (String website : websitesToBlock) {
      updateLines.add(BLOCKED_IP + " " + website);
    }

    Files.write(path, updateLines);
  }

  public String getBlockedIp() {
    return BLOCKED_IP;
  }

  public String getHostFilePath() {
    return HOST_FILE_PATH;
  }

  public void setHostFilePath(String hostFilePath) {
    HOST_FILE_PATH = hostFilePath;
  }

  public List<String> getWebsitesToBlock() {
    return websitesToBlock;
  }
}
