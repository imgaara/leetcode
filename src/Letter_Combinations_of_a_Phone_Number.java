import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/8/20 0020.
 */
public class Letter_Combinations_of_a_Phone_Number {
    static String[] TABLE = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
            "",
    };

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        letterCombinations_(digits, 0, new StringBuilder(), results);
        return results;
    }

    private void letterCombinations_(String digits, int start, StringBuilder curResult, List<String> results) {
        if (start >= digits.length()) {
            results.add(curResult.toString());
            return;
        }

        char curCh = digits.charAt(start);
        String curTable = TABLE[curCh - '0'];

        for (int i = 0; i < curTable.length(); ++i) {
            curResult.append(curTable.charAt(i));
            letterCombinations_(digits, start+1, curResult, results);
            curResult.deleteCharAt(curResult.length() - 1);
        }
    }
}
