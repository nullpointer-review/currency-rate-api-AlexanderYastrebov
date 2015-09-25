package ru.nullpointer.currency.rate.api;

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

    @Resource
    private CurrencyService currencyService;

    @RequestMapping("/api/{code}")
    public ResponseEntity<Rate> getRate(@PathVariable("code") String code) {
        Optional<Rate> rate = currencyService.getRate(code);
        if (rate.isPresent()) {
            return new ResponseEntity<>(rate.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
