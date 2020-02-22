import service.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CharacterServlet extends HttpServlet {

    private static final CharacterService characterService = new CharacterService();
    private static final ComicService comicService = new ComicService();
    private static final EventService eventService = new EventService();
    private static final SeriesService seriesService = new SeriesService();
    private static final StoryService storyService = new StoryService();

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
                switch (req.getParameter("list")) {
                    case "comics":
                        comicService.getComicsByCharacterId(new Integer(req.getParameter("id")));
                        break;
                    case "events":
                        eventService.getEventsByCharacterId(new Integer(req.getParameter("id")));
                        break;
                    case "series":
                        seriesService.getSeriesByCharacterId(new Integer(req.getParameter("id")));
                        break;
                    case "stories":
                        storyService.getStoriesByCharacterId(new Integer(req.getParameter("id")));
                        break;
                    default:
                        characterService.getCharacterById(req.getParameter("id"));
                }
            } else {
                if (req.getParameter("list") != null) {
                    resp.sendError(400, "You're missing character ID!");
                } else {
                    characterService.getAllCharacters();
                }
            }
            writer.flush();
        } catch (Exception e) {

        }

    }
}