package app.controller.server;

import app.model.server.Server;
import app.model.repository.ServerRepository;
import app.model.response.Response;
import app.model.response.StatusResponse;
import app.services.ServerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatusController {


    private ServerService ServerService;

    public StatusController(ServerService ServerService)
    {
        this.ServerService = ServerService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/server/status")
    public Response status()
    {
        List<Server> servers = ServerService.getAllServers();
        return new StatusResponse(servers);
    }
}
