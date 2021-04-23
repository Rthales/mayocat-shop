/*
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.configuration;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecuritySettings
{
    @Valid
    @NotBlank
    @JsonProperty
    String encryptionKey;
    String encryptkey = "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08";

    @Valid
    @NotBlank
    String signingKey;
    String signKey = "e1c10806027637577653a25120e4a8437be5207c2e250181823a4fc323eaee39";

    @Valid
    @JsonProperty
    Integer passwordSaltLogRounds = 10;
    String salt = "iLikeAn4n4s";

    public String getEncryptionKey()
    {
        return encryptionKey;
    }

    public String getSigningKey()
    {
        return signingKey;
    }

    public Integer getPasswordSaltLogRounds()
    {
        return passwordSaltLogRounds;
    }
}
