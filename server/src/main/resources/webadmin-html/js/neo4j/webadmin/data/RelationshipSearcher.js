/*
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
(function() {
  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };
  define([], function() {
    var RelationshipSearcher;
    return RelationshipSearcher = (function() {
      function RelationshipSearcher() {
        this.exec = __bind(this.exec, this);;
        this.match = __bind(this.match, this);;        this.pattern = /^((rel)|(relationship)):([0-9]+)$/i;
      }
      RelationshipSearcher.prototype.match = function(statement) {
        return this.pattern.test(statement);
      };
      RelationshipSearcher.prototype.exec = function(statement) {
        return location.hash = "#/data/relationship/" + this.getRelationshipId(statement);
      };
      RelationshipSearcher.prototype.getRelationshipId = function(statement) {
        return this.pattern.exec(statement)[4];
      };
      return RelationshipSearcher;
    })();
  });
}).call(this);