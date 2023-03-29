package io.hitsongbot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import javax.annotation.Nonnull;

public class CalculatorCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@Nonnull SlashCommandInteractionEvent event) {
        if (event.getName().equals("calculate")) {
            OptionMapping math_operator = event.getOption("math_operator");
            OptionMapping number1 = event.getOption("number1");
            OptionMapping number2 = event.getOption("number2");

            String operator;
            double result = 0;

            if (math_operator != null) {
                operator = math_operator.getAsString();
            } else {
                event.reply("No operator was provided.").queue();
                return;
            }

            if (number1 != null && number2 != null) {
                switch (operator) {
                    case "+" -> result = number1.getAsDouble() + number2.getAsDouble();
                    case "-" -> result = number1.getAsDouble() - number2.getAsDouble();
                    case "*" -> result = number1.getAsDouble() * number2.getAsDouble();
                    case "/" -> result = number1.getAsDouble() / number2.getAsDouble();
                }
            } else {
                event.reply("No numbers were provided.").queue();
                return;
            }

            event.reply("```" + result + "```").queue();
        }
    }
}
