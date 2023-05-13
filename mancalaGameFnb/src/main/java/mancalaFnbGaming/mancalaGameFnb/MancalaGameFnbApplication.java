package mancalaFnbGaming.mancalaGameFnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "mancalaFnbGaming.mancalaGameFnb.controller")
public class MancalaGameFnbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MancalaGameFnbApplication.class, args);
	}

}
