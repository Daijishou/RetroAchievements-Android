package org.daijishou.retroachievements.utils

fun buildRequestUrl(baseUrl: String, endpointUrl: String, authObject: AuthObject, args: Map<String, String?> = emptyMap()) {
    val concatenated = "$baseUrl/$endpointUrl"
    val withoutDoubleSlashes = concatenated.replace("([^:]/)/+".toRegex(), "$1")
    var withArgs = withoutDoubleSlashes;
    // `z` and `y` are expected query params from the RA API.
    // Authentication is handled purely by query params.
    val queryParamValues: Map<String, String> = mapOf(
        "z" to authObject.userName,
        "y" to authObject.webApiKey
    )

    for((argKey, argValue) in args) {
        if(":$argKey" in withArgs) {
            withArgs = withArgs.replace(":$argKey", argValue.toString())
        } else if (argValue==null) {

        }
    }

    return
}