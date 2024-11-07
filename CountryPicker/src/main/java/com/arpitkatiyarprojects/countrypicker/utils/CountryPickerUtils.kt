package com.arpitkatiyarprojects.countrypicker.utils

import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber

object CountryPickerUtils {

    /**
     * Validates a given mobile number for a specified country.
     *
     * @param mobileNumber The mobile number to validate.
     * @param countryCode The ISO 3166-1 alpha-2 country code (e.g., "IN" for India).
     * @return True if the mobile number is valid for the specified country, false otherwise.
     */
    fun isMobileNumberValid(mobileNumber: String, countryCode: String): Boolean {
        return try {
            val phoneNumber =
                PhoneNumberUtil.getInstance().parse(
                    mobileNumber.trim(),
                    countryCode.uppercase().trim()
                )
            PhoneNumberUtil.getInstance().isValidNumber(phoneNumber)
        } catch (exception: Exception) {
            LoggerHelper.logError(exception)
            false
        }
    }


    /**
     * Retrieves an example mobile number for a given country code.
     *
     * @param countryCode The ISO 3166-1 alpha-2 country code (e.g., "IN" for India).
     * @param whetherGetFormattedMobileNumber A boolean indicating whether to format
     *         the phone number. Defaults to true.
     * @return A string representation of the example mobile number,
     *         or an empty string if an error occurs or no example number is found.
     */
    fun getExampleMobileNumber(
        countryCode: String,
        whetherGetFormattedMobileNumber: Boolean = true,
    ): String {
        return try {
            val phoneUtil = PhoneNumberUtil.getInstance()
            val exampleMobileNumber =
                phoneUtil.getExampleNumberForType(
                    countryCode.uppercase().trim(),
                    PhoneNumberUtil.PhoneNumberType.MOBILE
                )
            exampleMobileNumber?.let {
                if (whetherGetFormattedMobileNumber) {
                    phoneUtil.getFormattedNumberFromPhoneNumber(it)
                } else {
                    it.nationalNumber.toString()
                }
            } ?: ""
        } catch (exception: Exception) {
            LoggerHelper.logError(exception)
            ""
        }
    }


    /**
     * Formats a given phone number object into the national format,
     * removing any leading zeros.
     *
     * @receiver PhoneNumberUtil The [PhoneNumberUtil] instance used to format the number.
     * @param phoneNumber The phone number to be formatted, represented as a phone [Phonenumber.PhoneNumber] object.
     * @return A formatted string representation of the phone number in national format,
     *         with leading zeros removed.
     */
    private fun PhoneNumberUtil.getFormattedNumberFromPhoneNumber(phoneNumber: Phonenumber.PhoneNumber): String {
        return format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL).trimStart('0')
    }

    /**
     * Formats a given phone number to the specified format (Use it only when the full mobile number is entered).
     *
     * @param countryCode The ISO 3166-1 alpha-2 country code (e.g., "IN" for India).
     * @param mobileNumber The national phone number as a string.
     * @return A formatted phone number as a string, or an empty string if the number cannot be formatted.
     */
    fun getFormattedMobileNumber(
        countryCode: String,
        mobileNumber: String,
    ): String {
        return try {
            if (isMobileNumberValid(mobileNumber, countryCode)) {
                val phoneUtil = PhoneNumberUtil.getInstance()
                val parsedNumber =
                    phoneUtil.parse(mobileNumber.trim(), countryCode.uppercase().trim())
                phoneUtil.getFormattedNumberFromPhoneNumber(parsedNumber)
            } else {
                mobileNumber
            }
        } catch (exception: Exception) {
            LoggerHelper.logError(exception)
            mobileNumber
        }
    }

}