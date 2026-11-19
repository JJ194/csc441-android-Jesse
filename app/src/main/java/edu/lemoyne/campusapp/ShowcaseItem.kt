package edu.lemoyne.campusapp


import com.google.gson.annotations.SerializedName

// Class 21: Step 2: Data class and API interface
data class ShowcaseItem(

    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("category") var category: String,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("create_at") var createAt: String

)