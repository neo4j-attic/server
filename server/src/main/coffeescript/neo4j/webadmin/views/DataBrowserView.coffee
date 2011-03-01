define(
  ['neo4j/webadmin/data/Search',
   'neo4j/webadmin/data/SimpleView',
   'neo4j/webadmin/templates/databrowser','lib/backbone'], 
  (Search, SimpleView, template) ->

    class DataBrowserView extends Backbone.View
      
      template : template

      events : 
        "keyup #data-console" : "search"

      initialize : (options)->
        @search = new Search(options.state.server)
        @dataView = new SimpleView(dataModel:options.dataModel)

      render : ->
        $(@el).html(@template())
        $("#data-area", @el).append @dataView.el 
        return this

      search : (ev) =>
        @search.exec $("#data-console",@el).val()
)