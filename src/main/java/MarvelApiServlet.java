import service.CharacterService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MarvelApiServlet extends HttpServlet {

    private static final CharacterService characterService = new CharacterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        if (req.getParameter("id") != null) {
            switch (req.getParameter("list")) {
                case "comics":
                    writer.print(characterService.getComicsByCharacterId(req));
                    break;
                case "events":
                    writer.print(characterService.getEventsByCharacterId(req));
                    break;
                case "series":
                    writer.print(characterService.getSeriesByCharacterId(req));
                    break;
                case "stories":
                    writer.print(characterService.getStoriesByCharacterId(req));
                    break;
                default:
                    writer.print(characterService.getCharacterById(req));
            }
        } else {
            if (req.getParameter("list") != null) {
                resp.sendError(400, "You're missing character ID!");
            } else {
                writer.print(characterService.getAllCharacters(req));
            }
        }
        writer.flush();
    }
}