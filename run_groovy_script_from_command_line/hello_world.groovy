
class HelloWorld {

    private String value;

    private HelloWorld() {
        value = 'Hello world'
    }

    @Override
    public String toString() {
        return "toString()=$value"
    }
}

println new HelloWorld().toString()
println 'Hello world'
