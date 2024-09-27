package org.telegram;

/**
 * класс логики бота
 */
public class LogicBrain {

    /**
     * метод, который возвращает ответ бота
     */
    private String startCommandReceived() {
        String answer = "Привет, этот бот может помочь тебе понять куда ты хочешь поступить," +
                " пожалуйста пользуйся кнопками. Если у тебя остались вопросы, можешь воспользоваться командой /question ";
        return answer;
    }

    private String questionCommandReceived() {
        String answer = "This Function is in development";
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
            case "/question":
                return questionCommandReceived();
            default:
                return "круто";
        }
    }
}
