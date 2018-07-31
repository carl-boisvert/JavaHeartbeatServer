package app.model.response;

import java.util.HashMap;

public abstract class Response {

    protected int code;
    protected HashMap data;
    protected HashMap metadata;

    public int getCode() {
        return code;
    }

    public HashMap getData() {
        return data;
    }

    public HashMap getMetadata() {
        return metadata;
    }
}