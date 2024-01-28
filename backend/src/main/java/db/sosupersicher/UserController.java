package db.sosupersicher;

public class UserController {

    public void createUser(String name, int age, String role){
        MitSQLite.einfuegen(name, role, age, 0);
    }

    public boolean controllData(String name, String password){
        return MitSQLite.isPasswortRichtig(name, password);
    }

    public void resetPassword(String name){
        if(!MitSQLite.isPasswortZurueckgesetzt(name)){
            MitSQLite.passwortZuruecksetzen(name);
        }
    }

    public String showAllPasswords(){
        return "";
    }

    public String showAllNames(){
        return "";
    }

    public boolean checkUserExists(String name){
        return MitSQLite.userExists(name);
    }
}
