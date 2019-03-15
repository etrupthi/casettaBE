// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yaswanthi/Documents/casettaBE/conf/routes
// @DATE:Fri Mar 15 12:08:55 IST 2019


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
