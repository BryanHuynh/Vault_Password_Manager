import java.security.SecureRandom;

public class Generator {
    private int length;
    private boolean uppercase, lowercase, numbers, symbols;

    public Generator(int length, boolean uppercase, boolean lowercase, boolean numbers, boolean symbols){
        this.length = length;
        this.uppercase = uppercase;
        this.lowercase = lowercase;
        this.numbers = numbers;
        this.symbols = symbols;
    }

    private static String getCharacterList(boolean uppercase, boolean lowercase, boolean numbers, boolean symbols){
        String chars = "";
        if(uppercase) {
            chars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if(lowercase){
            chars += "abcdefghijklmnopqrstuvwxyz";
        }
        if(numbers){
            chars += "1234567890";
        }
        if(symbols){
            chars += "!@#$%^&*()_+-=<>?~";
        }
        return chars;
    }

    public String getPassword() {
        String chars = getCharacterList(uppercase, lowercase, numbers, symbols);
        if(chars == "") chars = "abcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));

        }
        return sb.toString();
    }
}
