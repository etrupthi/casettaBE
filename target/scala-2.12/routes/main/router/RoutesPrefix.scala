// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/etrupthi/Documents/backend/conf/routes
// @DATE:Wed Mar 06 11:15:49 IST 2019


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
