import com.google.gson.annotations.SerializedName


class Ability {
    @SerializedName("slot")
    var slot: String? = null

    @SerializedName("displayName")
    var displayName: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("displayIcon")
    var displayIcon: String? = null
}

class Datum {
    @SerializedName("uuid")
    var uuid: String? = null

    @SerializedName("displayName")
    var displayName: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("developerName")
    var developerName: String? = null

    @SerializedName("characterTags")
    var characterTags: Any? = null

    @SerializedName("displayIcon")
    var displayIcon: String? = null

    @SerializedName("displayIconSmall")
    var displayIconSmall: String? = null

    @SerializedName("bustPortrait")
    var bustPortrait: String? = null

    @SerializedName("fullPortrait")
    var fullPortrait: String? = null

    @SerializedName("fullPortraitV2")
    var fullPortraitV2: String? = null

    @SerializedName("killfeedPortrait")
    var killfeedPortrait: String? = null

    @SerializedName("background")
    var background: String? = null

    @SerializedName("backgroundGradientColors")
    var backgroundGradientColors: ArrayList<String>? = null

    @SerializedName("assetPath")
    var assetPath: String? = null

    @SerializedName("isFullPortraitRightFacing")
    var isFullPortraitRightFacing = false

    @SerializedName("isPlayableCharacter")
    var isPlayableCharacter = false

    @SerializedName("isAvailableForTest")
    var isAvailableForTest = false

    @SerializedName("isBaseContent")
    var isBaseContent = false

    @SerializedName("role")
    var role: Role? = null

    @SerializedName("abilities")
    var abilities: ArrayList<Ability>? = null

    @SerializedName("voiceLine")
    var voiceLine: VoiceLine? = null
}

class MediaList {
    @SerializedName("id")
    var id = 0

    @SerializedName("wwise")
    var wwise: String? = null

    @SerializedName("wave")
    var wave: String? = null
}

class Role {
    @SerializedName("uuid")
    var uuid: String? = null

    @SerializedName("displayName")
    var displayName: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("displayIcon")
    var displayIcon: String? = null

    @SerializedName("assetPath")
    var assetPath: String? = null
}

class Agent {
    @SerializedName("data")
    var data: ArrayList<Datum>? = null
}

class VoiceLine {
    @SerializedName("minDuration")
    var minDuration = 0.0

    @SerializedName("maxDuration")
    var maxDuration = 0.0

    @SerializedName("mediaList")
    var mediaList: ArrayList<MediaList>? = null
}