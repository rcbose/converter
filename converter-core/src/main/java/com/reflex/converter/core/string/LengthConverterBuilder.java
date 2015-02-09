package com.reflex.converter.core.string;

import com.reflex.converter.Converter;
import com.reflex.converter.ConverterBuilder;

/**
 * Created by rcbose on 2/8/2015.
 */
public class LengthConverterBuilder<F> implements ConverterBuilder<F, Integer> {
    private ConverterBuilder<F, String> stringConverterBuilder;

    public LengthConverterBuilder(ConverterBuilder<F, String> stringConverterBuilder) {
        this.stringConverterBuilder = stringConverterBuilder;
    }

    @Override
    public Converter<F, Integer> build() {
        final Converter<F, String> stringConverter = stringConverterBuilder.build();
        return new Converter<F, Integer>() {
            @Override
            public Integer convert(F f, Integer d) {
                String sOut = stringConverter.convert(f, null);
                if (sOut != null) {
                    return sOut.length();
                }
                return null;
            }
        };
    }
}
