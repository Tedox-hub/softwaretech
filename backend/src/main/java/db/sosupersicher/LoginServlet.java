package db.sosupersicher;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        String passwort = jsonRequest.getString("passwort");

        UserController controller = new UserController();
        JSONObject jsonResponse = new JSONObject();
        if (controller.controllData(name, passwort)) {
            jsonResponse.put("status", "success");
        } else {
            jsonResponse.put("status", "failed");
        }
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}