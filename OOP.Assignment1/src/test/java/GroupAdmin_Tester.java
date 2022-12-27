import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupAdmin_Tester {
    @Test
    /**
     * testing the GroupAdmin functions
     */
    void test1()
    {
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember maor = new ConcreteMember("Maor", admin);
        ConcreteMember raz = new ConcreteMember("Raz", admin);

        admin.register(maor);
        admin.register(raz);

        admin.append("appened");
        assertEquals("appened" ,admin.getUsb().toString());
        assertEquals("appened" ,raz.getUsb().toString());
        assertEquals("appened" ,maor.getUsb().toString());

        admin.delete(0,2);
        assertEquals("pened" ,admin.getUsb().toString());
        assertEquals("pened" ,raz.getUsb().toString());
        assertEquals("pened" ,maor.getUsb().toString());

        admin.undo();
        assertEquals("appened" ,admin.getUsb().toString());
        assertEquals("appened" ,raz.getUsb().toString());
        assertEquals("appened" ,maor.getUsb().toString());

        admin.insert(0,"inserted ");
        assertEquals("inserted appened" ,admin.getUsb().toString());
        assertEquals("inserted appened" ,raz.getUsb().toString());
        assertEquals("inserted appened" ,maor.getUsb().toString());

        admin.unregister(maor);

        GroupAdmin admin2 = new GroupAdmin();
        admin2.register(maor);
        admin2.append("admin2 is now here");
        assertEquals("admin2 is now here" ,maor.getUsb().toString());




    }

}
