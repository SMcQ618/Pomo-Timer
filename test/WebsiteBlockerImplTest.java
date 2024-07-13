import java.nio.file.StandardCopyOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This is the testing class for WebsiteBlocker
 */
public class WebsiteBlockerImplTest {

  private WebsiteBlockerImpl blocker;
  private static final String TEST_HOST_FILE = "test_hosts";

  @Before
  public void setup() throws Exception {
    blocker = new WebsiteBlockerImpl();

    // use a tempoary host file for testing or should I use a website
    Path testHost = Paths.get(TEST_HOST_FILE);
    //copy the system host file for testing
    Files.copy(Paths.get("/etc/host"), testHost, StandardCopyOption.REPLACE_EXISTING);

    blocker.setHostFilePath(TEST_HOST_FILE);
    // Create a test hosts file
    Files.write(Paths.get(TEST_HOST_FILE), "127.0.0.1 localhost".getBytes());
  }

  @After
  public void cleanup() throws Exception {
    //delete the temporary host files after teh tests
    Files.deleteIfExists(Paths.get(TEST_HOST_FILE));
  }

  @Test
  public void testBlockSite() throws Exception {
    // test site
    blocker.blockSite("games.wixgames.co.uk");
    assertTrue(isBlocked("games.wixgames.co.uk"));
  }

  @Test
  public void testunblockSite() throws Exception {
    blocker.blockSite("ChatRoulette.com");
    blocker.unblockSite("ChatRoulette.com");
    assertFalse(isBlocked("ChatRoulette.com"));
  }

  @Test
  public void testMoreBlockSites() throws Exception {
    List<String> websites = Arrays.asList("https://share.newshub.co.uk", "https://waisheph.com",
        "https://www.gameitlive.com", "https://blockpg-aloe.safezone.mcafee.com",
        "games.wixgames.co.uk");
    blocker.addblockWebsites(websites);
    assertTrue(isBlocked("games.wixgames.co.uk"));
    assertTrue(isBlocked("https://www.gameitlive.com"));
  }

  @Test
  public void testUnBlockWebsite() throws Exception {
    List<String> websites = Arrays.asList("wmctjd.com", "KiwiFarms.net", "Zoosk.com");
    blocker.addblockWebsites(websites);
    blocker.unblockWebsites(websites);
    assertFalse(isBlocked("wmctjd.com"));
    assertFalse(isBlocked("KiwiFarms.net"));
  }

  private boolean isBlocked(String website) throws Exception {
    List<String> lines = Files.readAllLines(Paths.get(TEST_HOST_FILE));
    for (String line : lines) {
      if (line.contains(website) && line.contains(blocker.getBlockedIp())) {
        return true;
      }
    }
    return false;
  }
}
