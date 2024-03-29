package fjpc.mvcdemo.tests

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class BasicSimulation extends Simulation {

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://localhost:8080")
    .contentTypeHeader("application/json")

  object CustomerController {

    val newCustomer: ChainBuilder = exec(
      http("NewCustomerEndpoint")
        .post("/customers")
        .body(RawFileBody("payload.json")).asJson
    )

    val findAllCustomers: ChainBuilder = exec(
      http("FindAllCustomersEndpoint")
        .get("/customers")
    )

  }

  val sampleScenario: ScenarioBuilder = scenario("sampleScenario").exec(CustomerController.findAllCustomers)

  setUp(
    sampleScenario.inject(atOnceUsers(100))
      .protocols(httpProtocol)
  )

}
