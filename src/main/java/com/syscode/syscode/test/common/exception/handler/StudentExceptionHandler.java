package com.syscode.syscode.test.common.exception.handler;

import com.syscode.syscode.test.common.exception.ErrorLabels;
import com.syscode.syscode.test.common.exception.StudentErrorObject;
import com.syscode.syscode.test.common.exception.StudentException;
import com.syscode.syscode.test.common.exception.StudentFormProperty;
import com.syscode.syscode.test.common.exception.StudentValidationErrorObject;
import com.syscode.syscode.test.common.exception.util.StudentFormPropertyCreator;
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
public abstract class StudentExceptionHandler {

  public StudentExceptionHandler() {}

  private ResponseEntity<StudentErrorObject>
      createStudentErrorResponseEntityAndPrintExceptionToConsole(
          Exception e, HttpStatus status, List<String> messages) {
    e.printStackTrace();
    return ResponseEntity.status(status).body(new StudentErrorObject(messages));
  }

  @ExceptionHandler({StudentException.class})
  protected ResponseEntity<StudentErrorObject> handleStudentException(StudentException ex) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        ex, ex.getHttpStatus(), ex.getMessages());
  }

  @ExceptionHandler({ConstraintViolationException.class})
  protected ResponseEntity<StudentValidationErrorObject> handleConstraintViolationException(
      ConstraintViolationException ex) {
    List<StudentFormProperty> violations =
        StudentFormPropertyCreator.createPropertyFromErrorMsg(ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new StudentValidationErrorObject(violations));
  }

  @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
  protected ResponseEntity<StudentErrorObject> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.METHOD_NOT_ALLOWED,
        ErrorLabels.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION.getLabel());
  }

  @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
  protected ResponseEntity<StudentErrorObject> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.UNSUPPORTED_MEDIA_TYPE,
        ErrorLabels.HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION.getLabel());
  }

  @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
  protected ResponseEntity<StudentErrorObject> handleHttpMediaTypeNotAcceptable(
      HttpMediaTypeNotAcceptableException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.NOT_ACCEPTABLE,
        ErrorLabels.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION.getLabel());
  }

  @ExceptionHandler({MissingPathVariableException.class})
  protected ResponseEntity<StudentErrorObject> handleMissingPathVariable(
      MissingPathVariableException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.INTERNAL_SERVER_ERROR,
        ErrorLabels.MISSING_PATH_VARIABLE_EXCEPTION.getLabel());
  }

  @ExceptionHandler({MissingServletRequestParameterException.class})
  protected ResponseEntity<StudentErrorObject> handleMissingServletRequestParameter(
      MissingServletRequestParameterException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.getLabel());
  }

  @ExceptionHandler({ServletRequestBindingException.class})
  protected ResponseEntity<StudentErrorObject> handleServletRequestBindingException(
      ServletRequestBindingException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.SERVLET_REQUEST_BINDING_EXCEPTION.getLabel());
  }

  @ExceptionHandler({ConversionNotSupportedException.class})
  protected ResponseEntity<StudentErrorObject> handleConversionNotSupported(
      ConversionNotSupportedException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.INTERNAL_SERVER_ERROR,
        ErrorLabels.CONVERSION_NOT_SUPPORTED_EXCEPTION.getLabel());
  }

  @ExceptionHandler({TypeMismatchException.class})
  protected ResponseEntity<StudentErrorObject> handleTypeMismatch(TypeMismatchException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception, HttpStatus.BAD_REQUEST, ErrorLabels.TYPE_MISMATCH_EXCEPTION.getLabel());
  }

  @ExceptionHandler({HttpMessageNotReadableException.class})
  protected ResponseEntity<StudentErrorObject> handleHttpMessageNotReadable(
      HttpMessageNotReadableException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.HTTP_MESSAGE_NOT_READABLE_EXCEPTION.getLabel());
  }

  @ExceptionHandler({HttpMessageNotWritableException.class})
  protected ResponseEntity<StudentErrorObject> handleHttpMessageNotWritable(
      HttpMessageNotWritableException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION.getLabel());
  }

  @ExceptionHandler({MethodArgumentNotValidException.class})
  protected ResponseEntity<StudentErrorObject> handleMethodArgumentNotValid(
      MethodArgumentNotValidException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.getLabel());
  }

  @ExceptionHandler({MissingServletRequestPartException.class})
  protected ResponseEntity<StudentErrorObject> handleMissingServletRequestPart(
      MissingServletRequestPartException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.BAD_REQUEST,
        ErrorLabels.MISSING_SERVLET_REQUEST_PART_EXCEPTION.getLabel());
  }

  @ExceptionHandler({BindException.class})
  protected ResponseEntity<StudentErrorObject> handleBindException(BindException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception, HttpStatus.BAD_REQUEST, ErrorLabels.BIND_EXCEPTION.getLabel());
  }

  @ExceptionHandler({AsyncRequestTimeoutException.class})
  protected ResponseEntity<StudentErrorObject> handleAsyncRequestTimeoutException(
      AsyncRequestTimeoutException exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception,
        HttpStatus.SERVICE_UNAVAILABLE,
        ErrorLabels.ASYNC_REQUEST_TIMEOUT_EXCEPTION.getLabel());
  }

  @ExceptionHandler({Exception.class})
  protected ResponseEntity<StudentErrorObject> handleUnknownException(Exception exception) {
    return this.createStudentErrorResponseEntityAndPrintExceptionToConsole(
        exception, HttpStatus.INTERNAL_SERVER_ERROR, ErrorLabels.INTERNAL_SERVER_ERROR.getLabel());
  }
}
