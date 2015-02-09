package com.reflex.converter.core;

import com.reflex.converter.Converter;
import com.reflex.converter.ConverterBuilder;

import java.math.BigDecimal;

/**
 * Created by rcbose on 2/7/2015.
 */
public class BigDecimalConverterBuilder<F> implements ConverterBuilder<F, BigDecimal> {

    private ConverterBuilder<F, String> textBuilder;

    public BigDecimalConverterBuilder(ConverterBuilder<F, String> textBuilder) {
        this.textBuilder = textBuilder;
    }

    @Override
    public Converter<F, BigDecimal> build() {
        final Converter<F, String> textConverter = textBuilder.build();
        return new Converter<F, BigDecimal>() {
            @Override
            public BigDecimal convert(F f, BigDecimal d) {
                String defaultStr = null;
                if (d != null) {
                    defaultStr = d.toPlainString();
                }
                String sT = textConverter.convert(f, defaultStr);
                return new BigDecimal(sT);
            }
        };
    }

    public BigDecimalConverterBuilder<F> add(final ConverterBuilder<F, BigDecimal> bBuilder)
    {
        final BigDecimalConverterBuilder<F> aBuilder = this;
        return new BigDecimalConverterBuilder<F>(textBuilder){
            @Override
            public Converter<F, BigDecimal> build() {
                final Converter<F, BigDecimal> aConverter = aBuilder.build();
                final Converter<F, BigDecimal> bConverter = aBuilder.build();
                return new Converter<F, BigDecimal>() {
                    @Override
                    public BigDecimal convert(F f, BigDecimal d) {
                        BigDecimal a = aConverter.convert(f, d);
                        BigDecimal b = bConverter.convert(f, d);
                        if (a == null)
                        {
                            return b;
                        }
                        else if (b == null){
                            return a;
                        }
                        else {
                            return a.add(b);
                        }
                    }
                };
            }
        };
    }


}
