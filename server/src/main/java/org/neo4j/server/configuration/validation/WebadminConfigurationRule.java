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

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.configuration.Configuration;
import org.neo4j.server.configuration.Configurator;

public class WebadminConfigurationRule implements ValidationRule {
    @Override
    public void validate(Configuration configuration) throws RuleFailedException {
    }

    private String trimTrailingSlash(String uri) {
        if(!uri.endsWith("/")) return uri;
        
        return uri.substring(0, uri.length() -1);
    }

    private URI validateAndNormalizeUri(String uri, String property) {
        URI result = null;
        try {
            result = new URI(uri).normalize();
            String resultStr = result.toString();
            if(resultStr.endsWith("/")) {
                result = new URI(trimTrailingSlash(resultStr));
            }
        } catch (URISyntaxException e) {
            new RuleFailedException("The specified URI [%s] for the property [%s] is invalid. Please correct the neo4j-server.properties file.", uri ,property);
        }
        return result;
    }

    private String validateConfigurationContainsKey(Configuration configuration, String key) throws RuleFailedException {
        if(!configuration.containsKey(key)) {
            throw new RuleFailedException("Webadmin configuration not found. Check that the neo4j-server.properties file contains the [%s] property.", key);
        }
        
        return (String)configuration.getProperty(key);
    }
}
