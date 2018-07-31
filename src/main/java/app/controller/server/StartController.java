package app.controller.server;

import app.model.server.Server;
import app.model.response.ErrorResponse;
import app.model.response.Response;
import app.services.ServerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.response.StartResponse;

@RestController
public class StartController {


    private ServerService ServerService;

    public StartController(ServerService ServerService)
    {
        this.ServerService = ServerService;
    }

    @RequestMapping("/server/start")
    public Response start(
            @RequestParam(value="interval", defaultValue="60000") int interval,
            @RequestParam(value="url", defaultValue="") String url
    ) {
        Server server = ServerService.findServer(url);
        if(server == null)
        {
            server = ServerService.createServer(interval, url);
            if(server != null)
            {
                return new StartResponse(server);
            }
            return new ErrorResponse(url, 500, "Server couldn't be saved");
        }

        return new ErrorResponse(url, 400, "Server already monitored");
    }
}
