package org.video.cms.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.video.cms.api.controller.VideoController;

/**
 * @author bobo
 * @date 2020/12/11
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
    MockMvc mockMvc;
    private MockHttpSession session;
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    VideoController videoController;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
    }

    @Test
    public void deleteVideo() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/video/delete")
                .param("id","PL004")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteCopy() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/copy/delete")
                .param("videoId","")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
