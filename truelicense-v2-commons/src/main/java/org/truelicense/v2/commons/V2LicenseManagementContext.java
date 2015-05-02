/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package org.truelicense.v2.commons;

import org.truelicense.api.License;
import org.truelicense.api.auth.RepositoryContext;
import org.truelicense.api.auth.RepositoryModel;
import org.truelicense.api.crypto.PbeParameters;
import org.truelicense.api.io.Transformation;
import org.truelicense.core.CommonLicenseManagementContext;
import org.truelicense.obfuscate.Obfuscate;
import org.truelicense.v2.commons.auth.V2RepositoryContext;
import org.truelicense.v2.commons.comp.V2Compression;
import org.truelicense.v2.commons.crypto.V2Encryption;

/**
 * The root context for the management of V2 format license keys.
 * This class is immutable.
 *
 * @author Christian Schlichtherle
 */
public abstract class V2LicenseManagementContext
extends CommonLicenseManagementContext {

    @Obfuscate
    private static final String STORE_TYPE = "JCEKS";

    @Obfuscate
    private static final String PBE_ALGORITHM = "PBEWithSHA1AndDESede";

    protected V2LicenseManagementContext(String subject) { super(subject); }

    /**
     * {@inheritDoc}
     * <p>
     * The implementation in the class {@link V2LicenseManagementContext}
     * returns a compression for V2 format license keys.
     */
    @Override
    public final Transformation compression() {
        return new V2Compression();
    }

    /**
     * {@inheritDoc}
     * <p>
     * The implementation in the class {@link V2LicenseManagementContext}
     * returns an encryption for V2 format license keys with the given PBE
     * parameters.
     */
    @Override
    public final Transformation encryption(PbeParameters parameters) {
        return new V2Encryption(parameters);
    }

    @Override
    public License license() { return new License(); }

    /**
     * {@inheritDoc}
     * <p>
     * The implementation in the class {@link V2LicenseManagementContext}
     * returns {@code "PBEWithSHA1AndDESede"}.
     */
    @Override
    public final String pbeAlgorithm() { return PBE_ALGORITHM; }

    /**
     * {@inheritDoc}
     * <p>
     * The implementation in the class {@link V2LicenseManagementContext}
     * returns a new {@link V2RepositoryContext}.
     */
    @SuppressWarnings("unchecked")
    @Override
    public final RepositoryContext<RepositoryModel> repositoryContext() {
        return (RepositoryContext) new V2RepositoryContext();
    }

    /**
     * {@inheritDoc}
     * <p>
     * The implementation in the class {@link V2LicenseManagementContext}
     * returns {@code "JCEKS"}.
     */
    @Override
    public final String storeType() { return STORE_TYPE; }
}