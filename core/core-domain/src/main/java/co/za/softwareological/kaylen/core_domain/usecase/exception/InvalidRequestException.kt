package co.za.softwareological.kaylen.core_domain.usecase.exception

class InvalidRequestException : Exception() {
    override val message: String = "Invalid UseCase request"
}