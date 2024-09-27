package org.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Представляет собой Telegram-бота, который наследует класс TelegramLongPollingBot.
 * Этот бот может отвечать на простые команды, такие как /start и /help,
 * а также повторять текстовые сообщения, отправленные ему.
 */
public class TelegramBot extends TelegramLongPollingBot {
    private final String botName;
    private final String botToken;
    private final LogicBrain botLogic;
    public TelegramBot(String name, String token, LogicBrain logic) {
        botName = name;
        botToken = token;
        botLogic = logic;
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String answer = botLogic.slogic(messageText);
            sendMessage(chatId, answer);
        }
    }
    void sendMessage(long chatId, String textToSend) {
        int key = 0;
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        // Создание и добавление кнопок

        List<InlineKeyboardButton> row = new ArrayList<>();

        row.add(new InlineKeyboardButton().builder().text("ИЕНИМ").callbackData("error_msg_text1").build());
        row.add(new InlineKeyboardButton().builder().text("РТФ").callbackData("error_msg_text2").build());
        row.add(new InlineKeyboardButton().builder().text("ХТИ").callbackData("error_msg_text3").build());
        keyboard.add(row);

        markup.setKeyboard(keyboard);
        message.setReplyMarkup(markup);


        try {
            execute(message);
        } catch (TelegramApiException e) {
            // Обработка исключения (опционально: логирование)
        }
    }


    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}

