package com.example.moviemagic.roboelectric;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;

/**
 * Roboelectric base class
 */

public class MovieMagicTestRunner extends RobolectricTestRunner {
    public MovieMagicTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
