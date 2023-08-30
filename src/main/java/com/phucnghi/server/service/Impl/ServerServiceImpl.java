package com.phucnghi.server.service.Impl;

import com.phucnghi.server.model.Server;
import com.phucnghi.server.repostiory.ServerRepo;
import com.phucnghi.server.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static com.phucnghi.server.enumeration.Status.SERVER_DOWN;
import static com.phucnghi.server.enumeration.Status.SERVER_UP;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ServerServiceImpl implements ServerService {
    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server) {
        log.info("Saving new Server:{}", server.getName());
        server.setImgUrl(setServerImgUrl());
        return serverRepo.save(server);
    }


    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging Server IP:{}", ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all Servers");
        return serverRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching Server by Id:{}", id);
        return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating new Server:{}", server.getName());
        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Server by id:{}", id);
        serverRepo.deleteById(id);
        return true;
    }

    private String setServerImgUrl() {
        String[] imageNames = {"server1.png", "server2.png", "server3.png", "server4.png"};
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/server/image"
                        + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
