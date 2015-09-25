package ru.nullpointer.currency.rate.repo;

import ru.nullpointer.currency.rate.domain.Rate;

/**
 *
 * @author Alexander Yastrebov
 */
public interface CurrencyRepository {

    Rate getRate(String code);
}
