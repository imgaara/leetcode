/**
 * Created by Administrator on 2014/7/24 0024.
 */
public class Permutation_Sequence {
    public String getPermutation(int n, int k) {
        int[] numbers = new int[n];
        long count = 1;

        for (int i = 0; i < n; ++i) {
            numbers[i] = i + 1;
            count *= numbers[i];
        }

        k--;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            count /= n - i;
            int selected = (int) (k / count);
            sb.append(numbers[selected]);

            for (int j = selected; j < n - 1 - i; ++j) {
                numbers[j] = numbers[j + 1];
            }

            k = (int)(k % count);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Permutation_Sequence().getPermutation(1, 1));
    }
}
