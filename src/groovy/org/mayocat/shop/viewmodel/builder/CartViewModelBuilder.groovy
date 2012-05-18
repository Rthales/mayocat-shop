package org.mayocat.shop.viewmodel.builder

import org.mayocat.shop.grails.Product
import org.mayocat.shop.viewmodel.CartViewModel
import org.mayocat.shop.viewmodel.CartItemViewModel

class CartViewModelBuilder {

  def productViewModelBuilder = new ProductViewModelBuilder()

  def build(cart) {
    def items = []
    def total = new BigDecimal(0)
    for (item in cart.keySet()) {
      Product p = Product.findByByname(item)
      items.add( this.buildItem(p, cart.get(item)) )
      total = total.plus(new BigDecimal(p.price))
    }
    
    return new CartViewModel(
      total: total, 
      displayTotal: String.format("%10.2f", total),
      items:items, 
    )
  }

  def buildItem(product, quantity) {
    new CartItemViewModel(product:productViewModelBuilder.build(product), quantity:quantity)
  }

}
