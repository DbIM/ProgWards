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
import java.net.URL;
import java.net.MalformedURLException;


public class Telebot extends ProgwardsTelegramBot {
    private final String menu = "\n У нас есть пицца";

    @Override
    public String processMessage(String text) {
        checkTags(text);

        if (foundCount() == 1) {
            if (checkLastFound("привет"))
                return "Приветствую тебя, о мой повелитель!\n Что желаешь? " + menu;
            if (checkLastFound("конец"))
                return "Спасибо за заказ.";
            if (checkLastFound("дурак"))
                return "Не надоругаться. Я не волшебник, я только учусь";

            return "Отлично, добавляю в заказ " + getLastFound() + "\n Желаешь что-то еще?" + menu;
        }
        String photo1= "https://static.tildacdn.com/tild3531-3437-4062-a266-613234626332/photo.jpg";
        if (foundCount() > 1)
            return  "\n" + extract() + "\n Выбери что-то одно, и я добавлю это в заказ.";
        return "Я не понял, возможно у нас этого нет, попробуй сказать по другому. " + menu;


    }

    public static void main(String[] args){
        System.out.println("Telegram Bot started");
        ApiContextInitializer.init();
        //alpro

        Telebot bot = new Telebot();
        bot.username = "telealprobot";
        bot.token = "823655880:AAFARjiubmOB-yWIdLAIZTeDIwtI22hxlnE";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, hi, hello", "Текстовое описание позиции");

        String photo1= "https://static.tildacdn.com/tild3531-3437-4062-a266-613234626332/photo.jpg";
        bot.addTags(photo1, "pizza", "Текстовое описание позиции");
        
        bot.addTags("Пицца гавайская", "гавайск, пицц, ананас, куриц", "Текстовое описание позиции");
        bot.addTags("Пицца маргарита", "маргарит, пицц, моцарелла, сыр, кетчуп, помидор", "Текстовое описание позиции");
        bot.addTags("Пицца пеперони", "пеперони, пицц, салями, колбас, сыр, кетчуп, помидор", "Текстовое описание позиции");

        bot.addTags("конец", "конец, все, стоп, нет", "Текстовое описание позиции");

        bot.addTags("дурак", "дурак, придурок, идиот, тупой", "Текстовое описание позиции");

        bot.start();
    }

}
