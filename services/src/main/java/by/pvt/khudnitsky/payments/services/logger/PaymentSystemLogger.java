/**
 * Copyright (c) 2016, Khudnitsky. All rights reserved.
 */
package by.pvt.khudnitsky.payments.services.logger;

import org.apache.log4j.Logger;

/**
 * @author khudnitsky
 * @version 1.0
 *
 */
public enum PaymentSystemLogger {
    INSTANCE;
    private Logger logger;

    @SuppressWarnings("rawtypes")
    public void logError(Class sender, String message){
        logger = Logger.getLogger(sender);
        logger.error(message);
    }


}
