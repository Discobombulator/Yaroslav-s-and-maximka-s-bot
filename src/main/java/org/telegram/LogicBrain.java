package org.telegram;

/**
 * класс логики бота
 */
public class LogicBrain {

    /**
     *
     * метод, который возвращает ответ бота
     */
    private EmailSender emailSender;
    // Метод для установки EmailSender
    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public String handleEmailInput(String email) {
        // Здесь вы можете добавить проверку формата email и отправку сообщения
        // Сбрасываем состояние после обработки

        if(emailSender.isValidEmail(email)){
            return "Почта указана корректно, напишите ваш вопрос";
        }
        return "Адрес электронной почты был указан неправильно отправьте его ещё раз";

    }
    public void sendMail(String mailMessage, String question){
        emailSender.sendEmail(emailSender.getUsername(), "Вопрос от абитуриента " + mailMessage, question);

    }

    private String questionCommandReceived() {
        String answer = "Пожалуйста, отправьте свою почту";
        // Замените на адрес получателя и тему/текст сообщения
        return answer;
    }
    private String defaultCommandReceived() {
        String answer = "Привет, этот бот может помочь тебе понять куда ты хочешь поступить," +
                " пожалуйста пользуйся кнопками. Если у тебя остались вопросы, можешь воспользоваться командой /question." +
                " Если хотите начать работу напишите /work";
        return answer;
    }

    private String workCommandReceived() {
        String answer = "Вот все институты у которых ты можешь посмотреть факультеты:";
        return answer;
    }
    private String inst1CommandReceived() {
        String answer = "Вот все факультеты которые есть в институте ИЕНИМ:";
        return answer;
    }
    private String inst2CommandReceived() {
        String answer = "Вот все факультеты которые есть в институте РТФ:";
        return answer;
    }
    private String inst3CommandReceived() {
        String answer = "Вот все факультеты которые есть в институте ХТИ:";
        return answer;
    }

    /**
     * метод, который реализует основную логику работы бота
     * @param messageText сообщение от пользователя
     */
    public String slogic(String messageText){
        switch (messageText) {
            case "/start":
                return defaultCommandReceived();
            case "/help":
                return defaultCommandReceived();
            case "/question":
                return questionCommandReceived();
            case "/work":
                return workCommandReceived();
            case "ИЕНИМ":
                return inst1CommandReceived();
            case "РТФ":
                return inst2CommandReceived();
            case "ХТИ":
                return inst3CommandReceived();
            default:
                return defaultCommandReceived();
        }
    }
}
