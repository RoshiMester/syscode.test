package com.syscode.syscode.test.common.exception.handler;

import com.syscode.syscode.test.common.exception.ErrorLabels;
import com.syscode.syscode.test.common.exception.SyscodeErrorObject;
import com.syscode.syscode.test.common.exception.SyscodeException;
import com.syscode.syscode.test.common.exception.SyscodeFormProperty;
import com.syscode.syscode.test.common.exception.SyscodeValidationErrorObject;
import com.syscode.syscode.test.common.exception.util.SyscodeFormPropertyCreator;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@ControllerAdvice
public abstract class SyscodeExceptionHandler {

  public SyscodeExceptionHandler() {}

  private ResponseEntity<SyscodeErrorObject>
      createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
          Exception e, HttpStatus status, List<String> messages) {
    e.printStackTrace();
    return ResponseEntity.status(status).body(new SyscodeErrorObject(messages));
  }

  @ExceptionHandler({SyscodeException.class})
  protected ResponseEntity<SyscodeErrorObject> handleSyscodeException(SyscodeException ex) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        ex, ex.getHttpStatus(), ex.getMessages());
  }

  @ExceptionHandler({ConstraintViolationException.class})
  protected ResponseEntity<SyscodeValidationErrorObject> handleConstraintViolationException(
      ConstraintViolationException ex) {
    List<SyscodeFormProperty> violations =
        SyscodeFormPropertyCreator.createPropertyFromErrorMsg(ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new SyscodeValidationErrorObject(violations));
  }

  @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
  protected ResponseEntity<SyscodeErrorObject> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.METHOD_NOT_ALLOWED,
        ErrorLabels.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION.getLabel());
  }

  @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
  protected ResponseEntity<SyscodeErrorObject> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.UNSUPPORTED_MEDIA_TYPE,
        ErrorLabels.HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION.getLabel());
  }

  @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
  protected ResponseEntity<SyscodeErrorObject> handleHttpMediaTypeNotAcceptable(
      HttpMediaTypeNotAcceptableException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.NOT_ACCEPTABLE,
        ErrorLabels.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION.getLabel());
  }

  @ExceptionHandler({MissingPathVariableException.class})
  protected ResponseEntity<SyscodeErrorObject> handleMissingPathVariable(
      MissingPathVariableException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.INTERNAL_SERVER_ERROR,
        ErrorLabels.MISSING_PATH_VARIABLE_EXCEPTION.getLabel());
  }

  @ExceptionHandler({MissingServletRequestParameterException.class})
  protected ResponseEntity<SyscodeErrorObject> handleMissingServletRequestParameter(
      MissingServletRequestParameterException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.getLabel());
  }

  @ExceptionHandler({ServletRequestBindingException.class})
  protected ResponseEntity<SyscodeErrorObject> handleServletRequestBindingException(
      ServletRequestBindingException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.SERVLET_REQUEST_BINDING_EXCEPTION.getLabel());
  }

  @ExceptionHandler({ConversionNotSupportedException.class})
  protected ResponseEntity<SyscodeErrorObject> handleConversionNotSupported(
      ConversionNotSupportedException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.INTERNAL_SERVER_ERROR,
        ErrorLabels.CONVERSION_NOT_SUPPORTED_EXCEPTION.getLabel());
  }

  @ExceptionHandler({TypeMismatchException.class})
  protected ResponseEntity<SyscodeErrorObject> handleTypeMismatch(TypeMismatchException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception, HttpStatus.BAD_REQUEST, ErrorLabels.TYPE_MISMATCH_EXCEPTION.getLabel());
  }

  @ExceptionHandler({HttpMessageNotReadableException.class})
  protected ResponseEntity<SyscodeErrorObject> handleHttpMessageNotReadable(
      HttpMessageNotReadableException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.HTTP_MESSAGE_NOT_READABLE_EXCEPTION.getLabel());
  }

  @ExceptionHandler({HttpMessageNotWritableException.class})
  protected ResponseEntity<SyscodeErrorObject> handleHttpMessageNotWritable(
      HttpMessageNotWritableException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION.getLabel());
  }

  @ExceptionHandler({MethodArgumentNotValidException.class})
  protected ResponseEntity<SyscodeErrorObject> handleMethodArgumentNotValid(
      MethodArgumentNotValidException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.getLabel());
  }

  @ExceptionHandler({MissingServletRequestPartException.class})
  protected ResponseEntity<SyscodeErrorObject> handleMissingServletRequestPart(
      MissingServletRequestPartException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.MISSING_SERVLET_REQUEST_PART_EXCEPTION.getLabel());
  }

  @ExceptionHandler({BindException.class})
  protected ResponseEntity<SyscodeErrorObject> handleBindException(BindException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception, HttpStatus.BAD_REQUEST, ErrorLabels.BIND_EXCEPTION.getLabel());
  }

  @ExceptionHandler({AsyncRequestTimeoutException.class})
  protected ResponseEntity<SyscodeErrorObject> handleAsyncRequestTimeoutException(
      AsyncRequestTimeoutException exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.SERVICE_UNAVAILABLE,
        ErrorLabels.ASYNC_REQUEST_TIMEOUT_EXCEPTION.getLabel());
  }

  @ExceptionHandler({Exception.class})
  protected ResponseEntity<SyscodeErrorObject> handleUnknownException(Exception exception) {
    return this.createSyscodeErrorResponseEntityAndPrintExceptionToConsole(
        exception, HttpStatus.INTERNAL_SERVER_ERROR, ErrorLabels.INTERNAL_SERVER_ERROR.getLabel());
  }
}
