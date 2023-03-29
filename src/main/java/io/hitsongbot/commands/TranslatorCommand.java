package io.hitsongbot.commands;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TranslatorCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("translate")) {
            String language = Objects.requireNonNull(event.getOption("language")).getAsString();
            String message = Objects.requireNonNull(event.getOption("message")).getAsString();

            try {
                String translatedMessage = translateMessage(language, message);
                event.reply(translatedMessage).queue();
            } catch (Exception e) {
                event.reply("An error occurred during translation.").queue();
                e.printStackTrace();
            }
        }
    }

    private String translateMessage(String language, String message) {
        Translate translate = TranslateOptions.getDefaultInstance().toBuilder().setApiKey("API_KEY").build().getService();
        Translation translation = translate.translate(message, Translate.TranslateOption.targetLanguage(language));

        return translation.getTranslatedText();
    }
}
