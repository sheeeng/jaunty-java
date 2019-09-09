package hello;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private static final Logger logger = Logger.getLogger(Application.class.getName());

    @RequestMapping("/")
    public String home() {
        String serverInfo =  hello.ServerInfo.getServerInfo();
        logger.info(serverInfo);
        return serverInfo;
    }

    @RequestMapping("/ahoy")
    public String hello() {
        return "Ahoy, matey!";
    }

    @RequestMapping("/logging")
    public String log() {
        // https://cloud.google.com/logging/docs/setup/java
        String uuid = UUID.randomUUID().toString();
        logger.fine("Logging FINE with java.util.logging : " + uuid);
        logger.info("Logging INFO with java.util.logging : " + uuid);
        logger.warning("Logging WARNING with java.util.logging : " + uuid);
        logger.severe("Logging SEVERE with java.util.logging : " + uuid);
        return "Logged " + uuid;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
