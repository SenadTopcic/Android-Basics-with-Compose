class SongCatalog ( title: String,  artist: String,  yearPublished: Int,  playCount:Int) {

    var title = title
     private set
    var artist = artist
        private set
    var yearPublished = yearPublished
        private set
    var playCount = playCount
        private set
   private fun isSongPoular():Boolean{
        if (playCount in 0..1000) return false
        else return true
    }

    fun printDescription(){
        println("$title, performed by $artist, was released in $yearPublished published.")
    }
}