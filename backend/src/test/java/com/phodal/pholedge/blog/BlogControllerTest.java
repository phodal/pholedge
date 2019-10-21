package com.phodal.pholedge.blog;

import com.phodal.pholedge.BaseApiTest;
import com.phodal.pholedge.blog.command.SavePlayCommand;
import com.phodal.pholedge.blog.model.WdsmPlay;
import com.phodal.pholedge.blog.repository.BlogRepository;
import com.phodal.pholedge.blog.repository.WdsmPlayClient;
import com.phodal.pholedge.common.PholedgeTestUtils;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;


@AutoConfigureMybatis
@Import(BlogRepository.class)
class BlogControllerTest extends BaseApiTest {
    @Mock
    private WdsmPlayClient wdsmPlayClient;

    @Autowired(required = true)
    private BlogRepository blogRepository;

    @Test
    public void should_verify_api_exists() {
        WdsmPlay wdsmPlay = new WdsmPlay(222, "222", "2222", "title", "slug", "adaf", "2019-10-21", "afasdf", "12");
        Mockito.when(wdsmPlayClient.getPlay("222")).thenReturn(wdsmPlay);

        SavePlayCommand savePlayCommand = new SavePlayCommand("222", "234");

        given()
                .contentType(ContentType.JSON)
                .body(PholedgeTestUtils.asJsonString(savePlayCommand))

                .when()
                .post("/blogs/savePlay")
                .then()
                .statusCode(500);
    }
}