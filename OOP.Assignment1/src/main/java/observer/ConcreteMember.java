package observer;

/**
 * This class is the observer in an Observer Pattern assignment
 *
 * @author Raz Saad
 * @author Maor Or
 */
public class ConcreteMember implements Member {

    /**
     * Class attributes:
     * name - the name of the observer
     * usb - the UndoableStringBuilder which is the subject that is being observed,
     * shallow copied from the observable's usb
     * it is being modified by the GroupAdmin and for each change the members are notified
     * ga - the observable object
     */
    private String name;
    private UndoableStringBuilder usb;
    private GroupAdmin ga;

    /**
     * constructor that connects the observer with it's observable
     * @param name - the name of the observer
     * @param ga - the observable
     */
    public ConcreteMember(String name, GroupAdmin ga) {
        this.usb = ga.getUsb();
        this.name = name;
        this.ga = ga;

    }

    /**
     * @return the usb address of the specific member for testings.
     */
    public UndoableStringBuilder getUsb()
    {
        return this.usb;
    }


    /**
     * updates the observer with the new usb state
     *
     * @param usb - the usb that is being observed and updated
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
        System.out.println(name + " has gotten an update! current state is: " + usb);
    }

}
