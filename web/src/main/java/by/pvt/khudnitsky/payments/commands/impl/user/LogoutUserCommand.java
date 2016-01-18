/**
 * Copyright (c) 2016, Khudnitsky. All rights reserved.
 */
package by.pvt.khudnitsky.payments.commands.impl.user;

import javax.servlet.http.HttpServletRequest;

import by.pvt.khudnitsky.payments.commands.AbstractCommand;
import by.pvt.khudnitsky.payments.constants.ConfigConstant;
import by.pvt.khudnitsky.payments.constants.PagePath;
import by.pvt.khudnitsky.payments.managers.ConfigurationManagerImpl;

/**
 * @author khudnitsky
 * @version 1.0
 *
 */
public class LogoutUserCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManagerImpl.getInstance().getProperty(PagePath.INDEX_PAGE_PATH);
        request.getSession().invalidate();
        return page;
    }
}
