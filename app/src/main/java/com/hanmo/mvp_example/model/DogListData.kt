package com.hanmo.mvp_example.model

object DogListData { // GET Response

    fun getDoglistData(): List<Dog> {
        return listOf(
                Dog("Maltese",3),
                Dog("Golden Retriever",5),
                Dog("Siberian Husky",2),
                Dog("Beagle",1)
        )
    }
}