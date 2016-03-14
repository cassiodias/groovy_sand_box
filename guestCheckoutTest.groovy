class MBNotifyGuestPaymentRequestData {
    MBCard card
    MBAddress shippingAddress
    List<MBCart> mbCart
}

class MBCard {
    String cardHolderName
    String pan
    
}

class MBAddress {
    String firstName
    String lastName
}

class MBCartItem {
    int quantity
    String selectedVariantSku // Some products have variants, which have their own skus. This field indicates the selected sku.
}

class MBCart {
    String mbMerchantEnum
    List<MBCartItem> mbCartItems
    MBShippingAndTaxInfo selectedShippingAndTaxOption
}

class MBShippingAndTaxInfo {
    String name // e.g "ground", "twoday", "nextday", has potential to be used as pointer so long as UI knows to display description.
    String description  // User friendly description.  Should be under 10 characters so it is user friendly and UI friendly.
}

def mbCard  = new MBCard(cardHolderName:"cassio",pan:"pan")
def mbAddress = new MBAddress(firstName:"firstName",lastName:"lastName")

def cartItem1 = new MBCartItem(quantity:1, selectedVariantSku:"selectedVariantSku")
def cartItem2 = new MBCartItem(quantity:1, selectedVariantSku:"selectedVariantSku")
def cartItem3 = new MBCartItem(quantity:1, selectedVariantSku:"selectedVariantSku")

def cart1 = new MBCart(mbMerchantEnum:"M1", mbCartItems:[cartItem1,cartItem2,cartItem3],selectedShippingAndTaxOption:new MBShippingAndTaxInfo(name:"name", description:"description"))
def cart2 = new MBCart(mbMerchantEnum:"M1", mbCartItems:[cartItem1,cartItem2,cartItem3],selectedShippingAndTaxOption:new MBShippingAndTaxInfo(name:"name", description:"description"))
def cart3 = new MBCart(mbMerchantEnum:"M1", mbCartItems:[cartItem1,cartItem2,cartItem3],selectedShippingAndTaxOption:new MBShippingAndTaxInfo(name:"name", description:"description"))

def data = new MBNotifyGuestPaymentRequestData(card:mbCard, shippingAddress:mbAddress, mbCart:[cart1, cart2, cart3])

def json = new groovy.json.JsonOutput().toJson(data)
println json
println ""

def jsonSlurper = new groovy.json.JsonSlurper()
Map map = jsonSlurper.parseText(json.toString())
println map

MBNotifyGuestPaymentRequestData obj = jsonSlurper.parseText(json.toString())
println obj.toString()

