package de.englc.helloWorld;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class HelloWorldApplicationTests {

	@Autowired
	private MockMvc mockMvc;

    @Autowired
    private TextDomain simpleDomain;

    @Autowired
    private TextService simpleService;

	@Before
	public void setup() {

	}

	@Test
	public void testGive() throws Exception {
		/*mockMvc.perform(MockMvcRequestBuilders.get(REST_ENDPOINT + "?page=0&size=10000&sortField=id&sortDescending=true")
				.header("Authorization", jwt).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())*/

		mockMvc.perform(MockMvcRequestBuilders.get("/give"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", is("This is some text Adjusted")));
	}

	@Test
	public void testGiveList() throws Exception {

		// When
		ResultActions results = mockMvc.perform(MockMvcRequestBuilders.get("/giveList"));

		// Then
		System.out.println(results.andReturn().getResponse().getContentAsString());
		results.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[*]", contains("This is some text Adjusted")));
	}

	@Test
	public void testGetText() {

        assertEquals("This is some text", simpleDomain.get());
        assertEquals("This is some text Adjusted", simpleService.getText());
        assertNotEquals(simpleDomain.get(), simpleService.getText());

	}

}
