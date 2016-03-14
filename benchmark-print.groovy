@Grab(group='org.gperfutils', module='gbench', version='0.4.3-groovy-2.4')

def b = benchmark {
    'simple-sum' {
        [1, 3, 5].sum()
    }
    'inject-sum' {
        [1, 3, 5].inject(0, { x, y -> x + y })
    }
}

b.prettyPrint()