package go.com.conf;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * 我们能够通过health端点知道服务是否是正常的，那怎么能把health端点返回的服务状态告诉eureka-server呢?
 * 当前代码就是如何实现的！
 * 2019年4月7日19:16:18
 */
@Component
public class MyHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    private MyHealthIndicator myHealthIndicator;


    @Override
    public InstanceStatus getStatus(InstanceStatus instanceStatus) {

        //获取请求传入的状态信息
        Status status = myHealthIndicator.health().getStatus();
        if (status.equals(Status.UP)) {
            return instanceStatus.UP;
        } else {
            return instanceStatus.DOWN;
        }
    }
}
