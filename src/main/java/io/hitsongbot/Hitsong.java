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
        JDA jda = JDABuilder.createLight("TOKEN", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.watching("YouTube"))
                .addEventListeners(new CalculatorCommand())
                .addEventListeners(new TranslatorCommand())
                .build().awaitReady();

        jda.upsertCommand("calculate", "Can do only addition, subtraction, multiplication and division mathematical calculations.")
                .addOptions(
                        new OptionData(OptionType.NUMBER, "number1", "the first number", true),
                        new OptionData(OptionType.STRING, "operator", "+ | - | * | /", true),
                        new OptionData(OptionType.NUMBER, "number2", "the second number", true)
                )
                .queue();

        jda.upsertCommand("translate", "Can do only addition, subtraction, multiplication and division mathematical calculations.")
                .addOptions(
                        new OptionData(OptionType.STRING, "language", "en | es | fr | de | it | ja | ko", true),
                        new OptionData(OptionType.STRING, "message", "the message", true)
                )
                .queue();
    }
}
