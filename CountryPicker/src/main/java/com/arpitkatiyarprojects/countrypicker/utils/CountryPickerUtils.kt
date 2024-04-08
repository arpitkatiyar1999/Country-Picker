package com.arpitkatiyarprojects.countrypicker.utils

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil

object CountryPickerUtils {

    /**
     * Determines whether the provided mobile number is valid or not
     * @param [mobileNumber] it should be the combination of country phone code and mobile number. eg. if country phone code is +91 and number is 9999999999 the the combined number will be +919999999999.
     */
    fun isMobileNumberValid(mobileNumber: String): Boolean {
        return try {
            val phoneNumber =
                PhoneNumberUtil.getInstance().parse(
                    mobileNumber.trim(),
                    PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY,
                )
            PhoneNumberUtil.getInstance().isValidNumber(phoneNumber)
        } catch (e: NumberParseException) {
            e.printStackTrace()
            false
        }
    }
}