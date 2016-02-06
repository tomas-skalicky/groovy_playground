package cz.skalicky.groovy.customdsl

import groovy.transform.ToString;

@ToString
class Configuration {

    String classes
    String jar
    String[] rules
    
}
