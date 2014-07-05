package com.mischamichael.catchemall02.app;
// ----------------------------------------------------------------------------
/**
 * Stores two objects in a single object.
 *
 * @param <X> - The first object to be stored.
 * @param <Y> - The second object to be stored.
 *
 * @author Steffen Moseley (scm)
 * @version 2014.04.10
 */
public class Tuple<X, Y>
{
    // ~ Fields ................................................................

    /** The first stored object. */
    public X x;

    /** The second stored object. */
    public Y y;

    // ~ Methods ...............................................................
    // ------------------------------------------------------------------------
    /**
     * Takes two objects as parameters and stores them in global variables.
     * @param x - The first object to be stored.
     * @param y - The second object to be stored.
     */
    public Tuple(X x, Y y)
    {
        this.x = x;
        this.y = y;
    }

    // ------------------------------------------------------------------------
    /**
     * Retrieves the first object stored.
     * @return The first object stored.
     */
    public X getX()
    {
        return x;
    }

    // ------------------------------------------------------------------------
    /**
     * Retrieves the second object stored.
     * @return The second object stored.
     */
    public Y getY()
    {
        return y;
    }
}