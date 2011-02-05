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
package org.neo4j.server;

import java.io.File;

import org.neo4j.server.startup.healthcheck.StartupHealthCheck;
import org.neo4j.server.web.Jetty6WebServer;

public class CleaningNeoServer extends NeoServerJetty
{
    private final String dir;
    private static RuntimeException lastStarted;

    public CleaningNeoServer( final AddressResolver addressResolver, final StartupHealthCheck startupHealthCheck,
                              final File configFile, final Jetty6WebServer jetty6WebServer, final String dir )
    {
        super( addressResolver, startupHealthCheck, configFile, jetty6WebServer );
        this.dir = dir;
        if ( lastStarted != null )
        {
            try
            {
                throw lastStarted;
            }
            finally
            {
                lastStarted = null; // only report this once
            }
        }
    }

    @Override
    public void start()
    {
        super.start();
        lastStarted = new RuntimeException( originatingTestClass()
                                            + " didn't shut down the server correctly!" );
    }

    private String originatingTestClass()
    {
        for ( StackTraceElement el : Thread.currentThread().getStackTrace() )
        {
            String className = el.getClassName();
            if ( className.contains( "Test" ) )
            {
                return className;
            }
        }
        return "N/A";
    }

    @Override
    public void stop()
    {
        super.stop();
        recursiveDelete( dir );
        lastStarted = null;
    }

    private void secureDelete( File f )
    {
        boolean success = f.delete();
        if ( !success )
        {
            throw new RuntimeException( "Failed to delete the temporary database" );
        }
    }

    public void recursiveDelete( String dirOrFile )
    {
        recursiveDelete( new File( dirOrFile ) );
    }

    public void recursiveDelete( File dirOrFile )
    {
        if ( dirOrFile.isDirectory() )
        {
            for ( File sub : dirOrFile.listFiles() )
            {
                recursiveDelete( sub );
            }
        }

        secureDelete( dirOrFile );
    }
}
