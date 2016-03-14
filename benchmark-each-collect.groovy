@Grab( 'org.gperfutils:gbench:0.4.2-groovy-2.1' )

def pass = [
        'password',
        'pan',
        'expiry',
        'securityCode']
        
benchmark {
  // Just add the strings
  'contains' {
    pass.contains("password")
  }
  // Templating
  'find' {
    pass.find{ it == "password"}
  }
 
}.prettyPrint()