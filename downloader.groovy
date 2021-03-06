@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')
import groovyx.net.http.RESTClient
import groovy.json.JsonSlurper
import static groovyx.net.http.ContentType.TEXT

def client = new groovyx.net.http.RESTClient('http://api.walmartlabs.com/v1/feeds/checkoutV2?apiKey=jk2bwa8w7dwnuj247p4rcpeq')
client.setHeaders(Accept: 'application/json')

def json = client.get(contentType: TEXT) 
def slurper = new groovy.json.JsonSlurper().parse(json)
def file = new File('walmart-feed.json').newOutputStream()  
file << slurper
file.close()  
