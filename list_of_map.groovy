def fakeQkrVariantMap =
                        [[sku: 5695, upc: 899738000679],
                         [sku: 19928, upc: 651043012729]/*,
                 [sku: 181, upc: 626704312111],
                 [sku: 1042, upc: 654367632123],
                 [sku: 770, upc: 358211904168],
                 [sku: 771, upc: 358211905165],
                 [sku: 2005, upc: 732013082024],
                 [sku: 783, upc: 783],
                 [sku: 9, upc: 93],
                 [sku: 947, upc: 812025010090]*/]


fakeQkrVariantMap.collect { 
      println "${it.sku} - ${it.upc}" 
      
}