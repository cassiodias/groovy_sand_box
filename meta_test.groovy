
// Getting the original behavior
def original = String.metaClass.getMetaMethod('toUpperCase', [] as Class[])

// Changing toUpperCase bahavior
String.metaClass.toUpperCase = {
	"changed"
}
 
assert "changed".equals('A simple string'.toUpperCase())

// resetting to the original behavior
String.metaClass = null

assert 'A SIMPLE STRING'.equals('A simple string'.toUpperCase())

// Reseting using the original state (2nd option).
/*
String.metaClass.toUpperCase {
	originalPostAsXml.invoke(delegate)
}
*/