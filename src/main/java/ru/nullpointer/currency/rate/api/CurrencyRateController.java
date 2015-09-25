package ru.nullpointer.currency.rate.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nullpointer.currency.rate.domain.Rate;
import ru.nullpointer.currency.rate.service.CurrencyService;

/**
 *
 * @author Alexander Yastrebov
 */
@RestController
public class CurrencyRateController {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Resource
    private CurrencyService currencyService;

    @RequestMapping("/api/{code}")
    public ResponseEntity<Rate> getRate(@PathVariable("code") String code) {
        return toEntity(currencyService.getRate(code));
    }

    @RequestMapping("/api/{code}/{date}")
    public ResponseEntity<Rate> getRateForDate(
            @PathVariable("code") String code,
            @PathVariable("date") String dateText) {
        LocalDate date;
        try {
            date = LocalDate.parse(dateText, formatter);
        } catch (DateTimeParseException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return toEntity(currencyService.getRate(code, date));
    }

    private <T> ResponseEntity<T> toEntity(Optional<T> optional) {
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
