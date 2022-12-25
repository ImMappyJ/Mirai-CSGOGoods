package cc.funworld.csgo.goods.util;

import cc.funworld.csgo.goods.CSGOGoods;
import cc.funworld.csgo.goods.config.PluginConfig;
import cc.funworld.csgo.goods.http.HttpGet;
import cc.funworld.csgo.goods.util.buff.DataJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

public class Buff_Search {
    private final String url = "https://buff.163.com/api/market/goods?game=csgo"; //+keyword
    private DataJson data;
    private String keyword = "";
    private String page = "1";
    public Buff_Search(String keyword,String page) throws IOException {
        this.keyword = keyword;
        this.page = page;
        getData();
    }

    public Buff_Search(String keyword) throws IOException {
        this.keyword = keyword;
        getData();
    }

    public DataJson getData() throws IOException {
        HashMap<String,String> header = new HashMap<>();
        header.put("cookie", PluginConfig.getBuff_cookie());
        HttpGet httpGet = new HttpGet(url+"&page_num="+this.page+"&search="+keyword.replaceAll(" ","+"),header);
        Gson gson = new Gson();
        this.data = gson.fromJson(httpGet.getText(), DataJson.class);
        return this.data;
    }
}


