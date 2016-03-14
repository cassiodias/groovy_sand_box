 @Grab(group='org.codehaus.gpars', module='gpars', version='1.1.0')
 
import static groovyx.gpars.actor.Actors.actor
import groovyx.gpars.actor.DynamicDispatchActor
import org.codehaus.groovy.runtime.NullObject
  
def decryptor = actor {
    loop {
        react { message ->
            if (message instanceof String) 
                reply message.reverse()
            else 
                stop()
        }
    }
}

def console = actor {
    decryptor.send 'lellarap si yvoorG'
    react {
        println "Decrypted message: $it"
        decryptor.send false
    }
}

[decryptor, console]*.join()
print 'End'