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
package org.neo4j.server.modules;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.HashMap;

import javax.management.ObjectName;

import org.apache.commons.configuration.MapConfiguration;
import org.junit.Test;
import org.neo4j.jmx.Kernel;
import org.neo4j.kernel.AbstractGraphDatabase;
import org.neo4j.server.NeoServerWithEmbeddedWebServer;
import org.neo4j.server.database.Database;
import org.neo4j.server.web.WebServer;
import org.rrd4j.core.RrdDb;


public class WebAdminModuleTest {
    @Test
    public void shouldRegisterASingleUri() throws Exception {
        WebServer webServer = mock(WebServer.class);

        NeoServerWithEmbeddedWebServer neoServer = mock(NeoServerWithEmbeddedWebServer.class);
        when(neoServer.baseUri()).thenReturn(new URI("http://localhost:7575"));
        when(neoServer.getWebServer()).thenReturn(webServer);

        Database db = mock(Database.class);
        db.graph = (mock(AbstractGraphDatabase.class));
        Kernel mockKernel = mock(Kernel.class);
        ObjectName mockObjectName = mock(ObjectName.class);
        when(mockKernel.getMBeanQuery()).thenReturn(mockObjectName);
        when(db.graph.getManagementBean(Kernel.class)).thenReturn(mockKernel);

        when(neoServer.getDatabase()).thenReturn(db);
        when( neoServer.getConfiguration() ).thenReturn( new MapConfiguration( new HashMap<Object, Object>() ) );

        WebAdminModule module = new WebAdminModule();
        module.start( neoServer );

        verify( db ).setRrdDb( any( RrdDb.class ) );
    }
}
