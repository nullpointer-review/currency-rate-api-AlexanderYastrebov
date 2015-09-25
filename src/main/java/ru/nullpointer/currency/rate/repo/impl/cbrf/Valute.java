package ru.nullpointer.currency.rate.repo.impl.cbrf;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Alexander Yastrebov
 */
public class Valute {

    private String code;
    private int nominal;
    private BigDecimal value;

    @XmlElement(name = "CharCode")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name = "Nominal")
    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    @XmlElement(name = "Value")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Valute{"
                + "code=" + code
                + ", nominal=" + nominal
                + ", value=" + value
                + '}';
    }
}
