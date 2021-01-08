package ru.progwards.java1.lessons.telebot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.progwards.java1.lessons.telebot.ProgwardsTelegramBot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.MalformedURLException;

public class Telebot extends ProgwardsTelegramBot {
    private final String menu = "\n Есть: маргарита \n Есть:  пеперони";

    @Override
    public String processMessage(String text) {
        checkTags(text);

        if (foundCount() == 1) {
            if (checkLastFound("привет"))
                return "Здарова " + returnClientName() + "\n Решил пожрать? " + menu;
            if (checkLastFound("конец"))
                return returnClientName() + "Рахмет за заказ.";
            if (checkLastFound("дурак"))
                return returnClientName() + " ты на себя-то посмотри, умник. С машиной общаешься. Ща пришлю к тебе терминатора с дилдой вместо дробовика, тогда увидим, кто из нас это самое.";
            if (checkLastFound("заказ"))
                return "Итого: " + myOrder();

            return "Отлично. Кидаю в заказ: \n " + answerBot() + "\n Итого набежало: " + myOrder() +"\n Еще чего-то?" + menu;
        }
        if (foundCount() > 1)
            return  "\n" + extract() + "\n Выбери что-то уже, и я добавлю это в заказ.";
        return "Не понял. Тебе что, выбрать по человечески сложно? " + menu;


    }

    public static void main(String[] args){
        System.out.println("Telegram Bot started");
        ApiContextInitializer.init();
        //alpro

        Telebot bot = new Telebot();
        bot.username = "telealprobot";
        bot.token = "823655880:AAFARjiubmOB-yWIdLAIZTeDIwtI22hxlnE";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, hi, hello", "Текстовое описание позиции", BigDecimal.valueOf(0));

        String pizzaMargarita= "https://attuale.ru/wp-content/uploads/2018/11/margarita.jpg";
        bot.addTags(pizzaMargarita, "маргарита", "Пицца Маргарита, на тонком тесте. Цена:900 EUR", BigDecimal.valueOf(900));

        String pizzaPeperoni= "https://matreshka-rnd.ru/img/catalog/81.jpg";
        bot.addTags(pizzaPeperoni, "пеперони", "Пицца Пеперони. Просто бомбическая. С колбасками. Сожрешь пока несешь до дома. Цена: всего 800 EUR", BigDecimal.valueOf(800));

        bot.addTags("конец", "конец, все, стоп, нет", "Текстовое описание позиции", BigDecimal.valueOf(0));

        bot.addTags("дурак", "дурак, придурок, идиот, тупой", "Текстовое описание позиции", BigDecimal.valueOf(0));

        bot.addTags("заказ", "заказ", "Текстовое описание позиции", BigDecimal.valueOf(0));

        bot.start();
    }

}
