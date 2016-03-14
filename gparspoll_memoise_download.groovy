@Grab(group='org.codehaus.gpars', module='gpars', version='1.1.0')
 
import static groovyx.gpars.GParsPool.withPool
 
withPool {

    def urls = ['http://www.dzone.com', 'http://www.theserverside.com', 'http://www.infoq.com']
    Closure download = {url ->
        println "Downloading $url"
        url.toURL().text.toUpperCase()
    }
    
    Closure cachingDownload = download.gmemoize()
    
    println 'Groovy sites today: ' + urls.findAllParallel {url -> cachingDownload(url).contains('GROOVY')}
    println 'Grails sites today: ' + urls.findAllParallel {url -> cachingDownload(url).contains('GRAILS')}
    println 'Griffon sites today: ' + urls.findAllParallel {url -> cachingDownload(url).contains('GRIFFON')}
    println 'Gradle sites today: ' + urls.findAllParallel {url -> cachingDownload(url).contains('GRADLE')}
    println 'Concurrency sites today: ' + urls.findAllParallel {url -> cachingDownload(url).contains('CONCURRENCY')}
    println 'GPars sites today: ' + urls.findAllParallel {url -> cachingDownload(url).contains('GPARS')}
    
}