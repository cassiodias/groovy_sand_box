@Grab(group='org.codehaus.gpars', module='gpars', version='1.1.0')
 
import groovyx.gpars.GParsPool
 
import static groovyx.gpars.GParsPool.withPool
def list = [1, 2, 3, 4, 5, 6, 7, 8, 9]

println 'Sequential: '
list.each { print it + ',' }
println()

withPool {

    println 'Sequential: '
    list.each { print it + ',' }
    println()

    list.makeConcurrent()

    println 'Concurrent: '
    list.each { print it + ',' }
    println()

    list.makeSequential()

    println 'Sequential: '
    list.each { print it + ',' }
    println()
}

println 'Sequential: '
list.each { print it + ',' }
println()