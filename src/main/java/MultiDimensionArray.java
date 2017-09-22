import java.util.Arrays;

/**
 * Example of iteration (sum) through multidimensional array without recursion.
 * Note: Multidimension array structure is not implemented, only iteration method
 */
public class MultiDimensionArray {
    // This is a provided function, Assume it works
    public Long getValue(int... indexOfDimension) {
        System.out.println(Arrays.toString(indexOfDimension));
        Long value = 0L;
        return value;
    }

    // lengthOfDeminsion: each dimension's length, assume it is valid: lengthOfDeminsion[i]>0.
    // Your resolution
    // Time complexity: O(n) amortized
    // Space complexity: O(n)
    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) {
        Long sum = 0L;
        int[] currentElement = new int[lengthOfDeminsion.length];
        int n = lengthOfDeminsion.length - 1;
        while (n >= 0) {
            while (++currentElement[n] == lengthOfDeminsion[n]) {
                if (n == 0) {
                    return sum;
                }
                currentElement[n--] = 0;
            }
            if (n >= 0) n = lengthOfDeminsion.length - 1;
            sum += mArray.getValue(currentElement);

        }
        return sum;
    }


    public static void main(String[] args) {
        MultiDimensionArray mArray = new MultiDimensionArray();
        MultiDimensionArray.sum(mArray, new int[]{3, 3, 3});
    }


}