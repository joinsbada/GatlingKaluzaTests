# Kaluza Performance Tests with Karate Gatling
The intention of this maven project is to showcase API Performance Testing Made Simple with Karate Gatling.

### Rational
* Re-use Karate tests as performance tests executed by [Gatling](https://gatling.io)
* Use Gatling (and Scala) only for defining the load-model, everything else can be in Karate
* Karate assertion failures appear in Gatling report, along with the line-numbers that failed
* Leverage Karate's powerful assertion capabilities to check that server responses are as expected under load - which is much harder to do in Gatling and other performance testing tools

### Framework
The infra extends from core karate with Gatling, Scala for defining the load-model and Gatling reporting module. The idea is showcase Continuous Performance Testing via CI/CD as well as in agile development where you get builds and baselines more frequently. Benchmarking the response time of all transactions against previous builds with frequent/faster feedback to developers.

## Tech Stack
Java 1.8, Maven, Gatling, Scala, karate

## Installation
### Prerequisite
* Java 1.8 or later
* Apache Maven 3.8
* Karate Core 1.3 or later

## Setting up Locally
Git clone this repo and run this command from the project dir
```bash
  mvn clean test-compile gatling:test
```

### Dockerimage for continues performance tests on pods
Every time we add tests, a new docker image will be published onto [central repository](https://github.com/joinsbada/GatlingKaluzaTests/blob/main/src/test/java/mock/Screenshot%202022-09-24%20at%203.19.04%20PM.png) so as the [image](https://github.com/joinsbada/GatlingKaluzaTests/blob/main/Dockerfile) can be broadcasted onto different pods for running performance tests. (Stress, Load, Scalability tests )

## Gatling Test Report
Detailed [Gatling test report](https://github.com/joinsbada/GatlingKaluzaTests/blob/main/target/gatling/catskaratesimulation-20220924131355480.zip) under the /target/gatling/<runId>/index.html folder, which will be auto created once you run the test from command line.
You can right click and open the  index.html in any browser for detailed information on runs.


## Future works
* Sensitive credentials for hub.docker.com on Maven POM.xml is hardcoded which can be replaced with a secret storage services like Password manager applications like OpenID or SSO
* scala barebone template are used to setup simulators, however we can leverage JMeter agents can be leveraged alternatively
* Code can be better modularized and chunked fro reusability standpoint
* TFL tests can fail when tested continuously due to API Rate limit (5000 req per user) from provider standpoint
* Idea was to establish speed, scalability, and stability to save developers time


