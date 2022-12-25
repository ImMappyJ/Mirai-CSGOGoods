package cc.funworld.csgo.goods;

import cc.funworld.csgo.goods.util.Buff_Search;
import cc.funworld.csgo.goods.util.buff.DataJson;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.console.command.CommandContext;
import net.mamoe.mirai.console.command.java.JCompositeCommand;
import net.mamoe.mirai.message.data.ForwardMessageBuilder;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.PlainText;
import net.mamoe.mirai.message.data.QuoteReply;

import java.util.Objects;
public class BuffCommandExecutor extends JCompositeCommand {
    public static final BuffCommandExecutor executor = new BuffCommandExecutor();
    public BuffCommandExecutor() {
        super(CSGOGoods.INSTANCE, "buff");
        this.setDescription("BUFF价格查询");
    }

    @SubCommand("search")
    public void searchWeapon(CommandContext context, String key, String page){
        CSGOGoods.INSTANCE.getLogger().info("Searching for "+key+"!");
        try {
            Buff_Search search = new Buff_Search(key,page);
            DataJson dataJson = search.getData();
            DataJson.Data data = dataJson.getData();
            ForwardMessageBuilder builder = new ForwardMessageBuilder(Objects.requireNonNull(context.getSender().getSubject()));
            Bot bot = context.getSender().getBot();
            builder.add(Objects.requireNonNull(bot).getId(),bot.getNick(),new PlainText("关键词:"+key+"\n"+"当前页数:"+data.getPage_num()+"\n"+"总页数:"+data.getTotal_page()+" 结果总数:"+data.getTotal_count()));
            for(DataJson.Items mem:data.getItems()){
                builder.add(bot.getId(),mem.getName(),new PlainText(mem.getName()+"\n"+"ID:"+mem.getId()+"\n"+"在售:"+mem.getSell_num()+"件"+" "+"求购:"+mem.getBuy_num()+"件"+"\n"
                +"参考价格:"+mem.getQuick_price()+"RMB"+"\n"+"出售最低价:"+mem.getSell_min_price()+"RMB"+"\n"+"求购最高价:"+mem.getBuy_max_price()+"RMB"));
            }
            Objects.requireNonNull(context.getSender().getSubject()).sendMessage(builder.build());
        } catch (Exception e) {
            QuoteReply reply = new QuoteReply(context.getOriginalMessage());
            MessageChainBuilder builder = new MessageChainBuilder();
            builder.append(reply).append("查询失败！登录失效！");
            Objects.requireNonNull(context.getSender().getSubject()).sendMessage(builder.build());
            throw new RuntimeException(e);
        }
    }
    @SubCommand("search")
    public void searchWeaponNoPage(CommandContext context, String key){
        CSGOGoods.INSTANCE.getLogger().info("Searching for "+key+"!");
        try {
            Buff_Search search = new Buff_Search(key);
            DataJson dataJson = search.getData();
            DataJson.Data data = dataJson.getData();
            ForwardMessageBuilder builder = new ForwardMessageBuilder(Objects.requireNonNull(context.getSender().getSubject()));
            Bot bot = context.getSender().getBot();
            assert bot != null;
            builder.add(bot.getId(),bot.getNick(),new PlainText("关键词:"+key+"\n"+"当前页数:"+data.getPage_num()+"\n"+"总页数:"+data.getTotal_page()+" 结果总数:"+data.getTotal_count()));
            for(DataJson.Items mem:data.getItems()){
                builder.add(bot.getId(),mem.getName(),new PlainText(mem.getName()+"\n"+"ID:"+mem.getId()+"\n"+"在售:"+mem.getSell_num()+"件"+" "+"求购:"+mem.getBuy_num()+"件"+"\n"
                        +"参考价格:"+mem.getQuick_price()+"RMB"+"\n"+"出售最低价:"+mem.getSell_min_price()+"RMB"+"\n"+"求购最高价:"+mem.getBuy_max_price()+"RMB"));
            }
            context.getSender().getSubject().sendMessage(builder.build());
        } catch (Exception e) {
            QuoteReply reply = new QuoteReply(context.getOriginalMessage());
            MessageChainBuilder builder = new MessageChainBuilder();
            builder.append(reply).append("查询失败！登录失效！");
            Objects.requireNonNull(context.getSender().getSubject()).sendMessage(builder.build());
            throw new RuntimeException(e);
        }
    }
}