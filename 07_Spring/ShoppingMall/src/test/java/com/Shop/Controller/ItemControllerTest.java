package com.Shop.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("itemFormTest_ADMIN")
//	Mock 을 이용해서 가상의 사용자를 상정하여 테스트를 진행한다.
	@WithMockUser(username = "admin", roles = "ADMIN")
	public void itemFormTestA() throws Exception {
//		가상의 사용자를 이용하여 지정된 페이지로 리퀘스트를 보낸다.
//		print() 보낸 요청과 이에대한 응답에 대한 정보를 콘솔에서 확인할 수 있는 메소드.
//		status().isOk() 요청에 대한 응답의 상태가 정상인지를 확인한다.  
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	@DisplayName("itemFormTest_USER")
	@WithMockUser(username = "user", roles = "USER")
	public void itemFormTestU() throws Exception {
//		status().isForbidden() 은 말 그대로 권한이 없어서 오류가 뜨는지를 확인. 403 에러.
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new")).andDo(print()).andExpect(status().isForbidden());
	}
}
