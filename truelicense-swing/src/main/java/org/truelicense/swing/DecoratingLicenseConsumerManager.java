/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package org.truelicense.swing;

import org.truelicense.api.*;
import org.truelicense.api.io.Source;

import java.util.Objects;

/**
 * A decorator for a license consumer manager.
 *
 * @author Christian Schlichtherle
 */
abstract class DecoratingLicenseConsumerManager
implements LicenseConsumerManager {

    @SuppressWarnings({"PackageVisibleField"})
    protected LicenseConsumerManager manager;

    protected DecoratingLicenseConsumerManager() { }

    protected DecoratingLicenseConsumerManager(final LicenseConsumerManager manager) {
        this.manager = Objects.requireNonNull(manager);
    }

    @Override public String subject() { return manager.subject(); }

    @Override public LicenseParameters parameters() {
        return manager.parameters();
    }

    @Override public LicenseConsumerContext context() {
        return manager.context();
    }

    @Override
    public void install(Source source) throws LicenseManagementException {
        manager.install(source);
    }

    @Override public License view() throws LicenseManagementException {
        return manager.view();
    }

    @Override public void verify() throws LicenseManagementException {
        manager.verify();
    }

    @Override public void uninstall() throws LicenseManagementException {
        manager.uninstall();
    }
}