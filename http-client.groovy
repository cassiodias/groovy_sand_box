@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.0-RC2')
import groovyx.net.http.RESTClient;

def client = new RESTClient( 'http://localhost:8081' )
def resp = client.post([
	path : '/something/',
        	//query: [:],
        	body :[
        		input1:['value'], input2:['value']],
        	contentType : 'application/json'])

print resp.responseData