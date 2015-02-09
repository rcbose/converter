package com.reflex.converter.core;

import com.reflex.converter.ConverterBuilder;
import com.reflex.converter.core.BigDecimalConverterBuilder;
import com.reflex.converter.core.string.AppendConverterBuilder;

/**
 * Created by rcbose on 2/7/2015.
 */
public abstract class StringConverterBuilder<F> implements ConverterBuilder<F, String> {

    public AppendConverterBuilder<F> append(final ConverterBuilder<F, String> bBuilder) {
        return new AppendConverterBuilder<F>(this, bBuilder);
    }

    public BigDecimalConverterBuilder<F> toBigDecimal(){
        return new BigDecimalConverterBuilder<F>(this);
    }

}


