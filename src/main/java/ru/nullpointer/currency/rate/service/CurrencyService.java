package ru.nullpointer.currency.rate.service;

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

    public Rate getRate(String code) {
        return currencyRepository.getRate(code);
    }
}
