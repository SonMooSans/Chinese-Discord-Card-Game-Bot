
import commands.CommandsBuilder;
import commands.CommandEvents;
import listener.ButtonListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import javax.security.auth.login.LoginException;

public class StartUpThread extends ListenerAdapter
{
    public static final CommandsBuilder builder = new CommandsBuilder(){{
        cmd("join", "Join the game", CommandEvents::onJoin);

        cmd("start", "Start the game", CommandEvents::onStartGame);

        cmd("use", "Use a card", CommandEvents::onDoActionMenu)
                .op(OptionType.INTEGER,  "card_id", "Card to use", CommandEvents::onDoAction);

        cmd("drop", "Drop a card", CommandEvents::onDropCard);

        cmd("peek", "see all of your cards", CommandEvents::onPeekCard);

        cmd("status", "See players status", CommandEvents::onGetStatus);

        cmd("rules", "See game rules", CommandEvents::onGetRules);

        cmd("endgame", "Force end the game", CommandEvents::onForceEnd);

        servers("684766026776576052", "676806725105352704");
    }};

    private static final String Token = "OTA3OTU1NzgxOTcyOTE4Mjgz.YYuttw.13wzHmzqjjUZPoeGE6IiZ8DI8zs";

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault(Token)
                .setActivity(Activity.playing(":P"))
                .build();

        jda.awaitReady();
        builder.build(jda);
        jda.addEventListener(new ButtonListener());
    }
}
