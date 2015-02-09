package com.reflex.converter.core.string;

import com.reflex.converter.Converter;
import com.reflex.converter.ConverterBuilder;
import com.reflex.converter.core.StringConverterBuilder;

/**
 * Created by rcbose on 2/8/2015.
 */
public class SubstringConverterBuilder<F> extends StringConverterBuilder<F> {

    private ConverterBuilder<F, String> stringConverterBuilder;
    private int beginIndex = 0, endIndex = -1;

    @Override
    public Converter<F, String> build() {
        final Converter<F, String> stringConverter = stringConverterBuilder.build();
        return new Converter<F, String>() {
            @Override
            public String convert(F f, String d) {
                String sOut = stringConverter.convert(f, null);
                if (sOut != null) {
                    if (endIndex < 0) {
                        return sOut.substring(beginIndex);
                    } else {
                        return sOut.substring(beginIndex, endIndex);
                    }
                }
                return null;
            }
        };
    }
}