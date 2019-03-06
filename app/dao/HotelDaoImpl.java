package dao;

import controllers.HotelController;
import models.Hotel;
import play.db.jpa.JPAApi;
import play.libs.F;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import play.Logger;

public class HotelDaoImpl implements HotelDao {

    private final static Logger.ALogger LOGGER = Logger.of(HotelController.class);

    final JPAApi jpaApi;

    @Inject
    public HotelDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public Hotel create(Hotel hotel) {

        if (null == hotel) {
            throw new IllegalArgumentException("Book must be provided");
        }

        jpaApi.em().persist(hotel);
        return hotel;
    }

    public Optional<Hotel> read(Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("Id must be provided");
        }

        final Hotel hotel = jpaApi.em().find(Hotel.class, id);
        return hotel != null ? Optional.of(hotel) : Optional.empty();

    }


//    public Collection<Hotel> location(String location){
//
//        if(null == location) {
//            throw new IllegalArgumentException("Location must be provided");
//        }
//
//        LOGGER.debug(location);
//        TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where location = location", Hotel.class);
//        List<Hotel> hotels = query.getResultList();
//        return hotels;
//    }


    public Collection<Hotel> search(String location, Integer price){

        LOGGER.debug(location);
        LOGGER.debug(String.valueOf(price));


        if((null==location)&&(null==price)){

            TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b", Hotel.class);
            List<Hotel> hotels = query.getResultList();

            return hotels;
        }

       else if(null == price){
            TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where location = '" + location + "'",Hotel.class);
            List<Hotel> hotels = query.getResultList();
            return hotels;
        }
        else if(null == location){
            TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where price = '"+price+"' ",Hotel.class);
            List<Hotel> hotels = query.getResultList();
            return hotels;
        }



        else {
            TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where location = '" + location + "' AND price = '" + price + "' ", Hotel.class);
            List<Hotel> hotels = query.getResultList();
            return hotels;
        }
    }


    public Hotel update(Hotel hotel) {

        if (null == hotel) {
            throw new IllegalArgumentException("Book must be provided");
        }

        if (null == hotel.getId()) {
            throw new IllegalArgumentException("Book id must be provided");
        }

        final Hotel existingHotel = jpaApi.em().find(Hotel.class, hotel.getId());
        if (null == existingHotel) {
            return null;
        }

        existingHotel.setName(hotel.getName());

        jpaApi.em().persist(existingHotel);

        return existingHotel;
    }

    public Hotel delete(Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("Book id must be provided");
        }

        final Hotel existingHotel = jpaApi.em().find(Hotel.class, id);
        if (null == existingHotel) {
            return null;
        }

        jpaApi.em().remove(existingHotel);

        return existingHotel;
    }

    public Collection<Hotel> all() {

        TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b", Hotel.class);
        List<Hotel> hotels = query.getResultList();

        return hotels;
    }

}
