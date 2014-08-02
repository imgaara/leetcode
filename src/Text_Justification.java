import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/8/2 0002.
 */
public class Text_Justification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> r = new ArrayList<String>();

        if (words.length == 0) {
            return r;
        }

        int curCount = 0;
        int wordCount = 0;
        int letterCount = 0;
        int p = 0;
        int start = 0;
        while (p < words.length) {
            while (p < words.length && curCount <= L) {
                if (canAdd(curCount, wordCount, words[p].length(), L)) {
                    if (wordCount == 0) {
                        wordCount = 1;
                        curCount = words[p].length();
                        letterCount += words[p].length();
                    } else {
                        wordCount++;
                        curCount += words[p].length() + 1;
                        letterCount += words[p].length();
                    }
                } else {
                    break;
                }
                p++;
            }

            StringBuilder line = new StringBuilder();
            int totalPadding = L - letterCount;

            if (wordCount == 0) {
                return r;
            } else if (wordCount == 1) {
                line.append(words[start]);
                while (totalPadding-- > 0) {
                    line.append(' ');
                }
                r.add(line.toString());
            } else {
                if (p >= words.length) {
                    for (int i = 0 ; i < wordCount; ++i) {
                        String cur = words[start + i];
                        if (i > 0) {
                            line.append(' ');
                        }
                        line.append(cur);
                    }
                    totalPadding -= wordCount - 1;
                    while (totalPadding-- > 0) {
                        line.append(' ');
                    }
                    r.add(line.toString());
                } else {
                    int paddingCount =  wordCount - 1;
                    int avgPadding = totalPadding / paddingCount;
                    int left = totalPadding - avgPadding * paddingCount;

                    for (int i = 0 ; i < wordCount; ++i) {
                        String cur = words[start + i];
                        if (i > 0) {
                            for (int k = 0; k < avgPadding; k++) {
                                line.append(' ');
                            }
                            if (left-- > 0) {
                                line.append(' ');
                            }
                        }
                        line.append(cur);
                    }

                    r.add(line.toString());
                }
            }

            curCount = 0;
            wordCount = 0;
            letterCount = 0;
            start = p;
        }

        return r;
    }

    private boolean canAdd(int curCount, int wordCount, int nextCount, int L) {
        if (wordCount == 0) {
            return nextCount <= L;
        } else {
            return curCount + nextCount + 1 <= L;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Text_Justification().fullJustify(new String[]{""}, 0));
    }
}
