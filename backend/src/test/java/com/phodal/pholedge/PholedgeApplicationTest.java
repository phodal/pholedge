package com.phodal.pholedge;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PholedgeApplicationTest {

	@Test
	public void contextLoads() {
		assertThat(1).isEqualTo(1);
	}
}
