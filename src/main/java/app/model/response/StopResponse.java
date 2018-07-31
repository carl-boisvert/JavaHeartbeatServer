package app.model.response;

import app.model.server.Server;

import java.util.HashMap;

public class StopResponse extends Response{

    public StopResponse(Server server)
    {
        this.code = 200;
        this.data = new HashMap<String, Server>();
        this.data.put("server", server);
    }
}