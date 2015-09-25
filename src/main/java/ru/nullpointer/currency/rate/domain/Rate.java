package ru.nullpointer.currency.rate.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Alexander Yastrebov
 */
public class Rate {

    private String code;
    private BigDecimal rate;
    private LocalDate date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Rate{"
                + "code=" + code
                + ", rate=" + rate
                + ", date=" + date
                + '}';
    }
}
