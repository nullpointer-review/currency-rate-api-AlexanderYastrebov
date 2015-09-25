package ru.nullpointer.currency.rate.repo.impl.cbrf;

import java.time.LocalDate;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander Yastrebov
 */
@XmlRootElement(name = "ValCurs")
public class ValCurs {

    private LocalDate date;
    private List<Valute> valutes;

    @XmlAttribute(name = "Date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @XmlElement(name = "Valute")
    public List<Valute> getValutes() {
        return valutes;
    }

    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }

    @Override
    public String toString() {
        return "ValCurs{"
                + "date=" + date
                + ", valutes=" + valutes
                + '}';
    }
}
