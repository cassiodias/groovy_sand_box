@Grapes(
	[
		@Grab(group='org.codehaus.jackson', module='jackson-core-asl', version='1.9.6'),
		@Grab(group='org.codehaus.jackson', module='jackson-mapper-asl', version='1.9.13')
	]
)

final URL url = new URL('http://api.walmartlabs.com/v1/feeds/checkoutV2?apiKey=jk2bwa8w7dwnuj247p4rcpeq') // file with 4.2gb

def urlConnection = (HttpURLConnection) url.openConnection(java.net.Proxy.NO_PROXY)

new java.util.zip.GZIPInputStream(urlConnection.getInputStream()).
	withStream { stream ->
    	def file = new File('walmart-feed.json').newOutputStream()  
		file << stream
		file.close()
	}