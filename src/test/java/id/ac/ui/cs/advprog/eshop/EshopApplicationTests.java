package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testRunApp() {
		EshopApplication application = new EshopApplication();
		String[] args = { "test" };

		EshopApplication.main(args);
	}

}
