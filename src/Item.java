public class Item {
    private String name;
    private String password;
    public int ID;

    public Item(String name, String password){
        this.name = name;
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }




}
