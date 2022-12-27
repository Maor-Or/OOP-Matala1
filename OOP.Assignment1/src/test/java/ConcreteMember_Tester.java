import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcreteMember_Tester {
    @Test
    /**
     * testing the ConcreteMember functionality
     */
    void test1()
    {
        GroupAdmin admin = new GroupAdmin();
        GroupAdmin admin2 = new GroupAdmin();

        ConcreteMember maor = new ConcreteMember("Maor",admin);

        admin.register(maor);
        admin.append("hello");
        assertEquals("hello" ,maor.getUsb().toString());

        admin.unregister(maor);
        maor = new ConcreteMember("Maor", admin2);
        admin2.register(maor);
        admin2.append("appened");
        assertEquals("appened" ,maor.getUsb().toString());

        admin2.delete(0,2);
        assertEquals("pened" ,maor.getUsb().toString());

        admin2.undo();
        assertEquals("appened" ,maor.getUsb().toString());

        admin2.insert(0,"inserted ");
        assertEquals("inserted appened" ,maor.getUsb().toString());


    }
}
