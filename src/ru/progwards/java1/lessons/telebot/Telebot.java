package ru.progwards.java1.lessons.telebot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.progwards.java1.testlesson.ProgwardsTelegramBot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;


public class Telebot extends ProgwardsTelegramBot {
    private final String menu = "У нас есть пицца";

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

            return "Отлично, добавляю в заказ " + getLastFound() + " Желаешь что-то еще?" + menu;
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
        bot.username = "";
        bot.token = "";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, hi, hello");

        String photo1= "https://static.tildacdn.com/tild3531-3437-4062-a266-613234626332/photo.jpg";
/*        URL url = null;
        try {
            url = new URL(photo1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }*/



/*        String [] boolArray = new String[10];
        boolArray = new String[Integer.parseInt("a")];
        for (int i=0; i<boolArray.length; i++){
            if(boolArray[i]!=null){
                System.out.println(boolArray[i]);
            }
            else {
                System.out.println("null");
            }
        }


        SendPhoto message = null;
        try {
            message = new SendPhoto().setPhoto("SomeText", new FileInputStream(photo1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        bot.addTags(photo1, "pizza");
        
        bot.addTags("Пицца гавайская", "гавайск, пицц, ананас, куриц");
        bot.addTags("Пицца маргарита", "маргарит, пицц, моцарелла, сыр, кетчуп, помидор");
        bot.addTags("Пицца пеперони", "пеперони, пицц, салями, колбас, сыр, кетчуп, помидор");

        bot.addTags("конец", "конец, все, стоп, нет");

        bot.addTags("дурак", "дурак, придурок, идиот, тупой");

        bot.start();
    }

}
