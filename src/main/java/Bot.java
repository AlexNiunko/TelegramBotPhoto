import jdk.internal.util.xml.impl.Input;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "AlexPhoto1_Bot";
    }

    @Override
    public String getBotToken() {
        return "5444759239:AAEDyziwd4ZFtrSTv85p5y57UEJWFGaP2qg";
    }
//    Arren - BQACAgIAAxkBAAOLYwT6OkLINn6wD7dBeazq3-xZ9NQAAp0cAAKdlyhIB7ipIK6-sncpBA
//    Barratheon -BQACAgIAAxkBAAONYwT6YmcTV5d5Zg_vdVtcE5D2WFkAAqEcAAKdlyhI6Hoy1bfisM0pBA
//    Greyjoi - BQACAgIAAxkBAAOPYwT6hS76QcXFT0UJ0UOonQ6rpYEAAqQcAAKdlyhIm9flHLFVFC4pBA
//    Lannister - BQACAgIAAxkBAAORYwT6vrcmmXPcth0vvBQUSuY8Ux4AAqYcAAKdlyhIOHRbtZNz2cMpBA
//    Stark - BQACAgIAAxkBAAOTYwT62eX61XyR0uNkOJNII06Ht8IAAqgcAAKdlyhIynCarxtjAsspBA
//    Targarien - BQACAgIAAxkBAAOVYwT69Brt6YUKlA_tSL9f5AFtPHcAAqkcAAKdlyhITz02h9DCo7ApBA
    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());

        KeyboardRow keyboardRow1=new KeyboardRow();
        keyboardRow1.add("Targaryen");
        keyboardRow1.add("Baratheon");
        keyboardRow1.add("Lannister");

        KeyboardRow keyboardRow2=new KeyboardRow();

        keyboardRow2.add("Arryn");
        keyboardRow2.add("Stark");
        keyboardRow2.add("Greyjoy");

        List<KeyboardRow>list=new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);

        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        SendDocument sendDocument=new SendDocument();
        sendDocument.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile=new InputFile();

        switch (update.getMessage().getText()){
            case"Targaryen":
                inputFile.setMedia("BQACAgIAAxkBAAOVYwT69Brt6YUKlA_tSL9f5AFtPHcAAqkcAAKdlyhITz02h9DCo7ApBA");
                break;
            case"Lannister":
                inputFile.setMedia("BQACAgIAAxkBAAORYwT6vrcmmXPcth0vvBQUSuY8Ux4AAqYcAAKdlyhIOHRbtZNz2cMpBA");
                break;
            case"Baratheon":
                inputFile.setMedia("BQACAgIAAxkBAAONYwT6YmcTV5d5Zg_vdVtcE5D2WFkAAqEcAAKdlyhI6Hoy1bfisM0pBA");
                break;
            case"Arryn":
                inputFile.setMedia("BQACAgIAAxkBAAOLYwT6OkLINn6wD7dBeazq3-xZ9NQAAp0cAAKdlyhIB7ipIK6-sncpBA");
                break;
            case"Stark":
                inputFile.setMedia("BQACAgIAAxkBAAOTYwT62eX61XyR0uNkOJNII06Ht8IAAqgcAAKdlyhIynCarxtjAsspBA");
                break;
            case"Greyjoy":
                inputFile.setMedia("BQACAgIAAxkBAAOPYwT6hS76QcXFT0UJ0UOonQ6rpYEAAqQcAAKdlyhIm9flHLFVFC4pBA");
                break;
        }
        sendDocument.setDocument(inputFile);
        try {
            execute(sendDocument);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
