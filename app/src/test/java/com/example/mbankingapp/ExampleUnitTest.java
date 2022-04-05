package com.example.mbankingapp;

import org.junit.Before;
import org.junit.Test;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

/**
 * Example local unit test, which will execute on the development machine (host).
 *s
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Context instrumentationContext;

    @Before
    public void setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().getContext();
    }

    @Test
    public void addition_isCorrect() {
        System.out.println("Bla");

    }
}