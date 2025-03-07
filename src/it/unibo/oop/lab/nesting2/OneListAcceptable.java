package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * Solution to sample exam assignment.
 * 
 * @param <T>
 */
public class OneListAcceptable<T> implements Acceptable<T> {

    private final List<T> list;

    /**
     * 
     * @param list
     *            the list of elements representing the right sequence to be
     *            accepted
     */
    public OneListAcceptable(final List<T> list) {
        this.list = list;
    }

    @Override
    public Acceptor<T> acceptor() {
        final Iterator<T> iterator = list.iterator();
        return new Acceptor<T>() {

            /**
             * @param newElement
             *            the new element to be accepted
             */
            @Override
            public void accept(final T newElement) throws Acceptor.ElementNotAcceptedException {
                if (!iterator.hasNext() || !newElement.equals(iterator.next())) {
                    throw new Acceptor.ElementNotAcceptedException(newElement);
                }
            }

            @Override
            public void end() throws Acceptor.EndNotAcceptedException {
                if (iterator.hasNext()) {
                    throw new Acceptor.EndNotAcceptedException();
                }
            }
        };
    }
}