package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;


/**
 * Sometimes, applications are temporarily unable to serve traffic. For example, an application might need to
 * load large data or configuration files during startup, or depend on external services after startup.
 * In such cases, you don’t want to kill the application, but you don’t want to send it requests either.
 * Kubernetes provides readiness probes to detect and mitigate these situations. A pod with containers
 * reporting that they are not ready does not receive traffic through Kubernetes Services.
 *
 * @see https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-monitoring.html
 */
@WebEndpoint(id = "readiness")
@Component
public class ReadinessEndpoint {


    /*

    // read: ready after 40 seconds
	private boolean isHealthy = false;
    public CustomReadinessIndicator() {
        ScheduledExecutorService scheduled =
            Executors.newSingleThreadScheduledExecutor();
        scheduled.schedule(() -> {
            isHealthy = true;
        }, 40, TimeUnit.SECONDS);
    }
    */

    private final static Logger LOGGER = LoggerFactory.getLogger(ReadinessEndpoint.class);
    private boolean isOk = true;

    @ReadOperation
    public WebEndpointResponse<Health> readiness() {
        LOGGER.debug(String.format("Readiness: %s", isOk ? "DOWN" : "UP"));
        if (isOk) {
            return new WebEndpointResponse<>(Health.up().build(), 200);
        } else {
            return new WebEndpointResponse<>(Health.down().build(), 503);
        }
    }

}
