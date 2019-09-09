package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * The kubelet uses liveness probes to know when to restart a Container.
 * For example, liveness probes could catch a deadlock, where an application is running, but unable to make progress.
 * Restarting a Container in such a state can help to make the application more available despite bugs.
 *
 * @see https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-monitoring.html
 */
@WebEndpoint(id = "liveness")
@Component
public class LivenessEndpoint {

    /*
    // read: switches between healthy/not healthy every 30 seconds
    public CustomHealthIndicator() {
        ScheduledExecutorService scheduled =
            Executors.newSingleThreadScheduledExecutor();
        scheduled.schedule(() -> {
            isHealthy = false;
        }, 30, TimeUnit.SECONDS);
    }
    */

    private final static Logger LOGGER = LoggerFactory.getLogger(LivenessEndpoint.class);
    private boolean isOk = true;

    @ReadOperation
    public WebEndpointResponse<Health> liveness() {
        LOGGER.debug(String.format("Liveness: %s", isOk ? "DOWN" : "UP"));
        if (isOk) {
            return new WebEndpointResponse<>(Health.up().build(), 200);
        } else {
            return new WebEndpointResponse<>(Health.down().build(), 503);
        }
    }

}
