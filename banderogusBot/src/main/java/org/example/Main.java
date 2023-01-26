package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendDice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.games.Animation;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main extends TelegramLongPollingBot {
    private Map<Long, Integer> levels = new HashMap<>();


    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Main());
        System.out.println("Hello world!");
    }

    @Override
    public String getBotUsername() {
        return "Asdfdsdf_bot";
    }

    @Override
    public String getBotToken() {
        return "752275450:AAHphz6nhxLOBnN6nbiBVQnHoB3zFP330mM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);

        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            //Send image lvl 1
            sendImage("level-1", chatId);

            //Send message
            SendMessage message = createMessage("Ґа-ґа-ґа!\n" +
                    "Вітаємо у боті біолабораторії «Батько наш Бандера».\n" +
                    "\n" +
                    "Ти отримуєш гусака №71\n" +
                    "\n" +
                    "Цей бот ми створили для того, щоб твій гусак прокачався з рівня звичайної свійської худоби до рівня біологічної зброї, здатної нищити ворога. \n" +
                    "\n" +
                    "Щоб звичайний гусак перетворився на бандерогусака, тобі необхідно:\n" +
                    "✔️виконувати завдання\n" +
                    "✔️переходити на наступні рівні\n" +
                    "✔️заробити достатню кількість монет, щоб придбати Джавеліну і зробити свєрхтра-та-та.\n" +
                    "\n" +
                    "*Гусак звичайний.* Стартовий рівень.\n" +
                    "Бонус: 5 монет.\n" +
                    "Обери завдання, щоб перейти на наступний рівень\n");
            message.setChatId(chatId);

            List<String> buttons = Arrays.asList(
                    "Сплести маскувальну сітку (+15 монет)",
                    "Зібрати кошти патріотичними піснями (+15 монет)",
                    "Вступити в Міністерство Мемів України (+15 монет)",
                    "Запустити волонтерську акцію (+15 монет)",
                    "Вступити до лав тероборони (+15 монет)"
            );
            buttons = getRandom3(buttons);

            attachButtons(message, Map.of(
                    buttons.get(0), "level-1-task",
                    buttons.get(1), "level-1-task",
                    buttons.get(2), "level-1-task"
            ));
            sendApiMethodAsync(message);

        }
//
        if (update.hasCallbackQuery())
            if (update.getCallbackQuery().getData().equals("level-1-task") && getLevel(chatId)== 1){
                //increase level
                setLevels(chatId, 2);
                //Send image level-2
                sendImage("level-2", chatId);
                //Send message
                SendMessage message = createMessage("*Вітаємо на другому рівні! Твій гусак - біогусак.*\n" +
                        "Баланс: 20 монет. \n" +
                        "Обери завдання, щоб перейти на наступний рівень\n");
                message.setChatId(chatId);

                List<String> buttons = Arrays.asList(
                        "Зібрати комарів для нової біологічної зброї (+15 монет)",
                        "Пройти курс молодого бійця (+15 монет)",
                        "Задонатити на ЗСУ (+15 монет)",
                        "Збити дрона банкою огірків (+15 монет)",
                        "Зробити запаси коктейлів Молотова (+15 монет)"
                );
                buttons = getRandom3(buttons);

                attachButtons(message, Map.of(
                        buttons.get(0), "level-2-task",
                        buttons.get(1), "level-2-task",
                        buttons.get(2), "level-2-task"
                ));
                sendApiMethodAsync(message);


            }
        if (update.hasCallbackQuery())
            if (update.getCallbackQuery().getData().equals("level-2-task") && getLevel(chatId)== 2){
                //increase level
                setLevels(chatId, 3);
                //Send image level-2
                sendImage("level-3", chatId);
                //Send message
                SendMessage message = createMessage("*Вітаємо на третьому рівні! Твій гусак - бандеростажер.*\n" +
                        "Баланс: 35 монет. \n" +
                        "Обери завдання, щоб перейти на наступний рівень");
                message.setChatId(chatId);
                List<String> buttons = Arrays.asList("Злітати на тестовий рейд по чотирьох позиціях (+15 монет)",
                        "Відвезти гуманітарку на передок (+15 монет)",
                        "Знайти зрадника та здати в СБУ (+15 монет)",
                        "Навести арту на орків (+15 монет)",
                        "Притягнути танк трактором (+15 монет)"
                );
                buttons = getRandom3(buttons);
                attachButtons(message, Map.of(
                        buttons.get(0), "level-3-task",
                        buttons.get(1), "level-3-task",
                        buttons.get(2), "level-3-task"
                ));
                sendApiMethodAsync(message);


            }
        if (update.hasCallbackQuery())
            if (update.getCallbackQuery().getData().equals("level-3-task") && getLevel(chatId)== 3){
                //increase level
                setLevels(chatId, 4);
                //Send image level-2
                sendImage("level-4", chatId);
                //Send message
                SendMessage message = createMessage("*Вітаємо на останньому рівні! Твій гусак - готова біологічна зброя - бандерогусак.*\n" +
                        "Баланс: 50 монет. \n" +
                        "Тепер ти можеш придбати Джавелін і глушити чмонь\n");
                message.setChatId(chatId);

                attachButtons(message, Map.of(
                        "Купити Джавелін (50 монет)", "level-4-task"));
                sendApiMethodAsync(message);

            }
        if (update.hasCallbackQuery())
            if (update.getCallbackQuery().getData().equals("level-4-task") && getLevel(chatId)== 4){
                //increase level
                setLevels(chatId, 5);
                //Send image final
                sendImage("final", chatId);
                //Send message
                SendMessage message = createMessage("*Джавелін твій. Повний вперед!*");
                message.setChatId(chatId);

                sendApiMethodAsync(message);

            }


    }

    public  Long getChatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getFrom().getId();
        }

        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }

    public SendMessage createMessage(String text){
        SendMessage message = new SendMessage();
        message.setText(new String(text.getBytes(), StandardCharsets.UTF_8));
        message.setParseMode("markdown");
        return message;
    }

    public void attachButtons(SendMessage message, Map<String, String> buttons){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        for (String buttonName : buttons.keySet()) {
            String buttonValue = buttons.get(buttonName);

            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText((new String(buttonName.getBytes(), StandardCharsets.UTF_8)));
            button.setCallbackData(buttonValue);

            keyboard.add(Arrays.asList(button));

        }
        markup.setKeyboard(keyboard);
        message.setReplyMarkup(markup);
    }

    public void sendImage(String name, Long chatId){
        SendAnimation animation = new SendAnimation();

        InputFile inputFile = new InputFile();
        inputFile.setMedia(new File("images/" + name + ".gif"));


        animation.setAnimation(inputFile);
        animation.setChatId(chatId);

        executeAsync(animation);
    }
    public int getLevel(Long chatId){
        return levels.getOrDefault(chatId, 1);
        }

    public void setLevels(Long chatId, int level){
        levels.put(chatId, level);

    }

    public List<String> getRandom3(List<String> variants){
        ArrayList<String> copy = new ArrayList<>(variants);
        Collections.shuffle(copy);
        return copy.subList(0,3);

    }
}