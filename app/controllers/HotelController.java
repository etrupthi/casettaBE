package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.Security.Authenticator;
import dao.HotelDao;
import models.Hotel;
import models.User;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;

public class HotelController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(HotelController.class);

    private HotelDao hotelDao;

    @Inject
    public HotelController(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Transactional
    @Authenticator
    public Result createHotel() {

        final JsonNode json = request().body().asJson();

        final Hotel hotel = Json.fromJson(json, Hotel.class);

        final User user = (User) ctx().args.get("user");

        hotel.setUser(user);

        final Hotel newHotel = hotelDao.create(hotel);

        final JsonNode result = Json.toJson(newHotel);
        return ok(result);
    }

    @Transactional
    public Result getHotelById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }


        final Optional<Hotel> hotel = hotelDao.read(id);
        if (hotel.isPresent()) {
            final JsonNode result = Json.toJson(hotel.get());
            return ok(result);
        } else {
            return notFound();
        }

    }


    @Transactional
    public Result updateHotelById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final JsonNode json = request().body().asJson();
        final Hotel newHotel = Json.fromJson(json, Hotel.class);

        newHotel.setId(id);

        final Hotel updatedHotel = hotelDao.update(newHotel);

        final JsonNode result = Json.toJson(updatedHotel);
        return ok(result);
    }

    @Transactional
    public Result deleteHotelById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Hotel hotel = hotelDao.delete(id);

        final JsonNode result = Json.toJson(hotel);
        return ok(result);
    }

    @Transactional
    public Result getAllHotels() {

        Collection<Hotel> hotels = hotelDao.all();

        final JsonNode result = Json.toJson(hotels);
        return ok(result);
    }


    @Transactional
    public Result searchHotels(String location, Integer price){

        Collection<Hotel> hotels = hotelDao.search(location, price);
        final JsonNode result = Json.toJson(hotels);
        return ok(result);
    }

}


/*
package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Hotel;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.HashMap;
import java.util.Map;

public class HotelController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(HotelController.class);

    int index = 0;
    final Map<Integer, Hotel> hotels = new HashMap<>();

    public Result createHotel() {
        
        final JsonNode json = request().body().asJson();

        final Hotel hotel = Json.fromJson(json, Hotel.class);

        LOGGER.debug("Book title = " + hotel.getName());
        LOGGER.error("This is an error");


        if (null == hotel.getName()) {
            return badRequest("Title must be provided");
        }

        hotel.setId(index++);
        hotels.put(hotel.getId(), hotel);


        final JsonNode result = Json.toJson(hotel);

        return ok(result);
    }

    public Result getHotelById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Hotel hotel = hotels.get(id);
        if (null == hotel) {
            return notFound();
        }

        final JsonNode result = Json.toJson(hotel);

        return ok(result);
    }

    public Result updateHotelById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Hotel existingHotel = hotels.get(id);
        if (null == existingHotel) {
            return notFound();
        }

        final JsonNode json = request().body().asJson();
        final Hotel newHotel = Json.fromJson(json, Hotel.class);

        existingHotel.setName(newHotel.getName());
        hotels.put(existingHotel.getId(), existingHotel);

        final JsonNode result = Json.toJson(existingHotel);
        return ok(result);
    }

    public Result deleteHotelById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Hotel hotel = hotels.remove(id);
        if (null == hotel) {
            return notFound();
        }

        final JsonNode result = Json.toJson(hotel);
        return ok(result);
    }

    public Result getAllHotels() {

        final JsonNode result = Json.toJson(hotels.values());

        return ok(result);

    }

}
*/




