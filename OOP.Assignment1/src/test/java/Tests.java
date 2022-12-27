import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    /**
     * testing the memory consumption by using
     * GroupAdmin, ConcreteMembers, and UndoableStringBuilder
     */
    public void test(){
      //  System.out.println(JvmUtilities.objectTotalSize());

        GroupAdmin admin = new GroupAdmin();
        System.out.println("admin mem: "+JvmUtilities.objectTotalSize(admin));

        GroupAdmin admin2 = new GroupAdmin();
        System.out.println("admin2 mem: "+JvmUtilities.objectTotalSize(admin2));

        ConcreteMember maor = new ConcreteMember("Maor",admin);
        System.out.println("maor mem: "+JvmUtilities.objectTotalSize(maor));


        admin.register(maor);
        admin.append("hello");
        assertEquals("hello" ,maor.getUsb().toString());
        System.out.println("admin mem: "+JvmUtilities.objectTotalSize(admin));

        admin.unregister(maor);
        maor = new ConcreteMember("Maor", admin2);
        admin2.register(maor);
        admin2.append("appened");
        assertEquals("appened" ,maor.getUsb().toString());
        System.out.println("admin2 mem: "+JvmUtilities.objectTotalSize(admin2));

        admin2.delete(0,2);
        assertEquals("pened" ,maor.getUsb().toString());
        System.out.println("admin2 mem: "+JvmUtilities.objectTotalSize(admin2));

        admin2.undo();
        assertEquals("appened" ,maor.getUsb().toString());
        System.out.println("admin2 mem (after undo): "+JvmUtilities.objectTotalSize(admin2));

        admin2.insert(0,"inserted ");
        assertEquals("inserted appened" ,maor.getUsb().toString());
        System.out.println("admin2 mem: "+JvmUtilities.objectTotalSize(admin2));

        System.out.println("maor mem: "+JvmUtilities.objectTotalSize(maor));

    }
}
