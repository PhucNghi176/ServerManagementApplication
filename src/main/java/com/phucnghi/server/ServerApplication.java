package com.phucnghi.server;

import com.phucnghi.server.enumeration.Status;
import com.phucnghi.server.model.Server;
import com.phucnghi.server.repostiory.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepo serverRepo) {
        return args -> {
            serverRepo.save(new Server
                    ("192.168.1.1", "Ubuntu Linux", "16 GB", "Personal PC",
                            "http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
            serverRepo.save(new Server(
                    "192.168.1.2",
                    "Windows Server",
                    "32 GB",
                    "Office PC",
                    "http://localhost:8080/server/image/server2.png",
                    Status.SERVER_DOWN
            ));

            serverRepo.save(new Server(
                    "192.168.1.3",
                    "CentOS",
                    "8 GB",
                    "Home PC",
                    "http://localhost:8080/server/image/server3.png",
                    Status.SERVER_UP
            ));

            serverRepo.save(new Server(
                    "192.168.1.4",
                    "Ubuntu Server",
                    "64 GB",
                    "Data Center",
                    "http://localhost:8080/server/image/server4.png",
                    Status.SERVER_DOWN
            ));
        };
    }

}
