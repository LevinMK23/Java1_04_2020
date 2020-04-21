package lesson3;

public class BinarySearch {
    // sqrt(25) = 5
    // O(log2(N))
    public static double sqrt(double x) {
        double left = 0, right = x, epsilon = 0.00001;
        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            System.out.println(left + " " + right);
            if (mid * mid == x) {
                return mid;
            }
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static int binarySearch(int key, int[] array) {
        // -1 if not found
        // array have to be sort
        int left = 0, right = array.length - 1;
        while (right - left >= 0) {
            int idx = (left + right) / 2;
            if (array[idx] == key) {
                return idx;
            }
            if (array[idx] > key) {
                right = idx - 1;
            } else {
                left = idx + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(binarySearch(-1, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        //System.out.println(sqrt(9999999999999999999f));
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms.");
    }
}
