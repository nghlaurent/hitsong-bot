package io.hitsongbot.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class PingEvent extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("ping")) {
            if (!Objects.requireNonNull(event.getMember()).getUser().isBot()) {
                event.getChannel().sendMessage("pong").queue();
            }
        }
    }
}
