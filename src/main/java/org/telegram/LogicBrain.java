package org.telegram;

/**
 * класс логики бота
 */
public class LogicBrain {

    /**
     * метод, который возвращает ответ бота
     */
    private String startCommandReceived() {
        String answer = "Привет, этот бот может помочь тебе понять куда ты хочешь поступить.";
        return answer;
    }

    private String defaultCommandReceived() {
        String answer = "Привет, этот бот может помочь тебе понять куда ты хочешь поступить," +
                " пожалуйста пользуйся кнопками. Если у тебя остались вопросы, можешь воспользоваться командой /question." +
                " Вот все институты у которых ты можешь посмотреть факультеты";
        return answer;
    }

    /**
     * метод, который реализует основную логику работы бота
     * @param messageText сообщение от пользователя
     */
    public String slogic(String messageText){
        switch (messageText) {
            case "/start":
                return startCommandReceived();
            case "/help":
                return startCommandReceived();
            default:
                return defaultCommandReceived();
        }
    }
}
