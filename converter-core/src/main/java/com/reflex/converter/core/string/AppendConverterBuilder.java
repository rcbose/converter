package com.reflex.converter.core.string;

import com.reflex.converter.Converter;
import com.reflex.converter.ConverterBuilder;
import com.reflex.converter.core.StringConverterBuilder;

/**
 * Created by rcbose on 2/8/2015.
 */
public class AppendConverterBuilder<F> extends StringConverterBuilder<F> {
    private ConverterBuilder<F, String> aBuilder, bBuilder;

    public AppendConverterBuilder(ConverterBuilder<F, String> aBuilder, ConverterBuilder<F, String> bBuilder) {
        this.aBuilder = aBuilder;
        this.bBuilder = bBuilder;
    }

    @Override
    public Converter<F, String> build() {
        final Converter<F, String> aConverter = aBuilder.build();
        final Converter<F, String> bConverter = aBuilder.build();
        return new Converter<F, String>() {
            @Override
            public String convert(F f, String d) {
                String a = aConverter.convert(f, d);
                String b = bConverter.convert(f, d);
                if (a == null) {
                    return b;
                } else if (b == null) {
                    return a;
                } else {
                    return a + b;
                }
            }
        };
    }
}
