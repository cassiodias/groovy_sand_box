//@Grab(group='org.codehaus.gpars', module='gpars', version='1.1.0')
 
import groovyx.gpars.extra166y.Ops

/*
groovyx.gpars.GParsPool.withPool {
   [1, 2, 3, 4, 5].parallelArray.reduce({ a, b -> 
               println "$a - $b"
               println "${a+b}"
               println ""
               a + b
               
           } as Ops.Reducer, 0) 
    
}    */

groovyx.gpars.GParsPool.withPool {
    'abcde'.parallelArray 
            .withMapping( {
                    it * 2 //duplicate the item
             } as Ops.Op)
            .reduce({a, b -> "$a:$b"} as Ops.Reducer, "") //insert : between elements.
}