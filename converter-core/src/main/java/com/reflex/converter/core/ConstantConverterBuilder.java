package com.reflex.converter.core;

import com.reflex.converter.Converter;
import com.reflex.converter.ConverterBuilder;

/**
 * Created by rcbose on 2/7/2015.
 */
public class ConstantConverterBuilder<F, T> implements ConverterBuilder<F, T> {
    private T constant;

    @Override
    public Converter<F, T> build() {
        return new Converter<F, T>() {
            @Override
            public T convert(F f, T d) {
                return constant;
            }
        };
    }
}
