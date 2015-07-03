@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.0-RC2')
import groovyx.net.http.RESTClient;

def resp = new RESTClient('http://localhost:8081').
		post([path : '/something/',
        	  body :[input1:['value'], input2:['value']],
        	  contentType : 'application/json'])

print resp.responseData