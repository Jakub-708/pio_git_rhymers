package edu.kis.vh.nursery;

/**
 * The FIFORhymer class extends DefaultCountingOutRhymer to implement
 * a First-In-First-Out (FIFO) counting mechanism.
 */
public class FIFORhymer extends DefaultCountingOutRhymer {

    /**
     * Temporary rhymer used to implement FIFO logic.
     */
    public final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Retrieves and removes the first element in FIFO order.
     *
     * This method overrides the countOut method in DefaultCountingOutRhymer.
     * It moves all elements to a temporary rhymer and then retrieves the first element.
     * After that, it restores the remaining elements back to the original rhymer.
     *
     * @return the first element in FIFO order
     */
    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
