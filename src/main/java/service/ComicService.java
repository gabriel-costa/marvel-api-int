package service;

import bean.Comic;
import bean.simple.ComicSimple;
import dao.ComicDAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;

public class ComicService {

    private static final ComicDAO comicDao = new ComicDAO();

    public Comic[] getAllComics() {
        throw new NotImplementedException();
    }

    public Comic getComicById(int id) {
        throw new NotImplementedException();
    }

    public ComicSimple[] getComicsByCharacterId(int id) throws SQLException {
        return comicEntityArrayToSimpleBeanArray(comicDao.getComicsByCharacterId(id));
    }

    private ComicSimple[] comicEntityArrayToSimpleBeanArray(entity.Comic[] comicsByCharacterId) {
        ComicSimple[] comicsSimple = new ComicSimple[comicsByCharacterId.length];
        for (int i = 0; i < comicsByCharacterId.length; i++) {
            comicsSimple[i] = new ComicSimple(
                    comicsByCharacterId[i].getId(),
                    comicsByCharacterId[i].getTitle(),
                    comicsByCharacterId[i].getDescription(),
                    comicsByCharacterId[i].getModified(),
                    comicsByCharacterId[i].getResourceURI(),
                    comicsByCharacterId[i].getPageCount()
            );
        }
        return comicsSimple;
    }
}
