package db.sosupersicher;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Check if the database exists
        File database = new File(this.getServletContext().getRealPath("SoSuperSicher.db"));
        if (!database.exists()) {
            MitSQLite.main(null);
        }

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = request.getReader();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        JSONObject jsonRequest = new JSONObject(stringBuilder.toString());

        String name = jsonRequest.getString("name");
        String rolle = jsonRequest.getString("rolle");
        int alter = 9;

        UserController controller = new UserController();
        boolean userExists = controller.checkUserExists(name);
        if (userExists) {
            System.out.println("Benutzer existiert bereits!");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Benutzer existiert bereits!");
        } else {
            controller.createUser(name, alter, rolle);
        }
    }

    public void destroy() {
    }
}