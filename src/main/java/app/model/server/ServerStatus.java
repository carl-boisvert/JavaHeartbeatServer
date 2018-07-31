package app.model.server;

/**
 * Created by carlboisvert on 2018-07-27.
 */
public class ServerStatus {

    private boolean isUp;
    private long executionTime;

    public ServerStatus(boolean isUp, long executionTime)
    {
        this.isUp = isUp;
        this.executionTime = executionTime;
    }

    public boolean isUp() {
        return isUp;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}
