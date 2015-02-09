package com.reflex.converter.core.string;

import com.reflex.converter.Converter;
import com.reflex.converter.ConverterBuilder;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rcbose on 2/8/2015.
 */
public class SplitConverterBuilder<F> implements ConverterBuilder<F, Collection<String>> {
    private ConverterBuilder<F, String> stringConverterBuilder;
    private String regex = ",";

    public SplitConverterBuilder(ConverterBuilder<F, String> stringConverterBuilder) {
        this.stringConverterBuilder = stringConverterBuilder;
    }

    public SplitConverterBuilder(ConverterBuilder<F, String> stringConverterBuilder, String regex) {
        this.stringConverterBuilder = stringConverterBuilder;
        this.regex = regex;
    }

    @Override
    public Converter<F, Collection<String>> build() {
        final Converter<F, String> stringConverter = stringConverterBuilder.build();
        return new Converter<F, Collection<String>>() {
            @Override
            public Collection<String> convert(F f, Collection<String> d) {
                String sOut = stringConverter.convert(f, null);
                if (sOut != null) {
                    return Arrays.asList(sOut.split(regex));
                }

                return null;
            }
        };
    }
}
