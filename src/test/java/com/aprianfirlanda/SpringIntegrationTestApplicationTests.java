package com.aprianfirlanda;

import com.aprianfirlanda.services.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class SpringIntegrationTestApplicationTests {

	@Autowired
	private StockService stockService;

	@Test
	void contextLoads() {
	}

	@Test
	@Sql(scripts = "insert-products.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "delete-products.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	void quantityByProductTypeTest() {
		assertThat(stockService.getQuantityByProductType("Perfume")).isEqualTo(3L);
	}
}
