package db.sosupersicher;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ResetServlet", value = "/reset")
public class ResetServlet extends HttpServlet {

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
        UserController controller = new UserController();
        controller.resetPassword(name);
    }

    public void destroy() {
    }
}
