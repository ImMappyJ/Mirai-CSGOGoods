package cc.funworld.csgo.goods;


import cc.funworld.csgo.goods.config.PluginConfig;
import net.mamoe.mirai.console.command.CommandManager;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

import java.io.IOException;

public final class CSGOGoods extends JavaPlugin {
    public static final CSGOGoods INSTANCE = new CSGOGoods();

    private CSGOGoods() {
        super(new JvmPluginDescriptionBuilder("cc.funworld.csgogoods", "0.1.0")
                .name("CSGOGoods")
                .author("MappyJ")
                .build());
    }

    @Override
    public void onEnable() {
        try {
            PluginConfig.load();
            INSTANCE.getLogger().info("配置加载成功");
        } catch (IOException e) {
            INSTANCE.getLogger().warning("配置加载失败");
        }
        CommandManager.INSTANCE.registerCommand(BuffCommandExecutor.executor,true);
        getLogger().info("Plugin loaded!");
    }
}

