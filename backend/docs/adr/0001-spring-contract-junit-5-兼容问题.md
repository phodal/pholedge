# 1. Spring Contract JUnit 5 兼容问题

Date: 2019-10-16

## Status

2019-10-16 proposed

## Context

Spring Contract generate JUnit 4 test, but default test is to JUnit 5. Somethings is not working well.

Try use ``Spock`` or upgrade some things

```
import org.mycompany.ExampleSpringController
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import spock.lang.Specification

class MvcSpec extends Specification {
  def setup() {
   RestAssuredMockMvc.standaloneSetup(new ExampleSpringController())
  }
}
```

## Decision

Decision here...

## Consequences

Consequences here...
