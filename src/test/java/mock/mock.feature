Feature: cats stateful crud

  Background:
    * def uuid = function(){ return java.util.UUID.randomUUID() + '' }
    * def cats = {}