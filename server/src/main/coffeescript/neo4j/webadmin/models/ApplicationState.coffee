
define ['lib/backbone'], () ->
  
  class ApplicationState extends Backbone.Model
    
    getServer : ->
      @get "server"