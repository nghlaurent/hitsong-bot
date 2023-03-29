package io.hitsongbot;

import io.hitsongbot.commands.*;
import io.hitsongbot.events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Hitsong {
    public static void main(String[] args) {
        JDA jda = JDABuilder.createLight("", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.watching("YouTube"))
                .build();

        jda.addEventListener(new PingEvent());
        jda.addEventListener(new Calculator());
    }
}
