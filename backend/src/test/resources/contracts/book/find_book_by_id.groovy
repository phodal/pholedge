package book

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should able find book by"

    request {
        url "/books/123"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                name: "bee",
                isbn: "foo"
        )
    }
}