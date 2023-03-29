package io.hitsongbot;

import io.hitsongbot.commands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Hitsong {
    public static void main(String[] args) throws InterruptedException {
        JDA jda = JDABuilder.createLight("", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.watching("YouTube"))
                .addEventListeners(new CalculatorCommand())
                .build().awaitReady();

        jda.upsertCommand("calculate", "Can do only addition, subtraction, multiplication and division mathematical calculations.")
                .addOptions(
                        new OptionData(OptionType.NUMBER, "number1", "the first number", true),
                        new OptionData(OptionType.STRING, "math_operator", "+ | - | * | /", true),
                        new OptionData(OptionType.NUMBER, "number2", "the second number", true)
                )
                .queue();
    }
}
