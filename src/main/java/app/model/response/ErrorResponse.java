package app.model.response;

import java.util.HashMap;

/**
 * Created by carlboisvert on 2018-07-26.
 */
public class ErrorResponse extends Response {

    protected String message;

    public ErrorResponse(String url, int code, String message)
    {
        this.code = code;
        this.message = message;
        this.data = new HashMap<String, String>();
        this.data.put("server", url);
    }

    public String getMessage() {
        return message;
    }
}
