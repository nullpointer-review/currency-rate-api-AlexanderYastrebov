package ru.nullpointer.currency.rate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.nullpointer.currency.rate.repo.CurrencyRepository;
import ru.nullpointer.currency.rate.repo.impl.CBRFCurrencyRepository;

/**
 *
 * @author Alexander Yastrebov
 */
@SpringBootApplication
public class Application {

    @Bean
    public CurrencyRepository currencyRepository() {
        CurrencyRepository repo = new CBRFCurrencyRepository();
        return repo;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
