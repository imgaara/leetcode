import java.util.*;

/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> r = new ArrayList<String>();
        if (null == strs) {
            return r;
        }

        Map<String, List<String>> groups = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String model = new String(charArr);
            List<String> group = groups.get(model);

            if (group == null) {
                group = new ArrayList<String>();
                group.add(str);
                groups.put(model, group);
            } else {
                group.add(str);
            }
        }

        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            if (entry.getValue().size() == 1) {
                continue;
            } else {
                r.addAll(entry.getValue());
            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Anagrams().anagrams(new String[]{"",""}));
    }
}
