/**
 * Copyright (c) 2016, Khudnitsky. All rights reserved.
 */
package by.pvt.khudnitsky.payments.services.commands.user;

import javax.servlet.http.HttpServletRequest;

import by.pvt.khudnitsky.payments.services.commands.AbstractCommand;
import by.pvt.khudnitsky.payments.services.constants.ConfigsConstants;
import by.pvt.khudnitsky.payments.services.managers.ConfigurationManager;

/**
 * @author khudnitsky
 * @version 1.0
 *
 */
public class LogoutUserCommand extends AbstractCommand{

    /* (non-Javadoc)
     * @see by.pvt.khudnitsky.payments.commands.Command#execute(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        request.getSession().invalidate();
        return page;
    }
}
