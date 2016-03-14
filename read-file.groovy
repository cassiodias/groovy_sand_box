def inputFile = new File("/Users/cassiodias/development/sand_box/groovy_sand_box/walmart-feed.json")

def keys = ["43165617"]

boolean f = false

inputFile.eachLine { line ->
	if ((matcher = line =~ /"itemId" :/)){ // line example: "itemId" : 13019587,
  		String itemId = line.split(/:/)[1][1..-2] // extract value, remove first space and last comma.
  		if (itemId in keys){
  			f = true
  			print "Found ${itemId} - line: ${line} \n"
  		}
	} 

	if (f) {
		print line
	}
}


