// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/etrupthi/Documents/casettaBE/conf/routes
// @DATE:Sat Mar 09 12:03:13 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
