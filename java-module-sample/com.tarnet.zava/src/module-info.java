import com.tarnet.common.interfaces.INotificationService;
import com.tarnet.zava.ZavaNotificationService;

module com.tarnet.zava {
    requires com.tarnet.common;
    provides INotificationService with ZavaNotificationService;

}