package servlet;

import bean.ListResponse;
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
        String[] pathParts = req.getPathInfo().split("/");
        String characterId = null;
        String list = null;
        if(pathParts.length > 1) {
            characterId = pathParts[1];
            if(pathParts.length > 2) {
                list = pathParts[2];
            }
        }
        try {
            if (characterId != null) {
                if(list != null) {
                    switch (list) {
                        case "comics":
                            writer.print(gson.toJson(new ListResponse(characterService.getComicsByCharacterId(new Integer(characterId)), null, null, null)));
                            break;
                        case "events":
                            writer.print(gson.toJson(new ListResponse(null, characterService.getEventsByCharacterId(new Integer(characterId)), null, null)));
                            break;
                        case "series":
                            writer.print(gson.toJson(new ListResponse(null, null, characterService.getSeriesByCharacterId(new Integer(characterId)), null)));
                            break;
                        case "stories":
                            writer.print(gson.toJson(new ListResponse(null, null, null, characterService.getStoriesByCharacterId(new Integer(characterId)))));
                            break;
                        default:
                            resp.sendError(400, "Invalid list request!");
                    }
                } else {
                    writer.print(gson.toJson(characterService.getCharacterById(new Integer(characterId))));
                }
            } else {
                if (list != null) {
                    resp.sendError(400, "You're missing character ID!");
                } else {
                    writer.print(gson.toJson(characterService.getAllCharacters()));
                }
            }
            writer.flush();
        } catch (SQLException e) {
            resp.sendError(500, e.getMessage()+" Database problems! Please contact the administrator.");
        } catch (Exception e) {
            resp.sendError(500, e.getMessage()+" Stranger things happened! Please contact the administrator.");
        }
    }
}