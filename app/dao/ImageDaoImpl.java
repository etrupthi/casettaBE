package dao;

import controllers.HotelController;
import models.Hotel;
import models.Image;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ImageDaoImpl implements ImageDao {

    private final static Logger.ALogger LOGGER = Logger.of(HotelController.class);

    final JPAApi jpaApi;

    @Inject
    public ImageDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

//    @Override
//    public Collection<Image> getImageById(Integer id){
//
//        if(null == id){
//            throw new IllegalArgumentException("id must be provided");
//        }
//
//        LOGGER.debug(String.valueOf(id));
//         Query query= jpaApi.em().createQuery("SELECT imageUrl FROM Image where id = '" + id + "'", Image.class);
//        List images = query.getResultList();
//
//        return images;
//    }

    @Override
    public Image create(Image entity) {
        jpaApi.em().persist(entity);
        return entity;
    }

    @Override
    public Optional<Image> read(String id) {
        return Optional.empty();
    }

    @Override
    public Image update(Image entity) {
        return null;
    }

    @Override
    public Image delete(String id) {
        return null;
    }

    @Override
    public Collection<Image> all() {
        return null;
    }
}
