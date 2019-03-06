package dao;

import models.Hotel;

import java.util.Collection;


public interface HotelDao extends CrudDao<Hotel, Integer> {

    Collection<Hotel> search(String location, Integer price);
}



/*
package dao;

import com.google.inject.Inject;
import models.Hotel;
import play.db.jpa.JPAApi;

import java.util.Collection;

public interface HotelDao extends CrudDao<Hotel, Integer>{
    Collection<Hotel> createHotel(Collection<Hotel> foodItems);

}*/