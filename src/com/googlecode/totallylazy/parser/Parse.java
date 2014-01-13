package com.googlecode.totallylazy.parser;

import com.googlecode.totallylazy.Function;
import com.googlecode.totallylazy.Functor;

import java.nio.CharBuffer;

public interface Parse<A> extends Functor<A> {
    Result<A> parse(CharBuffer sequence) throws Exception;

    @Override
    <S> Parse<S> map(Function<? super A, ? extends S> callable);

    class functions {
        public static <A> Function<CharBuffer, Result<A>> parse(final Parse<A> parser) {
            return new Function<CharBuffer, Result<A>>() {
                @Override
                public Result<A> call(CharBuffer characterSegment) throws Exception {
                    return parser.parse(characterSegment);
                }
            };
        }
    }
}
