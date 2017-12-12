package com.example.moviemagic.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Internal annotation to mark pieces of code as knowingly untested.  There is a balance to strike
 * between test coverage and productivity.  Sometimes you need to isolate a small chunk of super
 * hard to test code and just mock or stub that in your tests with the acceptance of the risk and a
 * leap of faith that the untested code will work as expected.
 */
@Retention(RetentionPolicy.SOURCE)
public @interface Untested {
    /**
     * Optional value to supply a comment as to why this annotation is being used in a particular
     * case.
     *
     * @return The optional comment added to the annotation.
     */
    String value() default "";
}
