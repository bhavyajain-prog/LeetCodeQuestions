// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:
// Input: rowIndex = 3
// Output: [1,3,3,1]

// Example 2:
// Input: rowIndex = 0
// Output: [1]

// Example 3:
// Input: rowIndex = 1
// Output: [1,1]

// Constraints:
// 0 <= rowIndex <= 33

import java.util.ArrayList;
import java.util.List;

public class Q119 {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            if (i > 0) {
                List<Integer> prevRow = rows.get(i - 1);
                for (int j = 1; j < i; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
                row.add(1);
            }
            rows.add(row);
        }
        return rows.getLast();
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
