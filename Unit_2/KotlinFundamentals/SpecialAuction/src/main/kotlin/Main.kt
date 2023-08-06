fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}
fun auctionPrice(bid: Bid?, minimumPrice: Int): Int? {
    return if (bid?.amount != null) bid?.amount else minimumPrice
   /*
    if(bid != null){
        return bid.amount
    }else
        return minimumPrice
    */

}