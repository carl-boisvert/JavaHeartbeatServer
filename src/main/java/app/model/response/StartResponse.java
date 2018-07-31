package app.model.response;

import app.model.server.Server;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class StartResponse extends Response {


    public StartResponse(Server server)
    {
        this.code = 200;
        this.data = new HashMap<String, Server>();
        this.data.put("server", server);
    }
}