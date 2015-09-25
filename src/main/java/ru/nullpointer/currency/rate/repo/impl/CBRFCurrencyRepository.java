package ru.nullpointer.currency.rate.repo.impl;

import ru.nullpointer.currency.rate.domain.Rate;
import ru.nullpointer.currency.rate.repo.CurrencyRepository;

/**
 *
 * @author Alexander Yastrebov
 */
public class CBRFCurrencyRepository implements CurrencyRepository {

    @Override
    public Rate getRate(String code) {
        Rate r = new Rate();
        r.setCode(code);
        r.setRate("66.0410");
        r.setDate("2015-09-24");

        return r;
    }
}
