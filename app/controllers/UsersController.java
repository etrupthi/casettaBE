package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.io.BaseEncoding;
import controllers.Security.Authenticator;

import dao.UserDao;
import models.User;

import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Random;

public class UsersController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(UsersController.class);
    private final static int HASH_ITERATIONS = 100;

    private UserDao userDao;

    @Inject
    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }


    @Transactional
    public Result registerUser() {

        final JsonNode json = request().body().asJson();
        final User user = Json.fromJson(json, User.class);

        if (null == user.getUsername() ||
                null == user.getEmail()) {
            return badRequest("Missing mandatory parameters");
        }

        final String password = json.get("passwordHash").asText();
        if (null == password) {
            return badRequest("Missing mandatory parameters");
        }


        final Optional<User> existingUser = userDao.read(user.getUsername());

       if (existingUser.isPresent()) {
            return badRequest("User taken");
       }


        final String salt = generateSalt();

        final String hash = generateHash(salt, password, HASH_ITERATIONS);

        user.setHashIterations(HASH_ITERATIONS);
        user.setSalt(salt);
        user.setPasswordHash(hash);
        user.setState(User.State.VERIFIED);
        user.setRole(User.Role.USER);

        userDao.create(user);

        final JsonNode result = Json.toJson(user);

        return ok(result);
    }


    private String generateSalt() {

        // TODO Generate random string
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;





        //return "ABC";
    }


    private String generateHash(String salt, String password, int iterations) {
        try {

            final String contat = salt + ":" + password;

            // TODO Run in a loop x iterations
            // TODO User a better hash function
            final MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(contat.getBytes());
            final String passwordHash = BaseEncoding.base16().lowerCase().encode(messageDigest);

            LOGGER.debug("Password hash {}", passwordHash);

            return passwordHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public Result signInUser() {

        final JsonNode json = request().body().asJson();
        final User user = Json.fromJson(json, User.class);

        final String username = json.get("username").asText();
        final String password = json.get("passwordHash").asText();
        if (null == password || null == username) {
            return badRequest("Missing mandatory parameters");
        }



       final Optional<User> existingUser = userDao.read(user.getUsername());

       if (!existingUser.isPresent()) {
           return unauthorized("Wrong username");
        }



        final String salt = existingUser.get().getSalt();
        final int iterations = existingUser.get().getHashIterations();
        final String hash = generateHash(salt, password, iterations);

        if (!existingUser.get().getPasswordHash().equals(hash)) {
            return unauthorized("Wrong password");
        }

        if (existingUser.get().getState() != User.State.VERIFIED) {
            return unauthorized("Account not verified");
        }

        existingUser.get().setAccessToken(generateAccessToken());

        userDao.update(existingUser.get());

        final JsonNode result = Json.toJson(existingUser);

        return ok(result);
    }

    private String generateAccessToken() {

        // TODO Generate a random string of 20 (or more characters)

        String tokenchars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder accessToken = new StringBuilder();
        Random rnd = new Random();
        while (accessToken.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * tokenchars.length());
            accessToken.append(tokenchars.charAt(index));
        }
        String accessTokenStr = accessToken.toString();
        return accessTokenStr;

        //return "ABC1234";
    }

    @Transactional
    @Authenticator
    public Result signOutUser() {

        LOGGER.info("signOutUser");

        final User user = (User) ctx().args.get("user");

        user.setAccessToken(null);

        userDao.update(user);

        return ok();
    }

    @Transactional
    @Authenticator
    //@IsAdmin
    public Result getCurrentUser() {

        final User user = (User) ctx().args.get("user");

        final JsonNode result = Json.toJson(user);

        return ok(result);
    }


}







//
//package controllers;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import dao.UserDao;
//import models.User;
//import play.Logger;
//import play.db.jpa.Transactional;
//import play.libs.Json;
//import play.mvc.Controller;
//import play.mvc.Result;
//
//import javax.inject.Inject;
//
//import java.util.Optional;
//
//public class UsersController extends Controller {
//
//    private final static Logger.ALogger LOGGER = Logger.of(UsersController.class);
//
//    private UserDao userDao;
//
//    @Inject
//    public UsersController(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Transactional
//    public Result registerUser() {
//
//        final JsonNode json = request().body().asJson();
//        final User user = Json.fromJson(json, User.class);
//
//        if (null == user.getUsername() ||
//                null == user.getPassword() ||
//                null == user.getEmail()) {
//            return badRequest("Missing mandatory parameters");
//        }
//
//        final Optional<User> existingUser = userDao.read(user.getUsername());
//
//        if (existingUser.isPresent()) {
//            return badRequest("User taken");
//        }
//
//        user.setState(User.State.VERIFIED);
//        user.setRole(User.Role.USER);
//
//        userDao.create(user);
//
//        final JsonNode result = Json.toJson(user);
//
//        return ok(result);
//    }
//
//    @Transactional
//    public Result signInUser() {
//
//        final JsonNode json = request().body().asJson();
//        final User user = Json.fromJson(json, User.class);
//
//        if (null == user.getUsername() ||
//                null == user.getPassword()) {
//            return badRequest("Missing mandatory parameters");
//        }
//
//        final Optional<User> existingUser = userDao.read(user.getUsername());
//
//        if (!existingUser.isPresent()) {
//            return unauthorized("Wrong username");
//        }
//
//        final User u = existingUser.get();
//
//
//        if (!u.getPassword().equals(user.getPassword())) {
//            return unauthorized("Wrong password");
//        }
//
//        if (existingUser.get().getState() != User.State.VERIFIED) {
//            return unauthorized("Account not verified");
//        }
//
//        existingUser.get().setAccessToken(generateAccessToken());
//
//        userDao.update(existingUser.get());
//
//        final JsonNode result = Json.toJson(existingUser);
//
//        return ok(result);
//    }
//
//
//    @Transactional
//    private String generateAccessToken() {
//        return "ABC1234";
//    }
//
//
//    @Transactional
//    public Result signOutUser() {
//
//        // TODO
//
//        return status(NOT_IMPLEMENTED);
//    }
//
//    @Transactional
//    public Result getCurrentUser() {
//
//        final Optional<String> authHeader = request().header("Authorization");
//        if (!authHeader.isPresent()) {
//            return unauthorized("Go and sign in");
//        }
//
//        LOGGER.debug("Auth token = {}", authHeader.get());
//
//        if (!authHeader.get().startsWith("Bearer ")) {
//            return unauthorized("Invalid auth header format");
//        }
//
//        final String accessToken = authHeader.get().substring(7);
//        LOGGER.debug("accessToken {}", accessToken);
//        if (accessToken.isEmpty()) {
//            return unauthorized("Invalid auth header format");
//        }
//
//        final User user = userDao.findUserByAuthToken(accessToken);
//        if (null== user) {
//            return unauthorized("User not found");
//        }
//
//
//        final JsonNode result = Json.toJson(user);
//
//        return ok(result);
//    }
//
//
//}