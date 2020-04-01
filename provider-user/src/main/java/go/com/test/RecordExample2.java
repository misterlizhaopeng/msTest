package go.com.test;

public class RecordExample2 {
    int a = 0;
    boolean flag = false;

    /**
     * A 线程执行
     */
    public void writer() {
        a = 1; // 1
        flag = true; // 2
    }

    /**
     * B 线程执行
     */
    public void read() {
        if (flag) { // 3
            int i = a + a; // 4
        }
    }
}