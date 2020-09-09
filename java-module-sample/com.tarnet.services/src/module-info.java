import com.tarnet.common.interfaces.INotificationService;
import com.tarnet.services.notification.APNService;
import com.tarnet.services.notification.EmailService;
import com.tarnet.services.notification.SMSService;

module com.tarnet.services {
    requires com.tarnet.common;
    provides INotificationService with APNService,EmailService,SMSService;
}