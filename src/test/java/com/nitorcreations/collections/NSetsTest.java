package com.nitorcreations.collections;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import static com.nitorcreations.test.TestUtils.invokePrivateConstructor;
import static com.nitorcreations.collections.NSets.asSet;
import static java.util.Arrays.asList;
import static com.nitorcreations.test.Assertions.assertThat;

public class NSetsTest {

    @Test
    public void forCoverage() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        invokePrivateConstructor(NSets.class);
    }

    @Test
    public void testAsSet() {
        final Set<String> strings = asSet("foo", "bar", "baz");
        assertThat(strings).contains("foo", "bar", "baz");
    }

    @Test
    public void testAsSet_nullValues() {
        final Set<String> foo = asSet(null, null, null, "Foo");
        assertThat(foo).hasSize(2).contains(null, "Foo");
    }

    @Test
    public void testAsSet_iterable() {
        final Set<String> strings = asSet(asList("foo", "bar", "baz"));
        assertThat(strings).contains("foo", "bar", "baz");
    }

    @Test
    public void testAsSet_iterator() {
        final Set<String> strings = asSet(asList("foo", "bar", "baz").iterator());
        assertThat(strings).contains("foo", "bar", "baz");
    }
}