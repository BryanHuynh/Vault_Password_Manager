import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        System.out.println("Start....");
        CommandHandler commandHandler = new CommandHandler();
        System.out.println(commandHandler.banner());
        commandHandler.menu();
        System.out.println("....Ended");
    }
}
