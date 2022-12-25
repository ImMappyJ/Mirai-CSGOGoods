package cc.funworld.csgo.goods.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PluginConfig {
    private static final String fileName = "csgoods.json";
    private static PluginObj obj = new PluginObj();
    public static void load() throws IOException {
        File file = new File(fileName);
        if(!file.exists()){
            file.createNewFile();
            OutputStreamWriter writer = new OutputStreamWriter(Files.newOutputStream(Paths.get(fileName)),Charset.defaultCharset());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(obj));
            writer.close();
        }else{
            BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(fileName)),Charset.defaultCharset()));
            String temp;
            StringBuilder builder = new StringBuilder();
            while((temp = reader.readLine()) != null){
                builder.append(temp);
            }
            Gson gson = new Gson();

            obj = gson.fromJson(builder.toString(),PluginObj.class);
            reader.close();
        }
    }

    public static void save() throws IOException {
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
            file.createNewFile();
            OutputStreamWriter writer = new OutputStreamWriter(Files.newOutputStream(Paths.get(fileName)),Charset.defaultCharset());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(obj));
            writer.close();
        }
    }

    public static String getBuff_cookie(){
        return obj.getBuff_cookie();
    }
    public static ArrayList<Integer> getAdmin_QQ(){
        return obj.getAdmin_qq();
    }
    public static void addAdmin_QQ(Integer qq){
        obj.getAdmin_qq().add(qq);
    }
    public static void delAdmin_QQ(Integer qq){
        obj.getAdmin_qq().remove(qq);
    }
}
