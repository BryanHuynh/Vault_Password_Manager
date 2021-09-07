import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.lang.reflect.Method;
import java.util.function.Function;

public class CommandHandler {
    boolean running = true;
    Scanner command = new Scanner(System.in);
    public CommandHandler() throws Exception {
        System.out.println(this.banner());
        menu();
    }

    private void menu() {
        System.out.println(this.start());
        System.out.print("Command: ");
        while(running){
            switch(command.nextLine()){
                case "0":
                    System.out.println("Exiting program");
                    running = false;
                    break;
                case "1":
                    choice1();
                    menu();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Command not found");
                    break;
            }
        }
    }

    Function<String, Boolean> isNum = (s) -> {
        try{
            if(Integer.parseInt(s) > 0){
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    Function<String, Boolean> isYn = (s) -> {
        s = s.toLowerCase();
        if(Objects.equals(s, "y") || Objects.equals(s, "n")){
            return true;
        }
        return false;
    };

    private boolean parseYn (String yn){
        if(Objects.equals(yn, "y")) return true;
        return false;
    }

    private void choice1() {
        int length = Integer.parseInt(inputHandler("length default[12]:", isNum, "12"));
        boolean uppercase = parseYn(inputHandler("uppercase? : [Y/n]", isYn, "y"));
        boolean lowercase = parseYn(inputHandler("lowercase? : [Y/n]", isYn, "y"));
        boolean numbers = parseYn(inputHandler("numbers? : [Y/n]", isYn, "y"));
        boolean symbols = parseYn(inputHandler("symbols? : [Y/n]", isYn, "y"));
        System.out.format("length: %d, uppercase: %b, lowercase: %b, number: %b, symbols: %b \n \n",
                length, uppercase, lowercase, numbers, symbols);

        System.out.println(generatePassword());
        while(true){
            String password = new Generator(length, uppercase, lowercase, numbers, symbols).getPassword();
            System.out.format("Password: %s \n" , password);

            switch( command.nextLine() ) {
                case "":
                    break;
                case "1":
                    choice1();
                    return;
                case "2":
                    return;
                default:
                    System.out.println("invalid Input");
            };

        }
    }


    private String inputHandler(String message, Function<String, Boolean> method, String blank){
        while(true){
            System.out.print(message);
            String input = command.nextLine();
            if(input == "") return blank;
            if(method.apply(input)){
                return input;
            }else{
                System.out.println("input invalid");
            }
        }

    }

    private String start() {
        return readFile("src/Command_Information/Start");
    }

    private String banner(){
        return readFile("src/Command_Information/Banner");
    }

    private String generatePassword(){
        return readFile("src/Command_Information/Generate_password");
    }



    private String readFile(String pathname){
        String command = "";
        try{
            File file = new File(pathname);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                command += reader.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return command;
    }
}
