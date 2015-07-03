x = ["a"]

print x.collect { it ->
	it + "aaa"
 }