package lektion17.Exception;

public class OutOfMemoryError {
    public static void main(String[] args) {
        int[] bigArr = new int[Integer.MAX_VALUE];
    }
}
