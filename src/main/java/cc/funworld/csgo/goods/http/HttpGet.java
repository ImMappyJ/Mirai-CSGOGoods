package cc.funworld.csgo.goods.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpGet {
    private String url;
    private HashMap<String,String> header = new HashMap();
    public HttpGet(String url,HashMap<String,String> header){
        this.url = url;
        this.header = header;
    }

    public String getText() throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");
        for(Map.Entry<String,String> entry:header.entrySet()){
            conn.addRequestProperty(entry.getKey(),entry.getValue());
        }
        conn.setConnectTimeout(3000);
        conn.connect();
        if(conn.getResponseCode() == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder text = new StringBuilder();
            String temp;
            while ((temp = reader.readLine()) != null) {
                text.append(temp);
            }
            reader.close();
            return text.toString();
        }else{
            return null;
        }
    }
}
