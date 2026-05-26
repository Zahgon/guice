/*
 *    Copyright 2009-2026 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.guice;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Simple static methods to be called at the start of your own methods to verify correct arguments and state. This
 * allows constructs such as
 *
 * <pre>
 * if (count <= 0) {
 *   throw new IllegalArgumentException("must be positive: " + count);
 * }
 * </pre>
 * <p>
 * to be replaced with the more compact
 * </p>
 *
 * <pre>
 * checkArgument(count > 0, "must be positive: %s", count);
 * </pre>
 * <p>
 * Note that the sense of the expression is inverted; with {@code Preconditions} you declare what you expect to be
 * <i>true</i>, just as you do with an <a href="http://java.sun.com/j2se/1.5.0/docs/guide/language/assert.html">
 * {@code assert}</a> or a JUnit {@code assertTrue()} call.
 * </p>
 * <p>
 * Take care not to confuse precondition checking with other similar types of checks! Precondition exceptions --
 * including those provided here, but also {@link IndexOutOfBoundsException}, {@link NoSuchElementException},
 * {@link UnsupportedOperationException} and others -- are used to signal that the <i>calling method</i> has made an
 * error. This tells the caller that it should not have invoked the method when it did, with the arguments it did, or
 * perhaps <i>ever</i>. Postcondition or other invariant failures should not throw these types of exceptions.
 * </p>
 * <p>
 * <b>Note:</b> The methods of the {@code Preconditions} class are highly unusual in one way: they are <i>supposed
 * to</i> throw exceptions, and promise in their specifications to do so even when given perfectly valid input. That is,
 * {@code null} is a valid parameter to the method {@link #checkNotNull(Object)} -- and technically this parameter could
 * be even marked as {@link com.google.inject.internal.util.Nullable} -- yet the method will still throw an exception
 * anyway, because that's what its contract says to do.
 * </p>
 * <p>
 * This class may be used with the Google Web Toolkit (GWT).
 * </p>
 *
 * @author Kevin Bourrillion
 */
final class Preconditions {

