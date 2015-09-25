package ru.nullpointer.currency.rate.api;

import javax.annotation.Resource;
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
    public Rate getRate(@PathVariable("code") String code) {
        return currencyService.getRate(code);
    }
}
