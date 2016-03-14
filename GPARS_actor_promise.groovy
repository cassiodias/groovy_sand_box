
import static groovyx.gpars.actor.Actors.actor
import groovyx.gpars.dataflow.Promise

def askingForLoan = actor {
    loop {
        react { msg ->
           println "Received: $msg from a client, getting money...";
            Thread.sleep(5000) // process to withdraw money...
            reply "€1.000"
        }
    }
}

Promise bankLoan = askingForLoan.sendAndPromise 'I need money!'
bankLoan.whenBound { money -> 
   print "Owww, I just received amount of ${money}"
} 

println 'Loan applied, now I can continue my work while the bank is collecting money for me...'

println 'Still waiting...'
println 'Still waiting...'
println 'Still waiting...'
println 'Still waiting...'