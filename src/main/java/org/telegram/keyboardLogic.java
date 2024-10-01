package org.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class keyboardLogic {

    public SendMessage keyboards(SendMessage message, int key1,int key2){

        if (key1 == 1) {
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

            // Создание и добавление кнопок

            List<InlineKeyboardButton> row = new ArrayList<>();

            row.add(new InlineKeyboardButton().builder().text("ИЕНИМ").callbackData("ИЕНИМ").build());
            row.add(new InlineKeyboardButton().builder().text("РТФ").callbackData("РТФ").build());
            row.add(new InlineKeyboardButton().builder().text("ХТИ").callbackData("ХТИ").build());
            keyboard.add(row);

            markup.setKeyboard(keyboard);
            message.setReplyMarkup(markup);
        }
        if (key2 == 1) {
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

            // Создание и добавление кнопок

            List<InlineKeyboardButton> row = new ArrayList<>();

            row.add(new InlineKeyboardButton().builder().text("КН").callbackData("1").build());
            row.add(new InlineKeyboardButton().builder().text("МО").callbackData("2").build());
            row.add(new InlineKeyboardButton().builder().text("ФИИТ").callbackData("3").build());
            row.add(new InlineKeyboardButton().builder().text("МИМ").callbackData("4").build());
            row.add(new InlineKeyboardButton().builder().text("КБ").callbackData("5").build());

            keyboard.add(row);

            markup.setKeyboard(keyboard);
            message.setReplyMarkup(markup);
        }

        if (key2 == 2) {
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

            // Создание и добавление кнопок

            List<InlineKeyboardButton> row = new ArrayList<>();

            row.add(new InlineKeyboardButton().builder().text("ИВТ").callbackData("6").build());
            row.add(new InlineKeyboardButton().builder().text("ПИ").callbackData("7").build());
            row.add(new InlineKeyboardButton().builder().text("АИИ").callbackData("8").build());
            row.add(new InlineKeyboardButton().builder().text("БКС").callbackData("9").build());
            row.add(new InlineKeyboardButton().builder().text("РДТ").callbackData("10").build());

            keyboard.add(row);

            markup.setKeyboard(keyboard);
            message.setReplyMarkup(markup);
        }

        if (key2 == 3) {
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

            // Создание и добавление кнопок

            List<InlineKeyboardButton> row = new ArrayList<>();

            row.add(new InlineKeyboardButton().builder().text("БТХ").callbackData("11").build());
            row.add(new InlineKeyboardButton().builder().text("ХТП").callbackData("12").build());
            row.add(new InlineKeyboardButton().builder().text("ФАРМ").callbackData("13").build());

            keyboard.add(row);

            markup.setKeyboard(keyboard);
            message.setReplyMarkup(markup);
        }
        return message;
    }
}
