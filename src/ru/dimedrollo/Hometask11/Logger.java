package ru.dimedrollo.Hometask11;


public class Logger {

    private Logger() {
    }

    private static Logger instance;

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    void log(String message) {
        System.out.println(message);
    }

}
