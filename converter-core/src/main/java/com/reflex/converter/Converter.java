package com.reflex.converter;

/**
 * Created by rcbose on 2/7/2015.
 */
public interface Converter<F, T> {
   T convert(F f, T d);
}
