package ru.nullpointer.currency.rate.repo;

import java.time.LocalDate;
import java.util.Optional;
import ru.nullpointer.currency.rate.domain.Rate;

/**
 *
 * @author Alexander Yastrebov
 */
public interface CurrencyRepository {

    Optional<Rate> getRate(String code, LocalDate date);
}
