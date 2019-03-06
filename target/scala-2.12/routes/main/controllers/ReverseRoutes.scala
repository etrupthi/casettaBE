// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/etrupthi/Documents/backend/conf/routes
// @DATE:Wed Mar 06 11:15:49 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:38
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:33
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:6
  class ReverseUsersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getCurrentUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/me")
    }
  
    // @LINE:6
    def registerUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:11
    def signOutUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/signout")
    }
  
    // @LINE:8
    def signInUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/signin")
    }
  
  }

  // @LINE:31
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:35
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:15
  class ReverseHotelController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def updateHotelById(id:Integer): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "hotels/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:15
    def createHotel(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "hotels")
    }
  
    // @LINE:22
    def getHotelById(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hotels/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:17
    def searchHotels(location:String = null, price:Integer = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hotels" + play.core.routing.queryString(List(if(location == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("location", location)), if(price == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("price", price)))))
    }
  
    // @LINE:24
    def deleteHotelById(id:Integer): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "hotels/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
  }


}
