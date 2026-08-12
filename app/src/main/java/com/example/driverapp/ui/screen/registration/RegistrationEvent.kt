package com.example.driverapp.ui.screen.registration

import android.net.Uri
import com.example.driverapp.ui.screen.otp.OtpEvent

sealed interface RegistrationEvent {

    data class OnImageSelected(
        val uri: Uri
    ) : RegistrationEvent

    data class onNameChange(
        val name: String
    ) : RegistrationEvent

    data class onLastChange(
        val name: String
    ) : RegistrationEvent

    data class onDateChange(
        val date: String
    ) : RegistrationEvent

    data class onInsuranceExpiry(
        val expiry: String
    ) : RegistrationEvent

    data class onGenderChange(
        val gender: Int
    ) : RegistrationEvent

    data class OnImageSelectedLicence(
        val uri: Uri
    ) : RegistrationEvent

    data class onLicenceChange(
        val licence: String
    ) : RegistrationEvent

    data class  onImageSelectedPan(
        val uri : Uri
    ) : RegistrationEvent

    data class onPanChange(
        val pan: String
    ) : RegistrationEvent

    data class  onImageSelectedAadhar(
        val uri : Uri
    ) : RegistrationEvent

    data class onAadhaarChange(
        val aadhaar: String
    ) : RegistrationEvent

    data class onSelectingVehicle(
        val Vehicle: String,
        val VehicleSubType: List<String>?
    ) : RegistrationEvent

    data class onSelectingVehicleSubType(
        val CurrentVehicleSubType: String
    ) : RegistrationEvent

    data class onChangeVehicleNumber(
        val vehicleNumber: String
    ) : RegistrationEvent

    data class onChangeRcNumber(
        val rcNumber: String
    ) : RegistrationEvent

    data class onChangeInsuranceNumber(
        val insuranceNumber: String
    ) : RegistrationEvent

    data class onChangeCapacityNumber(
        val capacity: String
    ) : RegistrationEvent

    data class  onImageSelectedVehicle(
        val uri : Uri
    ) : RegistrationEvent

    data class  onImageSelectedRc(
        val uri : Uri
    ) : RegistrationEvent

    data class  onImageSelectedInsurance(
        val uri : Uri
    ) : RegistrationEvent

    data object OnSubmittingRegistration : RegistrationEvent
}