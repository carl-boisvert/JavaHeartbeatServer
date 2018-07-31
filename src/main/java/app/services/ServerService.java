package app.services;

import app.model.repository.ServerRepository;
import app.model.server.Server;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {

    private ServerRepository serverRepo;

    public ServerService(ServerRepository serverRepo)
    {
        this.serverRepo = serverRepo;
    }

    public Server createServer(int interval, String url)
    {
        Server server = new Server(interval, url);
        server = serverRepo.save(server);
        if(server.getId() != null)
        {
            return server;
        }
        return null;
    }

    public void deleteServer(Server server)
    {
        serverRepo.delete(server);
    }

    public Server findServer(String url)
    {
        Server server = serverRepo.findOneByUrl(url);
        if(server != null)
        {
            return server;
        }
        return null;
    }

    public List<Server> getAllServers()
    {
        return serverRepo.findAll();
    }

    public List<Server> getServersToUpdate(long timestamp)
    {
        return serverRepo.findByNextExecutionDateLessThan(timestamp);
    }

    public void saveServers(List<Server> servers)
    {
        serverRepo.saveAll(servers);
    }

}
