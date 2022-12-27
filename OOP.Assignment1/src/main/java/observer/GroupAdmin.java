package observer;

import java.util.ArrayList;

/**
 * This class is the observable in an Observer Pattern assignment
 *
 * @author Raz Saad
 * @author Maor Or
 */

public class GroupAdmin implements Sender {//observable

    /**
     * Class attributes:
     * members - an array list of the members (observers) that get notified when an update is occurred
     * usb - the UndoableStringBuilder which is the subject that is being observed,
     * it is being modified by the GroupAdmin and for each change the members are notified
     */
    private ArrayList<Member> members = new ArrayList<Member>();
    private UndoableStringBuilder usb = new UndoableStringBuilder();

    /**
     * @return the usb address for a shallow copy
     */
    public UndoableStringBuilder getUsb() {
        return usb;
    }

    /**
     * registers a new member into the list
     *
     * @param member - the member to add into the members list
     */
    @Override
    public void register(Member member) {
        members.add(member);
    }

    /**
     * removes an existing member from the list
     *
     * @param member - the member to remove from the members list
     */
    @Override
    public void unregister(Member member) {
        members.remove(member);
    }

    /**
     * Inserts the string into this character sequence, and then updates the members
     *
     * @param offset - the offset
     * @param s      - a string to insert
     */
    @Override
    public void insert(int offset, String s) {
        usb.insert(offset, s);
        notifyMembers();
    }

    /**
     * Appends the specified string to this character sequence, and then updates the members
     *
     * @param s - a string to append
     */
    @Override
    public void append(String s) {
        usb.append(s);
        notifyMembers();
    }

    /**
     * Removes the characters in a substring of this sequence, and then updates the members
     *
     * @param start - the beginning index, inclusive
     * @param end   - the ending index, exclusive
     */
    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        notifyMembers();
    }

    /**
     * Erases the last change done to the document, reverting
     * it to an older state, and then updates the members
     */
    @Override
    public void undo() {
        usb.undo();
        notifyMembers();
    }

    /**
     * Notifying all members in the list,
     * this function is used in other functions in this class which require to update the members
     */
    public void notifyMembers() {
        for (Member m : members)
            m.update(usb);
    }

}
