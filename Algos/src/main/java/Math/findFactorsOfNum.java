package Math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class findFactorsOfNum {
    public static void main(String[] args) {
        int num = 28;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                result.add(i);
                if (i * i != num) {
                    result.add(num / i);
                }
            }
        }
        Collections.sort(result);
        for (int r : result) {
            System.out.println(r);
        }
        return;
    }
}
