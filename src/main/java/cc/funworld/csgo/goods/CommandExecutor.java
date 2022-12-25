package cc.funworld.csgo.goods;

import cc.funworld.csgo.goods.config.PluginConfig;
import net.mamoe.mirai.console.command.CommandContext;
import net.mamoe.mirai.console.command.ConsoleCommandSender;
import net.mamoe.mirai.console.command.UserCommandSender;
import net.mamoe.mirai.console.command.java.JCompositeCommand;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.PlainText;
import net.mamoe.mirai.message.data.QuoteReply;

import java.io.IOException;
import java.util.Objects;

public class CommandExecutor extends JCompositeCommand {
    public static final CommandExecutor executor = new CommandExecutor();
    public CommandExecutor() {
        super(CSGOGoods.INSTANCE, "csgoods","csgood");
    }

    @SubCommand("reload")//控制台&配置中管理员可用
    public void reload(CommandContext context){
        if(context.getSender() instanceof ConsoleCommandSender || PluginConfig.getAdmin_QQ().contains((int) Objects.requireNonNull(context.getSender().getUser()).getId())){
            try {
                PluginConfig.load();
                CSGOGoods.INSTANCE.getLogger().info("配置加载成功");
                CSGOGoods.INSTANCE.getLogger().info("管理QQ:");
                for(Integer num:PluginConfig.getAdmin_QQ()){
                    CSGOGoods.INSTANCE.getLogger().info(num+"\n");
                }
                if(context.getSender() instanceof UserCommandSender){
                    QuoteReply reply = new QuoteReply(context.getOriginalMessage());
                    MessageChainBuilder builder = new MessageChainBuilder();
                    builder.append(reply).append(new PlainText("配置重载成功"));
                    Objects.requireNonNull(context.getSender().getSubject()).sendMessage(builder.build());
                }
            } catch (IOException e) {
                if(context.getSender() instanceof UserCommandSender){
                    QuoteReply reply = new QuoteReply(context.getOriginalMessage());
                    MessageChainBuilder builder = new MessageChainBuilder();
                    builder.append(reply).append(new PlainText("配置重载失败"));
                    Objects.requireNonNull(context.getSender().getSubject()).sendMessage(builder.build());
                }
                CSGOGoods.INSTANCE.getLogger().warning("配置加载失败");
            }
        }
    }

    @SubCommand("admin")//控制台配置管理员
    public void adminManager(CommandContext context,String arg1,int arg2) throws IOException {
        if(context.getSender() instanceof ConsoleCommandSender){
            switch(arg1){
                case "add":
                    PluginConfig.addAdmin_QQ(arg2);
                    CSGOGoods.INSTANCE.getLogger().info("加入成功:"+arg2);
                    break;
                case "del":
                    if(PluginConfig.getAdmin_QQ().contains(arg2)){
                        PluginConfig.delAdmin_QQ(arg2);
                        CSGOGoods.INSTANCE.getLogger().info("删除成功:"+arg2);
                        break;
                    }else{
                        CSGOGoods.INSTANCE.getLogger().warning("未找到此人");
                    }
            }
            PluginConfig.save();
        }
    }
}
