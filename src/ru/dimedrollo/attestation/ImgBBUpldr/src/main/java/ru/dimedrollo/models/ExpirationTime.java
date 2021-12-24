package ru.dimedrollo.models;


/*
 * An instance of 'expiration time' upload parameter, provides easy access to long and string value.
 */
public class ExpirationTime {

    /**
     * Determined by site API, represents minimal time value (in minutes).
     * <p>
     * Value is <b>{@value}</b>.
     */
    public static final long MIN_VALUE = 1;
    /**
     * Determined by site API, represents maximal time value (in minutes).
     * <p>
     * Value is <b>{@value}</b>.
     */
    public static final long MAX_VALUE = 1814400;

    private final long time;

    private ExpirationTime(long time) {
        this.time = time;
    }

    /**
     * Creates new {@link ExpirationTime} instance using time value from a string.
     *
     * @param timeInSeconds time value as string.
     * @return The new expiration time instance.
     * @throws IllegalArgumentException when specified time value isn't long.
     * @throws IllegalArgumentException when specified time value isn't in the allowed range.
     * @see ExpirationTime#MIN_VALUE
     * @see ExpirationTime#MAX_VALUE
     */
    public static ExpirationTime fromString(String timeInSeconds) {
        try {
            long value = Long.parseLong(timeInSeconds);
            if (value < MIN_VALUE || value > MAX_VALUE)
                throw new IllegalArgumentException("The time parameter must be between " + MIN_VALUE + " and " + MAX_VALUE + "!");
            return new ExpirationTime(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The time parameter must have data type 'long'!");
        }
    }

    /**
     * Creates new {@link ExpirationTime} instance using time value from a long.
     *
     * @param timeInHours time value as long.
     * @return The new expiration time instance.
     * @throws IllegalArgumentException when specified time value isn't in the allowed range.
     * @see ExpirationTime#MIN_VALUE
     * @see ExpirationTime#MAX_VALUE
     */
    public static ExpirationTime fromLong(Long timeInHours) {
        if (timeInHours < MIN_VALUE || timeInHours > MAX_VALUE)
            throw new IllegalArgumentException("The time parameter must be between " + MIN_VALUE + " and " + MAX_VALUE + "!");
        return new ExpirationTime((long) (timeInHours * 360));
    }

    /**
     * Returns a time value as long.
     *
     * @return Current time value.
     */
    public long getAsLong() {
        return this.time;
    }

    /**
     * Returns a time value as string.
     *
     * @return Current time value.
     */
    public String getAsString() {
        return String.valueOf(this.time);
    }


}