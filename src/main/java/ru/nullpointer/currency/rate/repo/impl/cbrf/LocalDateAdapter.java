package ru.nullpointer.currency.rate.repo.impl.cbrf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Alexander Yastrebov
 */
class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, FORMATTER);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(FORMATTER);
    }
}
