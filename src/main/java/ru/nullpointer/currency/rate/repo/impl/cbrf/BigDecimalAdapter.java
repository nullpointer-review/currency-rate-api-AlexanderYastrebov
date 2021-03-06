package ru.nullpointer.currency.rate.repo.impl.cbrf;

import java.math.BigDecimal;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Alexander Yastrebov
 */
class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    @Override
    public BigDecimal unmarshal(String v) throws Exception {
        return new BigDecimal(v.replace(',', '.'));
    }

    @Override
    public String marshal(BigDecimal v) throws Exception {
        return v.toString().replace('.', ',');
    }
}
