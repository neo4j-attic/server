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
package org.neo4j.server.rest.domain;

import org.neo4j.graphdb.Path;
import org.neo4j.server.rest.repr.FullPathRepresentation;
import org.neo4j.server.rest.repr.MappingRepresentation;
import org.neo4j.server.rest.repr.RepresentationType;

public enum TraverserReturnType
{
    node( RepresentationType.NODE )
    {
        @Override
        public MappingRepresentation toRepresentation( Path position )
        {
            return new org.neo4j.server.rest.repr.NodeRepresentation( position.endNode() );
        }
    },
    relationship( RepresentationType.RELATIONSHIP )
    {
        @Override
        public MappingRepresentation toRepresentation( Path position )
        {
            return new org.neo4j.server.rest.repr.RelationshipRepresentation(
                    position.lastRelationship() );
        }
    },
    path( RepresentationType.PATH )
    {
        @Override
        public MappingRepresentation toRepresentation( Path position )
        {
            return new org.neo4j.server.rest.repr.PathRepresentation( position );
        }
    },
    fullpath( RepresentationType.FULL_PATH )
    {
        @Override
        public MappingRepresentation toRepresentation( Path position )
        {
            return new FullPathRepresentation( position );
        }
    };
    public final RepresentationType repType;

    private TraverserReturnType( RepresentationType repType )
    {
        this.repType = repType;
    }

    public abstract MappingRepresentation toRepresentation( Path position );
}
