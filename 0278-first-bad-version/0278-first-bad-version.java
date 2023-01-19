/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
import java.math.BigDecimal;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (true) {
            int mid = BigDecimal.valueOf(left).add(BigDecimal.valueOf(right)).divide(new BigDecimal(2)).intValue();
            if (isBadVersion(mid + 1) && !isBadVersion(mid)) {
                return mid + 1;
            }
            
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
                return mid;
            }

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }
}