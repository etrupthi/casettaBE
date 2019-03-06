// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/etrupthi/Documents/backend/conf/routes
// @DATE:Wed Mar 06 11:15:49 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:38
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:33
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseUsersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getCurrentUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.getCurrentUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/me"})
        }
      """
    )
  
    // @LINE:6
    def registerUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.registerUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:11
    def signOutUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.signOutUser",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users/signout"})
        }
      """
    )
  
    // @LINE:8
    def signInUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.signInUser",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users/signin"})
        }
      """
    )
  
  }

  // @LINE:31
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:35
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseHotelController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def updateHotelById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HotelController.updateHotelById",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "hotels/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:15
    def createHotel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HotelController.createHotel",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "hotels"})
        }
      """
    )
  
    // @LINE:22
    def getHotelById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HotelController.getHotelById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hotels/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:17
    def searchHotels: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HotelController.searchHotels",
      """
        function(location0,price1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hotels" + _qS([(location0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("location", location0)), (price1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Integer]].javascriptUnbind + """)("price", price1))])})
        }
      """
    )
  
    // @LINE:24
    def deleteHotelById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HotelController.deleteHotelById",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "hotels/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }


}
