package ru.nullpointer.currency.rate.repo.impl.cbrf;

import java.math.BigDecimal;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import ru.nullpointer.currency.rate.domain.Rate;
import ru.nullpointer.currency.rate.repo.CurrencyRepository;

/**
 *
 * @author Alexander Yastrebov
 */
public class CBRFCurrencyRepository implements CurrencyRepository {

    private final Logger logger = LoggerFactory.getLogger(CBRFCurrencyRepository.class);
    //
    private RestTemplate restTemplate;

    @Override
    public Optional<Rate> getRate(String code) {
        Assert.hasText(code);

        ValCurs curs = restTemplate.getForObject("http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002", ValCurs.class);

        Optional<Valute> val = curs.getValutes().stream()
                .filter((v) -> code.equals(v.getCode()))
                .findFirst();

        if (!val.isPresent()) {
            return Optional.empty();
        }
        Valute valute = val.get();

        BigDecimal rateValue = valute.getValue().divide(BigDecimal.valueOf(valute.getNominal()));

        Rate r = new Rate();
        r.setCode(code);
        r.setRate(rateValue);
        r.setDate(curs.getDate());

        return Optional.of(r);
    }

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
    }
}
