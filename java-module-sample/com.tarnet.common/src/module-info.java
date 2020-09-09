import com.tarnet.common.impl.FakeNotificationService;
import com.tarnet.common.interfaces.INotificationService;

open module com.tarnet.common {
    exports com.tarnet.common.interfaces;
    //exports com.tarnet.common.impl;// to com.tarnet.client,com.tarnet.zava;
    provides INotificationService with FakeNotificationService;
//    opens com.tarnet.common.impl to com.tarnet.zava;
}