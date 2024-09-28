package org.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Console;
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
    public int testkey(String messageText){
        int key = 0 ;
        if(messageText.equals("/work")) {
            key = 1;
        }
        return key;
    }
    public int testkey2(String messageText){
        int key2 = 0 ;
        if(messageText.equals("ИЕНИМ")) {
            key2 = 1;
        }
        if(messageText.equals("РТФ")) {
            key2 = 2;
        }
        if(messageText.equals("ХТИ")) {
            key2 = 3;
        }
        return key2;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasCallbackQuery() && update.getCallbackQuery() != null) {
            String data = update.getCallbackQuery().getData();
            sendMessage( update.getUpdateId(), data, testkey(data), testkey2(data));

        }

        if (update.hasMessage() && update.getMessage() != null) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String answer = botLogic.slogic(messageText);
            sendMessage(chatId, answer, testkey(messageText), testkey2(messageText));
        }
    }

    void sendMessage(long chatId, String textToSend, int key, int key2) {


        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        System.out.println(textToSend);
        System.out.println(key);
        System.out.println(key2);
        if (key == 1) {
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

            row.add(new InlineKeyboardButton().builder().text("КН").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("МО").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("ФИИТ").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("МИМ").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("КБ").callbackData("error_msg_text1").build());

            keyboard.add(row);

            markup.setKeyboard(keyboard);
            message.setReplyMarkup(markup);
        }
        if (key2 == 2) {
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

            // Создание и добавление кнопок

            List<InlineKeyboardButton> row = new ArrayList<>();

            row.add(new InlineKeyboardButton().builder().text("ИВТ").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("ПИ").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("АИИ").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("БКС").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("РДТ").callbackData("error_msg_text1").build());

            keyboard.add(row);

            markup.setKeyboard(keyboard);
            message.setReplyMarkup(markup);
        }
        if (key2 == 3) {
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

            // Создание и добавление кнопок

            List<InlineKeyboardButton> row = new ArrayList<>();

            row.add(new InlineKeyboardButton().builder().text("БТХ").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("ХТП").callbackData("error_msg_text1").build());
            row.add(new InlineKeyboardButton().builder().text("ФАРМ").callbackData("error_msg_text1").build());

            keyboard.add(row);

            markup.setKeyboard(keyboard);
            message.setReplyMarkup(markup);
        }

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

