package com.edatalia.signplysdk.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

const val DEFAUTL_DOCUMENT_SIGNED_NAME = "documento_firmado.pdf"
const val DEFAULT_SIGNATURE_RATIO = 2.5f
const val DEFAULT_WIDGET_WIDTH = 150
const val DEFAULT_WIDGET_HEIGHT = 75
const val DEFAULT_TSP_URL = "https://tsa.ecosignature.com:8778"
const val DEFAULT_CUSTOM_TEXT_FONT_SIZE = 10
const val DEFAULT_PENCIL_TICKNESS = 10
const val DEFAULT_PENCIL_COLOR_HEX = "#000000"
const val DEFAULT_MAX_SECONDS_TIMER = 60

@Parcelize
data class SignplySDKParams(
    var licenseB64: String? = "",
    var uri: Uri,
    var saveDocumentSignedName: String = DEFAUTL_DOCUMENT_SIGNED_NAME,
    var isPrivate: Boolean = false,
    var widget: SignplySDKWidget = SignplySDKWidget(),
    var tsp: SignplySDKTSP = SignplySDKTSP(),
    var header: SignplySDKHeader = SignplySDKHeader(),
    var extra: SignplySDKExtra = SignplySDKExtra(),
    var certificate: SignplySDKCertificate = SignplySDKCertificate(),

) : Parcelable

@Parcelize
data class SignplySDKWidget(
    var widgetType: SignplySDKWidgetType = SignplySDKWidgetType.manual,
    var widgetFloatText: String? = null,
    var widgetFieldFieldname: String? = null,
    var widgetManualRatio: Float = DEFAULT_SIGNATURE_RATIO,
    var widgetFixedPage: Int? = null,
    var widgetFixedX: Int? = null,
    var widgetFixedY: Int? = null,
    var widgetFloatGapY: Int? = null,
    var widgetFloatGapX: Int? = null,
    var widgetCustomText: List<SignplySDKWidgetCustomText> ? = ArrayList(),
    var requestWidgetCustomText: Boolean? = false,
    var widgetWidth: Int = DEFAULT_WIDGET_WIDTH,
    var widgetHeight: Int = DEFAULT_WIDGET_HEIGHT,
) : Parcelable

enum class SignplySDKWidgetType {
    manual, field, fixed, float
}

@Parcelize
data class SignplySDKTSP(
    var tspActivate: Boolean? = false,
    var tspURL: String? = DEFAULT_TSP_URL,
    var tspUser: String? = "",
    var tspPasswordB64: String? = ""
) : Parcelable

@Parcelize
data class SignplySDKWidgetCustomText(
    var text: String? = "",
    var fontSize: Int? = DEFAULT_CUSTOM_TEXT_FONT_SIZE,
) : Parcelable

@Parcelize
data class SignplySDKHeader(
    var author: String = "",
    var reason: String = "",
    var contact: String = "",
    var location: String = ""
) : Parcelable

@Parcelize
data class SignplySDKExtra(
    var autoOpen: Boolean = false,
    var captureSignatureSeconds: Int = DEFAULT_MAX_SECONDS_TIMER,
    var viewLastPage: Boolean = false,
    var certify: Boolean = false,
    var documentPassword: String? = "",
    var signatureColorHex: String = DEFAULT_PENCIL_COLOR_HEX,
    var signatureThickness: Int = DEFAULT_PENCIL_TICKNESS,
    var showReject: Boolean = false,
    var displayName: String? = null
) : Parcelable

@Parcelize
data class SignplySDKCertificate(
    var signCertP12B64: String? = null,
    var signCertPassword: String? = null,
    var encKeyB64: String? = null
) : Parcelable

