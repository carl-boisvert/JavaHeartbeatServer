package app.task;

import app.model.server.Server;
import app.model.server.ServerStatus;
import app.services.HttpService;
import app.services.ServerService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Vector;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by carlboisvert on 2018-07-30.
 */
public class PingServerTest {

    private HttpService httpService;
    private ServerService serverService;
    private PingServerTask pingServerTask;
    private List<Server> servers;

    @Before
    public void setUp() throws Exception {
        httpService = mock(HttpService.class);
        serverService = mock(ServerService.class);
        pingServerTask = new PingServerTask(serverService, httpService);
        servers = new Vector<>();
    }

    @Test
    public void pingServersSuccessfullyTest()
    {
        String url = "http://facebook.com";
        long timestamp = 0;
        servers.add(new Server(0, url));

        when(serverService.getServersToUpdate(anyLong())).thenReturn(servers);
        when(httpService.pingServer(url)).thenReturn(200);

        servers = pingServerTask.pingServers();
        Server server = servers.get(0);

        assertThat("Server should have a new status added", server.getStatuses().size(), is(1));

        ServerStatus serverStatus = server.getStatuses().get(0);

        assertThat("ServerStatus should be up", serverStatus.isUp(), is(true));
        assertThat("ServerStatus should be up", serverStatus.getExecutionTime(), equalTo(server.getNextExecutionDate()-server.getInterval()));
    }

    @Test
    public void pingServersFailTest()
    {
        String url = "http://facebook.com";
        long timestamp = 0;
        servers.add(new Server(0, url));

        when(serverService.getServersToUpdate(anyLong())).thenReturn(servers);
        when(httpService.pingServer(url)).thenReturn(500);

        servers = pingServerTask.pingServers();
        Server server = servers.get(0);

        assertThat("Server should have a new status added", server.getStatuses().size(), is(1));

        ServerStatus serverStatus = server.getStatuses().get(0);

        assertThat("ServerStatus should be up", serverStatus.isUp(), is(false));
        assertThat("ServerStatus should be up", serverStatus.getExecutionTime(), equalTo(server.getNextExecutionDate()-server.getInterval()));
    }
}
