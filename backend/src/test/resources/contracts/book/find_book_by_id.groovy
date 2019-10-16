package book

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should able find book by id"

    request {
        url "/books/1"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                name: "foo",
                isbn: "bee"
        )
    }
}