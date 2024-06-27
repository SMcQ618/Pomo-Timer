import java.util.List;

/**
 *
 */
public interface WebBlocker {
  /**
   *
   */
  void blockWebsites(List<String> websites);
  /**
   *
   */
  void unblockWebsites();
}
