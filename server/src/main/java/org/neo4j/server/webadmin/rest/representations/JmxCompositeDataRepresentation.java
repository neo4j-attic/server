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
package org.neo4j.server.webadmin.rest.representations;

import java.util.ArrayList;

import javax.management.openmbean.CompositeData;

import org.neo4j.server.rest.repr.ListRepresentation;
import org.neo4j.server.rest.repr.ObjectRepresentation;
import org.neo4j.server.rest.repr.Representation;
import org.neo4j.server.rest.repr.ValueRepresentation;

public class JmxCompositeDataRepresentation extends ObjectRepresentation
{
    protected CompositeData data;

    public JmxCompositeDataRepresentation( CompositeData data )
    {
        super( "jmxCompositeData" );
        this.data = data;
    }

    @Mapping( "type" )
    public ValueRepresentation getType()
    {
        return ValueRepresentation.string( data.getCompositeType().getTypeName() );
    }


    @Mapping( "description" )
    public ValueRepresentation getDescription()
    {
        return ValueRepresentation.string( data.getCompositeType().getDescription() );
    }

    @Mapping( "value" )
    public ListRepresentation getValue()
    {

        JmxAttributeRepresentationDispatcher representationDispatcher = new JmxAttributeRepresentationDispatcher();
        ArrayList<Representation> values = new ArrayList<Representation>();
        for ( Object key : data.getCompositeType().keySet() )
        {
            String name = key.toString();
            String description = data.getCompositeType().getDescription( name );
            
            
            Representation value = representationDispatcher.dispatch( data.get( name ) , "");

            values.add( new NameDescriptionValueRepresentation( name, description, value ) );
        }

        return new ListRepresentation( "value", values );
    }
}
