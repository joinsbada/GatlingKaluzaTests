package mock

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

/**
 *
 * @author sbadada
 * Initiating the  scala simulator to mimic users, rampup timeline and feeder feature file under tests
 *
 */

class CatsKarateSimulation extends Simulation {

  MockUtils.startServer()

  val feeder = Iterator.continually(Map("catName" -> MockUtils.getNextCatName))

  val protocol = karateProtocol(
    "/cats/{id}" -> Nil,
    "/cats" -> pauseFor("get" -> 15, "post" -> 25)
  )

  protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")

  val create = scenario("create").feed(feeder).exec(karateFeature("classpath:mock/tfl-plan-journey-within-london.feature"))

  setUp(
    create.inject(rampUsers(10) during (5 seconds)).protocols(protocol)
  )

}