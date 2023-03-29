package io.hitsongbot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;
import java.util.Objects;

public class CalculatorCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@Nonnull SlashCommandInteractionEvent event) {
        if (event.getName().equals("calculate")) {
            String operator = Objects.requireNonNull(event.getOption("operator")).getAsString();
            double number1 = Objects.requireNonNull(event.getOption("number1")).getAsDouble();
            double number2 = Objects.requireNonNull(event.getOption("number2")).getAsDouble();

            switch (operator) {
                case "+" -> event.reply("```" + (number1 + number2) + "```").queue();
                case "-" -> event.reply("```" + (number1 - number2) + "```").queue();
                case "*" -> event.reply("```" + (number1 * number2) + "```").queue();
                case "/" -> event.reply("```" + (number1 / number2) + "```").queue();
            }
        }
    }
}
