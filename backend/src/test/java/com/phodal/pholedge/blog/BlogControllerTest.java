package com.phodal.pholedge.blog;

import com.phodal.pholedge.blog.command.SaveBlogCommand;
import com.phodal.pholedge.blog.command.SavePlayCommand;
import com.phodal.pholedge.blog.model.Blog;
import com.phodal.pholedge.common.PholedgeTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BlogController.class)
@AutoConfigureMybatis
class BlogControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogService blogService;

    @Test
    public void should_return_default_data() throws Exception {
        Blog blog = Blog.create("213", "https://www.phodal.com", "title", "json");
        given(blogService.savePlay(any())).willReturn(blog.getId());

        SavePlayCommand savePlayCommand = new SavePlayCommand("195", "234");

        this.mockMvc.perform(
                post("/blogs/savePlay")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(PholedgeTestUtils.asJsonString(savePlayCommand))
        )
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"id\":\"213\"}"));
    }

}