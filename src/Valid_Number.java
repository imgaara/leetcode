import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/8/2 0002.
 */
public class Valid_Number {
    static enum Status {
        START,
        LEADING_ZERO,
        SIGN,
        E_SIGN,
        E,
        INTEGER,
        POINT,
        FLOAT,
        SCIENCE,
        ERROR,
    }

    static enum Type {
        ZERO,
        DIGIT,
        E,
        POINT,
        SIGN,
        OTHERS,
    }

    private static Map<Status, Map<Type, Status>> table = new HashMap<Status, Map<Type, Status>>();

    static {
        Map<Type, Status> e = null;

        // START
        e = new HashMap<Type, Status>();
        e.put(Type.ZERO, Status.LEADING_ZERO);
        e.put(Type.DIGIT, Status.INTEGER);
        e.put(Type.E, Status.ERROR);
        e.put(Type.POINT, Status.POINT);
        e.put(Type.SIGN, Status.SIGN);
        e.put(Type.OTHERS, Status.ERROR);
        table.put(Status.START, e);

        // SIGN
        e = new HashMap<Type, Status>();
        e.put(Type.ZERO, Status.LEADING_ZERO);
        e.put(Type.DIGIT, Status.INTEGER);
        e.put(Type.E, Status.ERROR);
        e.put(Type.POINT, Status.POINT);
        e.put(Type.SIGN, Status.ERROR);
        e.put(Type.OTHERS, Status.ERROR);
        table.put(Status.SIGN, e);

        // INTEGER
        e = new HashMap<Type, Status>();
        e.put(Type.ZERO, Status.INTEGER);
        e.put(Type.DIGIT, Status.INTEGER);
        e.put(Type.E, Status.E);
        e.put(Type.POINT, Status.FLOAT);
        e.put(Type.SIGN, Status.ERROR);
        e.put(Type.OTHERS, Status.ERROR);
        table.put(Status.INTEGER, e);

        // SCIENCE
        e = new HashMap<Type, Status>();
        e.put(Type.ZERO, Status.SCIENCE);
        e.put(Type.DIGIT, Status.SCIENCE);
        e.put(Type.E, Status.ERROR);
        e.put(Type.POINT, Status.ERROR);
        e.put(Type.SIGN, Status.ERROR);
        e.put(Type.OTHERS, Status.ERROR);
        table.put(Status.SCIENCE, e);

        // FLOAT
        e = new HashMap<Type, Status>();
        e.put(Type.ZERO, Status.FLOAT);
        e.put(Type.DIGIT, Status.FLOAT);
        e.put(Type.E, Status.E);
        e.put(Type.POINT, Status.ERROR);
        e.put(Type.SIGN, Status.ERROR);
        e.put(Type.OTHERS, Status.ERROR);
        table.put(Status.FLOAT, e);

        // POINT
        e = new HashMap<Type, Status>();
        e.put(Type.ZERO, Status.FLOAT);
        e.put(Type.DIGIT, Status.FLOAT);
        e.put(Type.E, Status.ERROR);
        e.put(Type.POINT, Status.ERROR);
        e.put(Type.SIGN, Status.ERROR);
        e.put(Type.OTHERS, Status.ERROR);
        table.put(Status.POINT, e);

        // LEADING_ZERO
        e = new HashMap<Type, Status>();
        e.put(Type.ZERO, Status.LEADING_ZERO);
        e.put(Type.DIGIT, Status.INTEGER);
        e.put(Type.E, Status.E);
        e.put(Type.POINT, Status.FLOAT);
        e.put(Type.SIGN, Status.ERROR);
        e.put(Type.OTHERS, Status.ERROR);
        table.put(Status.LEADING_ZERO, e);

        // E
        e = new HashMap<Type, Status>();
        e.put(Type.ZERO, Status.SCIENCE);
        e.put(Type.DIGIT, Status.SCIENCE);
        e.put(Type.E, Status.ERROR);
        e.put(Type.POINT, Status.ERROR);
        e.put(Type.SIGN, Status.E_SIGN);
        e.put(Type.OTHERS, Status.ERROR);
        table.put(Status.E, e);

        // E_SIGN
        e = new HashMap<Type, Status>();
        e.put(Type.ZERO, Status.SCIENCE);
        e.put(Type.DIGIT, Status.SCIENCE);
        e.put(Type.E, Status.ERROR);
        e.put(Type.POINT, Status.ERROR);
        e.put(Type.SIGN, Status.E_SIGN);
        e.put(Type.OTHERS, Status.ERROR);
        table.put(Status.E_SIGN, e);
    }

    public boolean isNumber(String s) {
        int i = 0;
        int j = s.length() - 1;
        Status status = Status.START;

        while (i <= j && (s.charAt(j) == ' ' || s.charAt(j) == '\t')) {
            j--;
        }

        while (i <= j && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) {
            i++;
        }

        for (; i <= j; i++) {
            final char ch = s.charAt(i);
            Type type;
            if (ch == '0') {
                type = Type.ZERO;
            } else if (ch > '0' && ch <= '9') {
                type = Type.DIGIT;
            } else if (ch == '-' || ch == '+') {
                type = Type.SIGN;
            } else if (ch == '.') {
                type = Type.POINT;
            } else if (ch == 'e') {
                type = Type.E;
            } else {
                type = Type.OTHERS;
            }
            Status next = table.get(status).get(type);
            if (next == Status.ERROR) {
                return false;
            }

            status = next;
        }

        return status.equals(Status.LEADING_ZERO) || status.equals(Status.INTEGER) || status.equals(Status.FLOAT) || status.equals(Status.SCIENCE);
    }


    public boolean isNumber2(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isNumeric = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        if (isNumeric && i < n && s.charAt(i) == 'e') {
            i++;
            isNumeric = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isNumeric && i == n;
    }

    public static void main(String[] args) {
        System.out.println(new Valid_Number().isNumber(".0e"));
    }
}
