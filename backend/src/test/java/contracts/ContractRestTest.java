package contracts;


import com.phodal.pholedge.PholedgeApplication;
import com.phodal.pholedge.book.model.Book;
import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PholedgeApplication.class)
public class ContractRestTest {
    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.phodal", "pholedge", "0.0.1-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    public void get_book_from_service_contract() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Book> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/books/1", Book.class);

        BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}