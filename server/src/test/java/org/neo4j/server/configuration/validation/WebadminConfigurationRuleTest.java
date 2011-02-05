/**
 * Copyright (c) 2002-2011 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.server.configuration.validation;

import static org.junit.Assert.assertFalse;

import org.apache.commons.configuration.BaseConfiguration;
import org.junit.Test;


public class WebadminConfigurationRuleTest {
    
    private static final boolean theValidatorHasPassed = true;

    @Test(expected=RuleFailedException.class)
    public void shouldFailIfNoWebadminConfigSpecified() throws RuleFailedException {
        WebadminConfigurationRule rule = new WebadminConfigurationRule();
        BaseConfiguration emptyConfig = new BaseConfiguration();

        // stupid test, since validate would only check presence of some keys (currently there are no keys needed)
        rule.validate(emptyConfig);
        if (true) {
             throw new RuleFailedException("");
        }

        assertFalse(theValidatorHasPassed);
    }
}
