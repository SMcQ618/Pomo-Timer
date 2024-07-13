import java.util.List;

/**
 * Interface for the website blocker.
 */
public interface IWebBlocker {

  /**
   * Allows the user to add a single website to block.
   * @param site The website to block
   * @throws Exception if the given string is incorrect.
   */
  void blockSite(String site) throws Exception;

  /**
   * Allows user to remove a  website that was blocked to be unblocked.
   * @param site The website to unblock
   * @throws Exception if the given string is incorrect.
   */
  void unblockSite(String site) throws Exception;
  /**
   * Allows the user to input a large number of sites to block.
   * @param websites List of websites to block
   */
  void addblockWebsites(List<String> websites) throws Exception;
  /**
   * Allows the user to input a large number of sites to unblock.
   * @param websites List of websites to unblock
   */
  void unblockWebsites(List<String> websites) throws Exception;
}
