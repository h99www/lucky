package com.greedy.lucky.main;

import com.greedy.lucky.config.LuckyApplication;
import com.greedy.lucky.config.MybatisConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ContextConfiguration(classes = {ContextConfiguration.class, MybatisConfig.class, LuckyApplication.class})
public class MainControllerTests {

    @Autowired
    private MainController mainController;
    private MockMvc mockMvc;

    @BeforeEach
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void 메인_화면으로_가는지_테스트() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("main/mainpage"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void 메인_화면으로_가는지_테스트2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("main/mainpage"))
                .andDo(MockMvcResultHandlers.print());
    }
}
