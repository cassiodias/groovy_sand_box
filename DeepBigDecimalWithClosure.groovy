
def mapToTest = [
    key1: "String1",
    key2: new BigDecimal(2),
    key3: "String3",
    key4: [attr1:'attrValue1', attr2: [attr1:'attrValue1', attr2: new BigDecimal(4)]],
    key5:new BigDecimal(5)
]

def deepDoubler 
deepDoubler = { Map map ->
   map.each { k, v ->
       if (v instanceof Map){
           deepDoubler.trampoline(v).call()
       } else if (v instanceof BigDecimal) {
           map[k] =  v.toDouble()
       }
   }
}.trampoline()

deepDoubler(mapToTest)

assert "[key1:String1, key2:2.0, key3:String3, key4:[attr1:attrValue1, attr2:[attr1:attrValue1, attr2:4.0]], key5:5.0]" == mapToTest.toString()