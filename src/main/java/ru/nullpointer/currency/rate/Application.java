package ru.nullpointer.currency.rate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import ru.nullpointer.currency.rate.repo.CurrencyRepository;
import ru.nullpointer.currency.rate.repo.impl.cbrf.CBRFCurrencyRepository;

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

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(BigDecimal.class, new ToStringSerializer());
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        objectMapper.registerModule(module);

        jsonConverter.setObjectMapper(objectMapper);

        return jsonConverter;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    private static class LocalDateSerializer extends JsonSerializer<LocalDate> {

        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public void serialize(LocalDate t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
            jg.writeString(t.format(formatter));
        }
    }
}
