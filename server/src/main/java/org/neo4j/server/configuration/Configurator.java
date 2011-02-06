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
package org.neo4j.server.configuration;

import org.apache.commons.configuration.Configuration;

import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 * @author tbaum
 * @since 06.02.11
 */
public interface Configurator {
    String DB_TUNING_PROPERTY_FILE_KEY = "org.neo4j.server.db.tuning.properties";
    String DEFAULT_CONFIG_DIR = File.separator + "etc" + File.separator + "neo";
    String DATABASE_LOCATION_PROPERTY_KEY = "org.neo4j.server.database.location";
    String NEO_SERVER_CONFIG_FILE_KEY = "org.neo4j.server.properties";
    String DB_MODE_KEY = "org.neo4j.server.database.mode";
    int DEFAULT_WEBSERVER_PORT = 7474;
    String WEBSERVER_PORT_PROPERTY_KEY = "org.neo4j.server.webserver.port";
    String DEFAULT_WEB_ADMIN_PATH = "/webadmin";
    String DEFAULT_WEB_ADMIN_STATIC_WEB_CONTENT_LOCATION = "webadmin-html";
    String REST_API_PACKAGE = "org.neo4j.server.rest.web";
    String ENABLE_OSGI_SERVER_PROPERTY_KEY = "org.neo4j.server.osgi.enable";
    String OSGI_BUNDLE_DIR_PROPERTY_KEY = "org.neo4j.server.osgi.bundledir";
    String OSGI_CACHE_DIR_PROPERTY_KEY = "org.neo4j.server.osgi.cachedir";
    String WEB_ADMIN_REST_API_PACKAGE = "org.neo4j.server.webadmin.rest";
    String WEBADMIN_NAMESPACE_PROPERTY_KEY = "org.neo4j.server.webadmin";
    String WEB_ADMIN_PATH_PROPERTY_KEY = "org.neo4j.server.webadmin.management.uri";
    String REST_API_PATH_PROPERTY_KEY = "org.neo4j.server.webadmin.data.uri";
    String THIRD_PARTY_PACKAGES_KEY = "org.neo4j.server.thirdparty_jaxrs_classes";

    Configuration configuration();

    Map<String, String> getDatabaseTuningProperties();

    Set<ThirdPartyJaxRsPackage> getThirdpartyJaxRsClasses();
}
