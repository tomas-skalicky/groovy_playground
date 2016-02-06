package cz.skalicky.groovy.customdsl

class GroovyArchitecture {

    static void main(String[] args) {
        runArchitectureRules(new File("src/main/groovy/cz/skalicky/groovy/customdsl/architecture.groovy"))
    }

    static void runArchitectureRules(File dsl) {
        Script dslScript = new GroovyShell().parse(dsl.text)
        Configuration configuration = new Configuration()
        dslScript.metaClass = createEMC(dslScript.class, { ExpandoMetaClass emc ->
            emc.architecture = { Closure cl ->
                cl.delegate = new ArchitectureDelegate(configuration)
                cl.resolveStrategy = Closure.DELEGATE_FIRST
                cl()
            }
        })
        dslScript.run()
        println(configuration)
    }

    static ExpandoMetaClass createEMC(Class clazz, Closure cl) {
        ExpandoMetaClass emc = new ExpandoMetaClass(clazz, false)
        cl(emc)
        emc.initialize()
        return emc
    }
}
