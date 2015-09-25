package ru.nullpointer.currency.rate.service;

import java.time.LocalDate;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ru.nullpointer.currency.rate.domain.Rate;
import ru.nullpointer.currency.rate.repo.CurrencyRepository;

/**
 *
 * @author Alexander Yastrebov
 */
@Service
public class CurrencyService {

    @Resource
    private CurrencyRepository currencyRepository;

    public Optional<Rate> getRate(String code) {
        return currencyRepository.getRate(code, LocalDate.now().plusDays(1));
    }

    public Optional<Rate> getRate(String code, LocalDate date) {
        return currencyRepository.getRate(code, date);
    }
}
