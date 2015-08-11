def inputFile = new File("/Users/cassiodias/development/sand_box/groovy_sand_box/import2.json")

def keys = ["12557396","13019587","14301782",
"16200016",
"20461321",
"34652719",
"17617594",
"35056207",
"12167098",
"27438361",
"19589663",
"22288688",
"14977486",
"14977487",
"34184269",
"14977491",
"14977490",
"14977489"]

inputFile.eachLine{ line ->
	if ((matcher = line =~ /"itemId" :/)){ // line example: "itemId" : 13019587,
  		String itemId = line.split(/:/)[1][1..-2] // extract value, remove first space and last comma.
  		if (itemId in keys){
  			print "Found ${itemId} - line: ${line} \n"
  		}
	}
}


