package db.sosupersicher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MitSQLite {
    private static final String dburl = "jdbc:sqlite:SoSuperSicher.db";

    public static void main(String[] args) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                System.out.println("SQLite JDBC driver not found!");
                e.printStackTrace();
                return;
            }

            try (Connection con = DriverManager.getConnection(dburl);
                    PreparedStatement tabelle = con.prepareStatement("CREATE TABLE IF NOT EXISTS Benutzer (" +
                            "Benutzer_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "Benutzer_Name TEXT," +
                            "Benutzer_Rolle TEXT," +
                            "Benutzer_Alter INTEGER," +
                            "Passwort_zurueckgesetzt INTEGER," +
                            "AccountCreation TEXT)")) {
                tabelle.executeUpdate();

                System.out.println("Verbindung erfolgreich!");
                lesen();
            } catch (SQLException e) {
                System.out.println("ERROR! Verbindung fehlgeschlagen!");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("ERROR! Verbindung fehlgeschlagen!");
            e.printStackTrace();
        }
    }

    public static void einfuegen(String Name, String Rolle, int Alter, int zurueckgesetzt) {
        try (Connection con = DriverManager.getConnection(dburl)) {

            try (PreparedStatement insert = con.prepareStatement(
                    "INSERT INTO Benutzer(Benutzer_Name, Benutzer_Rolle, Benutzer_Alter, Passwort_zurueckgesetzt, AccountCreation) VALUES (?, ?, ?, ?, ?)")) {

                insert.setString(1, Name);
                insert.setString(2, Rolle);
                insert.setInt(3, Alter);
                insert.setInt(4, zurueckgesetzt);

                LocalDateTime zeit = LocalDateTime.now();
                DateTimeFormatter zeitformat = DateTimeFormatter.ofPattern("HH:mm");

                String zeitString = zeit.format(zeitformat);
                insert.setString(5, zeitString);

                int test = insert.executeUpdate();

                if (test > 0) {
                    System.out.println("Benutzer erfolgreich hinzugefügt!");
                } else {
                    System.out.println("Hinzufügen fehlgeschlagen!");
                }

            } catch (SQLException e) {
                System.out.println("Hinzufügen fehlgeschlagen!");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Verbindung fehlgeschlagen!");
            e.printStackTrace();
        }
    }

    public static void passwortZuruecksetzen(String name) {
        try (Connection con = DriverManager.getConnection(dburl);
                PreparedStatement reset = con.prepareStatement(
                        "UPDATE Benutzer SET Passwort_zurueckgesetzt = ?, AccountCreation = ? WHERE Benutzer_Name = ?")) {

            boolean isresetbool = isPasswortZurueckgesetzt(name);

            if (!isresetbool) {
                reset.setInt(1, 1);
                reset.setString(2, "admin");
                reset.setString(3, name);

                int test = reset.executeUpdate();

                if (test > 0) {
                    System.out.println("Passwort zurücksetzen für Benutzer " + name + " erfolgreich geändert!");
                } else {
                    System.out.println("Benutzer " + name + " nicht gefunden!");
                }
            } else {
                System.out.println("Passwort wurde bereits zurückgesetzt und kann nicht erneut geändert werden!");
            }

        } catch (SQLException e) {
            System.out.println("Passwort zurücksetzen fehlgeschlagen!");
            e.printStackTrace();
        }
    }

    public static boolean isPasswortZurueckgesetzt(String name) {
        try (Connection con = DriverManager.getConnection(dburl);
                PreparedStatement isreset = con
                        .prepareStatement("SELECT Passwort_zurueckgesetzt FROM Benutzer WHERE Benutzer_Name = ?")) {

            isreset.setString(1, name);

            try (ResultSet setzen = isreset.executeQuery()) {
                if (setzen.next()) {
                    return setzen.getInt("Passwort_zurueckgesetzt") == 1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean isPasswortRichtig(String name, String passwort) {
        try (Connection con = DriverManager.getConnection(dburl);
             PreparedStatement isreset = con
                     .prepareStatement("SELECT * FROM Benutzer WHERE (Benutzer_Name = ? AND AccountCreation = ?) OR (Benutzer_Name = ? AND Passwort_zurueckgesetzt = ?);")) {

            isreset.setString(1, name);
            isreset.setString(2, passwort);
            isreset.setString(3, name);
            isreset.setInt(4, 1);

            try (ResultSet setzen = isreset.executeQuery()) {
                if (setzen.next()) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void loeschen(String name) {
        try (Connection con = DriverManager.getConnection(dburl);
                PreparedStatement delete = con.prepareStatement("DELETE FROM Benutzer WHERE Benutzer_Name = ?")) {

            delete.setString(1, name);
            int test = delete.executeUpdate();

            if (test > 0) {
                System.out.println("Benutzer '" + name + "' erfolgreich gelöscht!");
            } else {
                System.out.println("Benutzer '" + name + "' nicht gefunden oder bereits gelöscht!");
            }

        } catch (SQLException e) {
            System.out.println("Löschen fehlgeschlagen!");
            e.printStackTrace();
        }
    }

    public static void lesen() {
        try (Connection con = DriverManager.getConnection(dburl);
                PreparedStatement select = con.prepareStatement("SELECT * FROM Benutzer");
                ResultSet setzen = select.executeQuery()) {
                    int i=0;
            while (setzen.next()) {
                i++;
                int ID = setzen.getInt("Benutzer_ID");
                String Name = setzen.getString("Benutzer_Name");
                String Rolle = setzen.getString("Benutzer_Rolle");
                int Alter = setzen.getInt("Benutzer_Alter");
                boolean pwreset = setzen.getBoolean("Passwort_zurueckgesetzt");
                String ac = setzen.getString("AccountCreation");

                System.out.println("Benutzer_ID: " + ID + ", Benutzer_Name: " + Name + ", Benutzer_Rolle: " + Rolle
                        + ", Benutzer_Alter: " + Alter + ", Passwort_zurueckgesetzt: " + pwreset + ", AccountCreation: "
                        + ac);
            }
            if(i==0)System.out.println("Noch keine Einträge vorhanden!");

        } catch (SQLException e) {
            System.out.println("Lesen fehlgeschlagen!");
            e.printStackTrace();
        }
    }

    public static boolean userExists(String name) {
        try (Connection con = DriverManager.getConnection(dburl);
                PreparedStatement select = con.prepareStatement("SELECT * FROM Benutzer WHERE Benutzer_Name = ?")) {

            select.setString(1, name);

            try (ResultSet setzen = select.executeQuery()) {
                if (setzen.next()) {
                    System.out.println("Benutzer '" + name + "' gefunden!");
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Benutzer '" + name + "' nicht gefunden!");
        return false;
    }
}
