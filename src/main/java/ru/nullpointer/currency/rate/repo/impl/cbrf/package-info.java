@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.class),
    @XmlJavaTypeAdapter(type = BigDecimal.class, value = BigDecimalAdapter.class)
})
package ru.nullpointer.currency.rate.repo.impl.cbrf;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
