package io.hitsongbot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Calculator extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (command[0].equalsIgnoreCase("!calculate")) {
            if (command.length == 1) {
                event.getChannel().sendMessage("```!calculate [number1] [ + | - | * | / ] [number2]```").queue();
            } else {
                float number1 = Float.parseFloat(command[1]);
                float number2 = Float.parseFloat(command[3]);

                if (command[2].equalsIgnoreCase("+")) {
                    event.getChannel().sendMessage("```" + (number1 + number2) + "```").queue();
                } else if (command[2].equalsIgnoreCase("-")) {
                    event.getChannel().sendMessage("```" + (number1 - number2) + "```").queue();
                } else if (command[2].equalsIgnoreCase("*")) {
                    event.getChannel().sendMessage("```" + (number1 * number2) + "```").queue();
                } else if (command[2].equalsIgnoreCase("/")) {
                    event.getChannel().sendMessage("```" + (number1 / number2) + "```").queue();
                }
            }
        }

    }
}
