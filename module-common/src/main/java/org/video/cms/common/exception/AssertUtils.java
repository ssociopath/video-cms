package org.video.cms.common.exception;

import org.video.cms.common.response.SystemCodeEnum;

/**
 * @author bobo
 * @date 2020/12/3
 */

public class AssertUtils {
    public static void isTrue(boolean expression, ApplicationException exception) {
        if (!expression) {
            throw exception;
        }
    }

    public static void isTrue(boolean expression, SystemCodeEnum systemCode, String message) {
        if (!expression) {
            throw ApplicationException.withResponse(systemCode, message);
        }
    }

    public static void isTrue(boolean expression, SystemCodeEnum systemCode) {
        if (!expression) {
            throw ApplicationException.withResponse(systemCode);
        }
    }

    public static void isTrue(boolean expression, String argumentWrongMessage) {
        if (!expression) {
            throw ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, argumentWrongMessage);
        }
    }

    public static void isFalse(boolean expression, ApplicationException exception) {
        if (expression) {
            throw exception;
        }
    }

    public static void isNull(Object object, ApplicationException exception) {
        if (object != null) {
            throw exception;
        }
    }

    public static void notNull(Object object, ApplicationException exception) {
        if (object == null) {
            throw exception;
        }
    }

    public static void notNull(Object object, String argumentWrongMessage) {
        if (object == null) {
            throw ApplicationException.withResponse(SystemCodeEnum.ARGUMENT_WRONG, argumentWrongMessage);
        }
    }
}
