def m = [name: 'mrhaki', language: 'Groovy']

assert 'rocks' != m.get('expression', 'rocks')