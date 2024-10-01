package org.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
            String answer = botLogic.slogic(data);
            System.out.println(data + " 2");
            System.out.println(answer);
            sendMessage( update.getCallbackQuery().getFrom().getId(), data, 2, testkey2(data), answer);

        }

        if (update.hasMessage() && update.getMessage() != null) {
            String messageText = update.getMessage().getText();
            String answer = botLogic.slogic(messageText);
            System.out.println(messageText + " 1");
            System.out.println(answer);
            sendMessage(update.getMessage().getChatId(), answer, testkey(messageText), testkey2(messageText),messageText);
        }
    }

    void sendMessage(long chatId, String textToSend, int key, int key2, String data) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        System.out.println(data);
        dataInfoTo infoObj = new dataInfoTo();
        textToSend = infoObj.takeInfo(textToSend);
        message.setText(textToSend);

        keyboardLogic keyboardLogicObj = new keyboardLogic();
        keyboardLogicObj.keyboards(message, key, key2);


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

