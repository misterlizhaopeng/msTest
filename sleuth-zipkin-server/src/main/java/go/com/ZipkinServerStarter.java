package go.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerStarter {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerStarter.class, args);
    }
}
