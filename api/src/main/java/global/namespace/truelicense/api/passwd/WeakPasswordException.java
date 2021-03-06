/*
 * Copyright (C) 2005-2017 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package global.namespace.truelicense.api.passwd;

import java.security.GeneralSecurityException;

/**
 * Indicates that a password is considered to be too weak.
 *
 * @author Christian Schlichtherle
 */
public class WeakPasswordException extends GeneralSecurityException {

    private static final long serialVersionUID = 0L;
}
