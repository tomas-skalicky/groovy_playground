package cz.skalicky.groovy.customdsl


class ArchitectureDelegate {

    private final Configuration configuration
    
    ArchitectureDelegate(Configuration configuration) {
        this.configuration = configuration
    }
    
    void classes(String name) {
        this.configuration.classes = name
    }
    
    void jar(String name) {
        this.configuration.jar = name
    }
    
    void rules(Closure cl) {
        cl.delegate = new RulesDelegate(configuration)
        cl.resolveStrategy = Closure.DELEGATE_FIRST
        cl()
    }
}
