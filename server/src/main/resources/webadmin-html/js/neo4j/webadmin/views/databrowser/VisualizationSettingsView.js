(function() {
  /*
  Copyright (c) 2002-2011 "Neo Technology,"
  Network Engine for Objects in Lund AB [http://neotechnology.com]

  This file is part of Neo4j.

  Neo4j is free software: you can redistribute it and/or modify
  it under the terms of the GNU Affero General Public License as
  published by the Free Software Foundation, either version 3 of the
  License, or (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU Affero General Public License for more details.

  You should have received a copy of the GNU Affero General Public License
  along with this program. If not, see <http://www.gnu.org/licenses/>.
  */  var __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; }, __hasProp = Object.prototype.hasOwnProperty, __extends = function(child, parent) {
    for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; }
    function ctor() { this.constructor = child; }
    ctor.prototype = parent.prototype;
    child.prototype = new ctor;
    child.__super__ = parent.prototype;
    return child;
  };
  define(['neo4j/webadmin/templates/databrowser/visualizationSettings', 'neo4j/webadmin/views/View', 'lib/backbone'], function(template, View) {
    var VisualizationSettingsView;
    return VisualizationSettingsView = (function() {
      function VisualizationSettingsView() {
        this.render = __bind(this.render, this);;
        this.initialize = __bind(this.initialize, this);;        VisualizationSettingsView.__super__.constructor.apply(this, arguments);
      }
      __extends(VisualizationSettingsView, View);
      VisualizationSettingsView.prototype.initialize = function(opts) {
        return this.appState = opts.appState;
      };
      VisualizationSettingsView.prototype.render = function() {
        $(this.el).html(template());
        return this;
      };
      return VisualizationSettingsView;
    })();
  });
}).call(this);
