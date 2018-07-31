package app.services;

import app.model.server.ServerStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpService {

    public int pingServer(String hostname)
    {
        try {
            URL url = new URL(hostname);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            return con.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
            return 500;
        }
    }
}
