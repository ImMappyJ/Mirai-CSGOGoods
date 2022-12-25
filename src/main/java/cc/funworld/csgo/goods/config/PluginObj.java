package cc.funworld.csgo.goods.config;

import java.util.ArrayList;

public class PluginObj {
    public String getBuff_cookie() {
        return buff_cookie;
    }

    public void setBuff_cookie(String buff_cookie) {
        this.buff_cookie = buff_cookie;
    }

    private String buff_cookie = "none";

    public ArrayList<Integer> getAdmin_qq() {
        return admin_qq;
    }

    public void setAdmin_qq(ArrayList<Integer> admin_qq) {
        this.admin_qq = admin_qq;
    }

    private ArrayList<Integer> admin_qq = new ArrayList<Integer>(){
        {add(10001);}
    };
}
