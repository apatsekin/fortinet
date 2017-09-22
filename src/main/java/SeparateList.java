import java.util.List;


/**
 * Example of algorithm to chec if list can be separated into groups with equal sums (without reorder!).
 * Negative values supported.
 */
public class SeparateList {
    //Since it has all required parameters as an input, I put a "static" on it.
    // Time complexity: O(n)
    // Space complexity: O(n)
    public static boolean separate(List<Integer> list, int k) {

        Integer sum = 0;
        for (Integer element : list) {
            sum += element;
        }
        // it's not possible to divide list into negative or 0 pieces
        if(k < 1){
            return false;
        }
        // If sum over k has remainder, it's false
        // If list empty => false, since it's not possible to split empty list
        if (sum % k > 0 || list.size() == 0) {
            return false;
        }
        int chunkSum = sum / k;
        int currentSum = 0;
        int chunkCounter = 0;
        for (Integer element : list) {
            currentSum += element;
            //wait until it matches chunkSum, since elements may be < 0
            if (currentSum == chunkSum) {
                //reset the counter when sum reached
                currentSum = 0;
                chunkCounter++;
            }
        }
        if (currentSum == 0 && chunkCounter == k) {
            return true;
        }
        return false;
    }
}
