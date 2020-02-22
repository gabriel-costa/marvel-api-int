package service;

import bean.Series;
import bean.simple.SeriesSimple;
import dao.SeriesDAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;

public class SeriesService {

    private static final SeriesDAO seriesDao = new SeriesDAO();

    public Series[] getAllSeries() {
        throw new NotImplementedException();
    }

    public Series getSeriesById(int id) {
        throw new NotImplementedException();
    }

    public SeriesSimple[] getSeriesByCharacterId(int id) throws SQLException {
        return seriesEntityArrayToSimpleBeanArray(seriesDao.getSeriesByCharacterId(id));
    }

    private SeriesSimple[] seriesEntityArrayToSimpleBeanArray(entity.Series[] seriesByCharacterId) {
        SeriesSimple[] seriesSimple = new SeriesSimple[seriesByCharacterId.length];
        for (int i = 0; i < seriesByCharacterId.length; i++) {
            seriesSimple[i] = new SeriesSimple(
                    seriesByCharacterId[i].getId(),
                    seriesByCharacterId[i].getTitle(),
                    seriesByCharacterId[i].getDescription(),
                    seriesByCharacterId[i].getModified(),
                    seriesByCharacterId[i].getResourceURI()
            );
        }
        return seriesSimple;
    }
}