    private Preconditions() {
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param expression
     *          a boolean expression
     *
     * @throws IllegalArgumentException
     *           if {@code expression} is false
     */
    public static void checkArgument(boolean expression) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param expression
     *          a boolean expression
     * @param errorMessage
     *          the exception message to use if the check fails; will be converted to a string using
     *          {@link String#valueOf(Object)}
     *
     * @throws IllegalArgumentException
     *           if {@code expression} is false
     */
    public static void checkArgument(boolean expression, Object errorMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param expression
     *          a boolean expression
     * @param errorMessageTemplate
     *          a template for the exception message should the check fail. The message is formed by replacing each
     *          {@code %s} placeholder in the template with an argument. These are matched by position - the first
     *          {@code %s} gets {@code errorMessageArgs[0]}, etc. Unmatched arguments will be appended to the formatted
     *          message in square braces. Unmatched placeholders will be left as-is.
     * @param errorMessageArgs
     *          the arguments to be substituted into the message template. Arguments are converted to strings using
     *          {@link String#valueOf(Object)}.
     *
     * @throws IllegalArgumentException
     *           if {@code expression} is false
     * @throws NullPointerException
     *           if the check fails and either {@code
     *     errorMessageTemplate} or {@code errorMessageArgs} is null (don't let this happen)
     */
    public static void checkArgument(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not involving any parameters to
     * the calling method.
     *
     * @param expression
     *          a boolean expression
     *
     * @throws IllegalStateException
     *           if {@code expression} is false
     */
    public static void checkState(boolean expression) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not involving any parameters to
     * the calling method.
     *
     * @param expression
     *          a boolean expression
     * @param errorMessage
     *          the exception message to use if the check fails; will be converted to a string using
     *          {@link String#valueOf(Object)}
     *
     * @throws IllegalStateException
     *           if {@code expression} is false
     */
    public static void checkState(boolean expression, Object errorMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not involving any parameters to
     * the calling method.
     *
     * @param expression
     *          a boolean expression
     * @param errorMessageTemplate
     *          a template for the exception message should the check fail. The message is formed by replacing each
     *          {@code %s} placeholder in the template with an argument. These are matched by position - the first
     *          {@code %s} gets {@code errorMessageArgs[0]}, etc. Unmatched arguments will be appended to the formatted
     *          message in square braces. Unmatched placeholders will be left as-is.
     * @param errorMessageArgs
     *          the arguments to be substituted into the message template. Arguments are converted to strings using
     *          {@link String#valueOf(Object)}.
     *
     * @throws IllegalStateException
     *           if {@code expression} is false
     * @throws NullPointerException
     *           if the check fails and either {@code
     *     errorMessageTemplate} or {@code errorMessageArgs} is null (don't let this happen)
     */
    public static void checkState(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *          an object reference
     *
     * @return the non-null reference that was validated
     *
     * @throws NullPointerException
     *           if {@code reference} is null
     */
    public static <T> T checkNotNull(T reference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *          an object reference
     * @param errorMessage
     *          the exception message to use if the check fails; will be converted to a string using
     *          {@link String#valueOf(Object)}
     *
     * @return the non-null reference that was validated
     *
     * @throws NullPointerException
     *           if {@code reference} is null
     */
    public static <T> T checkNotNull(T reference, Object errorMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *          an object reference
     * @param errorMessageTemplate
     *          a template for the exception message should the check fail. The message is formed by replacing each
     *          {@code %s} placeholder in the template with an argument. These are matched by position - the first
     *          {@code %s} gets {@code errorMessageArgs[0]}, etc. Unmatched arguments will be appended to the formatted
     *          message in square braces. Unmatched placeholders will be left as-is.
     * @param errorMessageArgs
     *          the arguments to be substituted into the message template. Arguments are converted to strings using
     *          {@link String#valueOf(Object)}.
     *
     * @return the non-null reference that was validated
     *
     * @throws NullPointerException
     *           if {@code reference} is null
     */
    public static <T> T checkNotNull(T reference, String errorMessageTemplate, Object... errorMessageArgs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that an {@code Iterable} object passed as a parameter to the calling method is not null and contains no
     * null elements.
     *
     * @param iterable
     *          the iterable to check the contents of
     *
     * @return the non-null {@code iterable} reference just validated
     *
     * @throws NullPointerException
     *           if {@code iterable} is null or contains at least one null element
     */
    public static <T extends Iterable<?>> T checkContentsNotNull(T iterable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that an {@code Iterable} object passed as a parameter to the calling method is not null and contains no
     * null elements.
     *
     * @param iterable
     *          the iterable to check the contents of
     * @param errorMessage
     *          the exception message to use if the check fails; will be converted to a string using
     *          {@link String#valueOf(Object)}
     *
     * @return the non-null {@code iterable} reference just validated
     *
     * @throws NullPointerException
     *           if {@code iterable} is null or contains at least one null element
     */
    public static <T extends Iterable<?>> T checkContentsNotNull(T iterable, Object errorMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that an {@code Iterable} object passed as a parameter to the calling method is not null and contains no
     * null elements.
     *
     * @param iterable
     *          the iterable to check the contents of
     * @param errorMessageTemplate
     *          a template for the exception message should the check fail. The message is formed by replacing each
     *          {@code %s} placeholder in the template with an argument. These are matched by position - the first
     *          {@code %s} gets {@code errorMessageArgs[0]}, etc. Unmatched arguments will be appended to the formatted
     *          message in square braces. Unmatched placeholders will be left as-is.
     * @param errorMessageArgs
     *          the arguments to be substituted into the message template. Arguments are converted to strings using
     *          {@link String#valueOf(Object)}.
     *
     * @return the non-null {@code iterable} reference just validated
     *
     * @throws NullPointerException
     *           if {@code iterable} is null or contains at least one null element
     */
    public static <T extends Iterable<?>> T checkContentsNotNull(T iterable, String errorMessageTemplate, Object... errorMessageArgs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean containsOrIsNull(Iterable<?> iterable) {
        if (iterable == null) {
            return true;
        }
        if (iterable instanceof Collection) {
            Collection<?> collection = (Collection<?>) iterable;
            try {
                return collection.contains(null);
            } catch (NullPointerException e) {
                // A NPE implies that the collection doesn't contain null.
                return false;
            }
        } else {
            for (Object element : iterable) {
                if (element == null) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Ensures that {@code index} specifies a valid <i>element</i> in an array, list or string of size {@code size}. An
     * element index may range from zero, inclusive, to {@code size}, exclusive.
     *
     * @param index
     *          a user-supplied index identifying an element of an array, list or string
     * @param size
     *          the size of that array, list or string
     *
     * @throws IndexOutOfBoundsException
     *           if {@code index} is negative or is not less than {@code size}
     * @throws IllegalArgumentException
     *           if {@code size} is negative
     */
    public static void checkElementIndex(int index, int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that {@code index} specifies a valid <i>element</i> in an array, list or string of size {@code size}. An
     * element index may range from zero, inclusive, to {@code size}, exclusive.
     *
     * @param index
     *          a user-supplied index identifying an element of an array, list or string
     * @param size
     *          the size of that array, list or string
     * @param desc
     *          the text to use to describe this index in an error message
     *
     * @throws IndexOutOfBoundsException
     *           if {@code index} is negative or is not less than {@code size}
     * @throws IllegalArgumentException
     *           if {@code size} is negative
     */
    public static void checkElementIndex(int index, int size, String desc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that {@code index} specifies a valid <i>position</i> in an array, list or string of size {@code size}. A
     * position index may range from zero to {@code size}, inclusive.
     *
     * @param index
     *          a user-supplied index identifying a position in an array, list or string
     * @param size
     *          the size of that array, list or string
     *
     * @throws IndexOutOfBoundsException
     *           if {@code index} is negative or is greater than {@code size}
     * @throws IllegalArgumentException
     *           if {@code size} is negative
     */
    public static void checkPositionIndex(int index, int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that {@code index} specifies a valid <i>position</i> in an array, list or string of size {@code size}. A
     * position index may range from zero to {@code size}, inclusive.
     *
     * @param index
     *          a user-supplied index identifying a position in an array, list or string
     * @param size
     *          the size of that array, list or string
     * @param desc
     *          the text to use to describe this index in an error message
     *
     * @throws IndexOutOfBoundsException
     *           if {@code index} is negative or is greater than {@code size}
     * @throws IllegalArgumentException
     *           if {@code size} is negative
     */
    public static void checkPositionIndex(int index, int size, String desc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Ensures that {@code start} and {@code end} specify a valid <i>positions</i> in an array, list or string of size
     * {@code size}, and are in order. A position index may range from zero to {@code size}, inclusive.
     *
     * @param start
     *          a user-supplied index identifying a starting position in an array, list or string
     * @param end
     *          a user-supplied index identifying a ending position in an array, list or string
     * @param size
     *          the size of that array, list or string
     *
     * @throws IndexOutOfBoundsException
     *           if either index is negative or is greater than {@code size}, or if {@code end} is less than {@code start}
     * @throws IllegalArgumentException
     *           if {@code size} is negative
     */
    public static void checkPositionIndexes(int start, int end, int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Substitutes each {@code %s} in {@code template} with an argument. These are matched by position - the first
     * {@code %s} gets {@code args[0]}, etc. If there are more arguments than placeholders, the unmatched arguments will
     * be appended to the end of the formatted message in square braces.
     *
     * @param template
     *          a non-null string containing 0 or more {@code %s} placeholders.
     * @param args
     *          the arguments to be substituted into the message template. Arguments are converted to strings using
     *          {@link String#valueOf(Object)}. Arguments can be null.
     */
    // VisibleForTesting
    static String format(String template, Object... args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
