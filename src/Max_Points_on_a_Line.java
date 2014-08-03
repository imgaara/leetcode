import util.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Max_Points_on_a_Line {

    static class Slope {
        int x;
        int y;

        Slope (int x, int y) {this.x = x; this.y = y;}

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Slope) {
                Slope s = (Slope) obj;
                if (x == 0 && s.x == 0 || y == 0 && s.y == 0) {
                    return true;
                } else {
                    return x == s.x && y == s.y;
                }
            } else {
                return false;
            }
        }

        public int hashCode() {
            return x * 37 + y;
        }
    }

    public int maxPoints(Point[] points) {
        if (null == points) {
            return 0;
        }

        if (points.length < 3) {
            return points.length;
        }

        int max = 0;
        Map<Slope, Integer> groups = new HashMap<Slope, Integer>();
        for (int i = 0; i < points.length - 1; ++i) {
            int sameCount = 0;
            int maxForThisPoint = 1;
            groups.clear();
            for (int j = i + 1; j < points.length; ++j) {
                int xx = points[j].x - points[i].x;
                int yy = points[j].y - points[i].y;
                if (xx == 0 && yy == 0) {
                    ++sameCount;
                    continue;
                } else {
                    if (yy == 0) {
                        yy = points[j].y;
                        xx = 0;
                    } else if (xx == 0) {
                        xx = points[j].x;
                        yy = 0;
                    } else {
                        int factor = GCD(xx, yy);
                        if (factor != 0) {
                            xx /= factor;
                            yy /= factor;
                        }
                    }

                    int count;
                    Slope s = new Slope(xx, yy);
                    Integer curCount = groups.get(s);
                    if (null == curCount) {
                        groups.put(s, 2);
                        count = 2;
                    } else {
                        groups.put(s, curCount + 1);
                        count = curCount + 1;
                    }

                    if (maxForThisPoint < count) {
                        maxForThisPoint = count;
                    }
                }
            }

            max = Math.max(max, maxForThisPoint + sameCount);
        }

        return max;
    }

    private static int GCD (int a, int b) {
        if (a == b) {
            return a;
        }

        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

    public static void main(String[] args) {
        System.out.println(GCD(3, 9));
        System.out.println(GCD(9, 3));
        Point[] points = new Point[]{
                new Point(1,1),
                new Point(1,1),
                new Point(1,1)};
        System.out.println(
                new Max_Points_on_a_Line().maxPoints(points)
        );
    }
}
