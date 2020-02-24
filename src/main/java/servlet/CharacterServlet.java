package servlet;

import bean.Character;
import bean.ListResponse;
import bean.simple.ComicSimple;
import bean.simple.EventSimple;
import bean.simple.SeriesSimple;
import bean.simple.StorySimple;
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
            try {
                Integer.parseInt(characterId);
            } catch (NumberFormatException e) {
                resp.sendError(400, "Invalid character ID!");
                return;
            }
            if(pathParts.length > 2) {
                list = pathParts[2];
            }
        }
        try {
            if (characterId != null) {
                if(list != null) {
                    switch (list) {
                        case "comics":
                            ComicSimple[] comics = characterService.getComicsByCharacterId(new Integer(characterId));
                            if(comics.length > 0) {
                                writer.print(gson.toJson(new ListResponse(comics, null, null, null)));
                            } else {
                                resp.sendError(404, "Character not found!");
                            }
                            break;
                        case "events":
                            EventSimple[] events = characterService.getEventsByCharacterId(new Integer(characterId));
                            if(events.length > 0) {
                                writer.print(gson.toJson(new ListResponse(null, events, null, null)));
                            } else {
                                resp.sendError(404, "Character not found!");
                            }
                            break;
                        case "series":
                            SeriesSimple[] series = characterService.getSeriesByCharacterId(new Integer(characterId));
                            if(series.length > 0) {
                                writer.print(gson.toJson(new ListResponse(null, null, series, null)));
                            } else {
                                resp.sendError(404, "Character not found!");
                            }
                            break;
                        case "stories":
                            StorySimple[] stories = characterService.getStoriesByCharacterId(new Integer(characterId));
                            if(stories.length > 0) {
                                writer.print(gson.toJson(new ListResponse(null, null, null, stories)));
                            } else {
                                resp.sendError(404, "Character not found!");
                            }
                            break;
                        default:
                            resp.sendError(400, "Invalid list request!");
                    }
                } else {
                    Character character = characterService.getCharacterById(new Integer(characterId));
                    if (character != null) {
                        writer.print(gson.toJson(character));
                    } else {
                        resp.sendError(404, "Character not found!");
                    }
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