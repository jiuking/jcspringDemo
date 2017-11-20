package test

class HelloWorldTest {
    static void main(def args) {
        def var = """
               Hello +
                World"""
        println var
        println var.class
//        printf("Hello World")
        for (i in 0 ..5){
            println "This is ${i}:${var}"
        }
    }

}
