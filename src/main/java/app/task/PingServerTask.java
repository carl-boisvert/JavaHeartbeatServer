package app.task;

import app.model.server.Server;
import app.model.server.ServerStatus;
import app.services.HttpService;
import app.services.ServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class PingServerTask {

    private ServerService serverService;
    private HttpService httpService;
    private static final Logger log = LoggerFactory.getLogger(PingServerTask.class);
    private final int delayMilis = 1000;

    public PingServerTask(ServerService serverService, HttpService httpService)
    {
        this.serverService = serverService;
        this.httpService = httpService;
    }

    @Scheduled(fixedDelay = delayMilis)
    public List<Server> pingServers() {

        Instant instant = Instant.now();
        long timestamp = instant.toEpochMilli();

        List<Server> servers = serverService.getServersToUpdate(timestamp);
        for (Server server: servers) {

            ServerStatus serverStatus;
            int code = httpService.pingServer(server.getUrl());

            if(code == 200)
            {
                serverStatus = new ServerStatus(true, timestamp);
                server.addStatus(serverStatus);
            }
            else
            {
                serverStatus = new ServerStatus(false, timestamp);
                server.addStatus(serverStatus);
            }

            server.setNextExecutionDate(timestamp + server.getInterval());
        }
        serverService.saveServers(servers);
        return servers;
    }
}
