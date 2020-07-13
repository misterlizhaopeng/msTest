package weblimit;

import com.google.common.util.concurrent.RateLimiter;

public class TestRateLimit {
    public static void main(String[] args) {
        RateLimiter rateLimiter=RateLimiter.create(1);
        for(int i = 1; i < 10; i = i + 2 ) {
            double waitTime = rateLimiter.acquire(i);//获取令牌的个数 ，返回值为，需要的时间：1 3 5 7 9 ；
            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }
    }
}
