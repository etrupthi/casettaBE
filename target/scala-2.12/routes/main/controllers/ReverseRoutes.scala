// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/etrupthi/Documents/casettaBE/conf/routes
// @DATE:Tue Mar 12 14:34:56 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:46
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:41
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:6
  class ReverseUsersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getCurrentUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/me")
    }
  
    // @LINE:6
    def registerUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:12
    def signOutUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/signout")
    }
  
    // @LINE:10
    def signInUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/signin")
    }
  
  }

  // @LINE:39
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:43
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:27
  class ReverseImagesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def downloadImage(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "images/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:29
    def deleteImage(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "images/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:27
    def uploadImage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "images")
    }
  
  }

  // @LINE:16
  class ReverseHotelController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def getHotelByUsername(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hotels/username")
    }
  
    // @LINE:32
    def updateHotelById(id:Integer): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "hotels/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:16
    def createHotel(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "hotels")
    }
  
    // @LINE:31
    def getHotelById(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hotels/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:18
    def searchHotels(location:String = null, maxP:Integer = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hotels" + play.core.routing.queryString(List(if(location == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("location", location)), if(maxP == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("maxP", maxP)))))
    }
  
    // @LINE:33
    def deleteHotelById(id:Integer): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "hotels/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
  }


}
