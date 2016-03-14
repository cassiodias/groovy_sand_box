 @Grab(group='org.codehaus.gpars', module='gpars', version='1.1.0')
 
 import groovyx.gpars.GParsPool
 
 //multiply numbers asynchronously
 GParsPool.withPool {
     final List result = [1, 2, 3, 4, 5].collectParallel {it * 2}
     assert ([2, 4, 6, 8, 10].equals(result))
 }