package app.model.server;

import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.List;
import java.util.Vector;

public class Server {

    @Id private String id;

    private int interval;
    private String url;
    private long nextExecutionDate;
    private boolean active;
    private List<ServerStatus> statuses;

    public Server(int interval, String url){
        this.interval = interval;
        this.url = url;
        active = true;
        this.statuses = new Vector<>();
        Instant instant = Instant.now();
        this.nextExecutionDate = instant.toEpochMilli();
    }

    public String getId() {
        return id;
    }

    public int getInterval() {
        return interval;
    }

    public String getUrl() {
        return url;
    }

    public long getNextExecutionDate() {
        return nextExecutionDate;
    }

    public void setNextExecutionDate(long nextExecutionDate) {
        this.nextExecutionDate = nextExecutionDate;
    }

    public boolean isActive() {
        return active;
    }

    public List<ServerStatus> getStatuses() {
        return statuses;
    }

    public void addStatus(ServerStatus status) {
        this.statuses.add(status);
    }

}