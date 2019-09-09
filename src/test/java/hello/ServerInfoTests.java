package hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import junit.framework.TestCase;

public class ServerInfoTests extends TestCase {

	private String returnString = "";

	@Test
	public void testServerInfo() {
		returnString = ServerInfo.getServerInfo();
		assertNotNull(returnString);
		assertThat(returnString).isNotEqualTo("");
	}

}
