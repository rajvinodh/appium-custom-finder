package execute;

import io.appium.java_client.AppiumDriver;

import java.util.Map;

public class ExecuteMobileCommand {
    AppiumDriver driver;

    public ExecuteMobileCommand(AppiumDriver driver) {
        this.driver = driver;
    }

        public enum MobileComamnd {
            /* UIAUTOMATOR2 DRIVER related Mobile commands */
            MOBILE_SHELL("mobile:shell"),
            ACCEPT_ALERT("mobile:acceptAlert"),
            DISMISS_ALERT("mobile:dismissAlert"),
            DEVICE_INFO("mobile:deviceInfo"),
            GET_PERMISSSIONS("mobile:getPermissions"),
            CHANGE_PERMISSIONS("mobile:changePermissions"),
            MOBILE_DEEPLINK("mobile:deepLink"),
            MOBILE_LIST_SMS("mobile:listSms"),
            MOBILE_GET_NOTIFICATIONS("mobile:getNotifications"),


            /* EXPRESSO DRIVER related Mobile commands */
            TOAST_VISIBLE("mobile:isToastVisible"),
            BACKDOOR("mobile:backdoor");


            private final String value;

            MobileComamnd(String value) {
                this.value = value;
            }

            public String getValue() {
                return value;
            }
        }

        public Object execute(MobileComamnd command, Map<String, Object>...args) {
            if(args.length == 0) {
                return driver.executeScript(command.getValue());
            } else if(args.length == 1) {
                return driver.executeScript(command.getValue(), args[0]);
            } else {
                System.err.println("Number of args should be only 1 or empty");
                return null;
            }
        }
}
