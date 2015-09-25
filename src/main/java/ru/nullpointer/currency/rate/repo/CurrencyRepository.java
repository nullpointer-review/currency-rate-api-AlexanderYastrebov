package ru.nullpointer.currency.rate.repo;

import java.util.Optional;
import ru.nullpointer.currency.rate.domain.Rate;

/**
 *
 * @author Alexander Yastrebov
 */
public interface CurrencyRepository {

    Optional<Rate> getRate(String code);
}
