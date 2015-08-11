@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.6')
import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

def apiToken = 'b976c0113763235381d4794b8db25ba884e453a3'

def http = new HTTPBuilder( 'https://api.github.com/' )

// perform a GET request, expecting JSON response data
http.request( GET, JSON ) {

  uri.path = '/orgs/octokit/repos'
  headers.'Accept' = 'application/json'
  headers.'Authorization' = 'Basic ' + (apiToken + ':').bytes.encodeBase64().toString()
  headers.'User-Agent' = '[cassiodias]'

  // response handler for a success response code:
  response.success = { resp, json ->
    println resp.statusLine
    println json
  }

  // handler for any failure status code:
  response.failure = { resp ->
    println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
  }
}