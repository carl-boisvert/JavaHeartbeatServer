package app.model.response;

import app.model.server.Server;

import java.util.HashMap;
import java.util.List;

/**
 * Created by carlboisvert on 2018-07-27.
 */
public class StatusResponse extends Response{


    public StatusResponse(List<Server> servers)
    {
        this.code = 200;
        this.data = new HashMap<String,List<Server>>();
        this.data.put("servers", servers);
    }
}
