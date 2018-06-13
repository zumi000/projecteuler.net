import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {


    @Override
    public int compare(Integer integer, Integer t1) {
        if (integer == t1) {
            return 0;
        } else if (integer < t1) {
            return 1;
        } else return -1;
    }
}
