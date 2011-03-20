Feature: Download and unpack Neo4j Server
  In order to get Neo4j Server
  A user
  Should be able to download and unpack a platform appropriate archive from the web

  Background:
    Given a platform supported by Neo4j
    And Neo4j version based on system property "NEO4J_VERSION"
    And set Neo4j Home to "neo4j_home"
    And a web site at host "dist.neo4j.org"
    And a working directory at relative path "work"

  Scenario: Download Neo4j 
    When I download Neo4j (if I haven't already)
    Then the working directory should contain a Neo4j archive

  Scenario: Unpack downloaded archive
    When I unpack the archive into Neo4j Home
#    When set And the NEO4J_HOME should point to the installation
    Then Neo4j Home should contain a Neo4j Server installation
    And the Neo4j version of the installation should be correct

