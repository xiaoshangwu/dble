/*
 * Copyright (C) 2016-2017 ActionTech.
 * License: http://www.gnu.org/licenses/gpl.html GPL version 2 or higher.
 */

package com.actiontech.dble.backend.mysql.nio.handler.query;

import com.actiontech.dble.backend.mysql.nio.handler.ResponseHandler;

import java.util.Set;

public interface DMLResponseHandler extends ResponseHandler {
    enum HandlerType {
        DIRECT, TEMPTABLE, BASESEL, REFRESHFP, MERGE, JOIN, WHERE, GROUPBY, HAVING, ORDERBY, LIMIT, UNION, DISTINCT, SENDMAKER, FINAL, SCALAR_SUB_QUERY, IN_SUB_QUERY, ALL_ANY_SUB_QUERY
    }

    HandlerType type();

    DMLResponseHandler getNextHandler();

    void setNextHandler(DMLResponseHandler next);

    Set<DMLResponseHandler> getMerges();

    boolean isAllPushDown();

    void setAllPushDown(boolean allPushDown);

    void setLeft(boolean left);

    void terminate();

}
