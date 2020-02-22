package servlet;

import com.google.gson.Gson;
import service.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CharacterServlet extends HttpServlet {

    private static final CharacterService characterService = new CharacterService();

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            if (req.getParameter("id") != null) {
                if(req.getParameter("list") != null) {
                    switch (req.getParameter("list")) {
                        case "comics":
                            writer.print(gson.toJson(characterService.getComicsByCharacterId(new Integer(req.getParameter("id")))));
                            break;
                        case "events":
                            writer.print(gson.toJson(characterService.getEventsByCharacterId(new Integer(req.getParameter("id")))));
                            break;
                        case "series":
                            writer.print(gson.toJson(characterService.getSeriesByCharacterId(new Integer(req.getParameter("id")))));
                            break;
                        case "stories":
                            writer.print(gson.toJson(characterService.getStoriesByCharacterId(new Integer(req.getParameter("id")))));
                            break;
                        default:
                            resp.sendError(400, "Invalid list request!");
                    }
                } else {
                    writer.print(gson.toJson(characterService.getCharacterById(new Integer(req.getParameter("id")))));
                }
            } else {
                if (req.getParameter("list") != null) {
                    resp.sendError(400, "You're missing character ID!");
                } else {
                    writer.print(gson.toJson(characterService.getAllCharacters()));
                }
            }
            writer.flush();
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage()+" Please contact the administrator.");
        } catch (Exception e) {
            resp.sendError(500, e.getMessage()+" Stranger things happened! Please contact the administrator.");
        }
    }
}