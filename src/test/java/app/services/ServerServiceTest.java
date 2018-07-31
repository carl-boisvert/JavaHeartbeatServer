package app.services;

import app.model.repository.ServerRepository;
import app.model.server.Server;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServerServiceTest {

    private ServerService serverService;
    private ServerRepository serverRepositoryMock;
    private String url = "http://facebook.com";
    private int interval = 0;
    private Server serverMock;

    @Before
    public void setUp() throws Exception {
        serverRepositoryMock = mock(ServerRepository.class);
        serverMock = mock(Server.class);
        serverService = new ServerService(serverRepositoryMock);
    }


    @Test
    public void createServerNotSaved()
    {
        assumeNotNull(serverService);
        when(serverRepositoryMock.save(any(Server.class))).thenReturn(serverMock);
        assertThat("Return value should be null if the server wasn't created", serverService.createServer(0, ""), equalTo(null));
    }

    @Test
    public void createServerSaved()
    {
        assumeNotNull(serverService);
        when(serverMock.getId()).thenReturn("1");
        when(serverRepositoryMock.save(any(Server.class))).thenReturn(serverMock);
        assertThat("Server return wasn't the same that was created", serverService.createServer(interval, url), equalTo(serverMock));
    }

    @Test
    public void findServerFound()
    {
        assumeNotNull(serverService);
        when(serverRepositoryMock.findOneByUrl(any(String.class))).thenReturn(serverMock);
        assertThat("Returned server wasn't the same that was found", serverService.findServer(url), equalTo(serverMock));
    }
}
