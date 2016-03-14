import groovyx.gpars.actor.Actor
import groovyx.gpars.actor.DefaultActor

class GameMaster extends DefaultActor {
    int secretNum

    void afterStart() {
        secretNum = new Random().nextInt(10)
        println "I am server, the secret number is ${secretNum}"
    }

    void act() {
        loop {
            react { int num ->
                if (num > secretNum)
                    reply 'too large'
                else if (num < secretNum)
                    reply 'too small'
                else {
                    reply 'you win'
                    terminate()
                }
            }
        }
    }
}

class Player extends DefaultActor {
    String name
    Actor server
    int myNum

    void act() {
        loop {
            myNum = new Random().nextInt(10)
            println "I am $name. I am sending $myNum to server...";
            server.send myNum
            react {
                switch (it) {
                    case 'too large': println "     $myNum was too large"; break
                    case 'too small': println "     $myNum was too small"; break
                    case 'you win': println "     I won with $myNum"; terminate(); break
                }
            }
        }
    }
}

def master = new GameMaster().start()
def player = new Player(name: 'Player', server: master).start()

//this forces main thread to live until both actors stop
[master, player]*.join()