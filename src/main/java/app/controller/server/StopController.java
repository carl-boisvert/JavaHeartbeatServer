package app.controller.server;

import app.model.server.Server;
import app.model.repository.ServerRepository;
import app.model.response.ErrorResponse;
import app.model.response.Response;
import app.model.response.StopResponse;
import app.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StopController {


    private ServerService ServerService;

    public StopController(ServerService ServerService)
    {
        this.ServerService = ServerService;
    }

    @RequestMapping("/server/stop")
    public Response stop(
            @RequestParam(value="url", defaultValue="") String url
    ) {
        Server server = ServerService.findServer(url);
        if(server != null)
        {
            ServerService.deleteServer(server);
            return new StopResponse(server);
        }
        return new ErrorResponse(url, 400, "Couldn't find server");
    }
}
