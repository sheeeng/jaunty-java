package hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class DummyTests extends TestCase {

	public void testDummy() {
		System.out.println("Dummy test ran sucessfully.");
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testAhoyResponse() {
		String body = this.restTemplate.getForObject("/ahoy", String.class);
		assertThat(body).isNotEqualTo("Hello, world!");
		assertThat(body).isEqualTo("Ahoy, matey!");
	}

}
