
def listOfContacts = [
	[name: 'Cassio', age: 34],
	[name: 'Aline', age: 33],
	[name: 'Sofia', age: 2],
	[name: 'Davi', age: 3],
	[name: 'Gabriel', age: 3],
	[name: 'Lulu', age: 1]
]


def (List<Map> adult, List<Map> child) = listOfContacts.split{ it ->
		it.age > 18 ? true : false
	}

println "adult: ${adult}"
println "child: ${child}"
println listOfContacts