package com.syscode.syscode.test.common.exception.util;

import com.syscode.syscode.test.common.exception.StudentException;
import org.springframework.http.HttpStatus;

public class StudentExceptionUtils {
  private StudentExceptionUtils() {}

  public static void throwStudentException(String label, HttpStatus status) {
    throw new StudentException(label, status);
  }

  public static void throwBadRequest(String label) {
    throw new StudentException(label, HttpStatus.BAD_REQUEST);
  }

  public static void throwUnathorized(String label) {
    throw new StudentException(label, HttpStatus.UNAUTHORIZED);
  }

  public static void throwPaymentRequired(String label) {
    throw new StudentException(label, HttpStatus.PAYMENT_REQUIRED);
  }

  public static void throwForbidden(String label) {
    throw new StudentException(label, HttpStatus.FORBIDDEN);
  }

  public static void throwNotFound(String label) {
    throw new StudentException(label, HttpStatus.NOT_FOUND);
  }

  public static void throwMethodNotAllowed(String label) {
    throw new StudentException(label, HttpStatus.METHOD_NOT_ALLOWED);
  }

  public static void throwNotAcceptable(String label) {
    throw new StudentException(label, HttpStatus.NOT_ACCEPTABLE);
  }

  public static void throwProxyAuthenticationRequired(String label) {
    throw new StudentException(label, HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
  }

  public static void throwRequestTimeOut(String label) {
    throw new StudentException(label, HttpStatus.REQUEST_TIMEOUT);
  }

  public static void throwConflict(String label) {
    throw new StudentException(label, HttpStatus.CONFLICT);
  }

  public static void throwGone(String label) {
    throw new StudentException(label, HttpStatus.GONE);
  }

  public static void throwLengthRequired(String label) {
    throw new StudentException(label, HttpStatus.LENGTH_REQUIRED);
  }

  public static void throwPreconditionFailed(String label) {
    throw new StudentException(label, HttpStatus.PRECONDITION_FAILED);
  }

  public static void throwPayloadTooLarge(String label) {
    throw new StudentException(label, HttpStatus.PAYLOAD_TOO_LARGE);
  }

  public static void throwUriTooLing(String label) {
    throw new StudentException(label, HttpStatus.URI_TOO_LONG);
  }

  public static void throwUnsupportedMediaType(String label) {
    throw new StudentException(label, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
  }

  public static void throwRequestedRangeNotSatisfiable(String label) {
    throw new StudentException(label, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
  }

  public static void throwExpectationFailed(String label) {
    throw new StudentException(label, HttpStatus.EXPECTATION_FAILED);
  }

  public static void throwUnprocessableEntity(String label) {
    throw new StudentException(label, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  public static void throwLocked(String label) {
    throw new StudentException(label, HttpStatus.LOCKED);
  }

  public static void throwFailedDependency(String label) {
    throw new StudentException(label, HttpStatus.FAILED_DEPENDENCY);
  }

  public static void throwUpgradeRequired(String label) {
    throw new StudentException(label, HttpStatus.UPGRADE_REQUIRED);
  }

  public static void throwPreconditionRequired(String label) {
    throw new StudentException(label, HttpStatus.PRECONDITION_REQUIRED);
  }

  public static void throwTooManyRequests(String label) {
    throw new StudentException(label, HttpStatus.TOO_MANY_REQUESTS);
  }

  public static void throwRequestHeaderFieldsTooLarge(String label) {
    throw new StudentException(label, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
  }

  public static void throwUnavailableForLegalReasons(String label) {
    throw new StudentException(label, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
  }

  public static void throwInternalServerError(String label) {
    throw new StudentException(label, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public static void throwNotImplemented(String label) {
    throw new StudentException(label, HttpStatus.NOT_IMPLEMENTED);
  }

  public static void throwBadGateway(String label) {
    throw new StudentException(label, HttpStatus.BAD_GATEWAY);
  }

  public static void throwServiceUnavailable(String label) {
    throw new StudentException(label, HttpStatus.SERVICE_UNAVAILABLE);
  }

  public static void throwGatewayTimeout(String label) {
    throw new StudentException(label, HttpStatus.GATEWAY_TIMEOUT);
  }

  public static void throwHttpVersionNotSupported(String label) {
    throw new StudentException(label, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
  }

  public static void throwVariantAlsoNegotiates(String label) {
    throw new StudentException(label, HttpStatus.VARIANT_ALSO_NEGOTIATES);
  }

  public static void throwInsufficientStorage(String label) {
    throw new StudentException(label, HttpStatus.INSUFFICIENT_STORAGE);
  }

  public static void throwLoopDetected(String label) {
    throw new StudentException(label, HttpStatus.LOOP_DETECTED);
  }

  public static void throwBandwidthLimitExceeded(String label) {
    throw new StudentException(label, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
  }

  public static void throwNotExtended(String label) {
    throw new StudentException(label, HttpStatus.NOT_EXTENDED);
  }

  public static void throwNetworkAuthenticationRequired(String label) {
    throw new StudentException(label, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
  }
}
