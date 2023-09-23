package com.syscode.syscode.test.common.exception;

import java.util.Collections;
import java.util.List;

public enum ErrorLabels {
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION(
            Collections.singletonList("http_request_method_not_supported_exception_label")),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION(
            Collections.singletonList("http_media_type_not_supported_exception_label")),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION(
            Collections.singletonList("http_media_type_not_acceptable_exception_label")),
    MISSING_PATH_VARIABLE_EXCEPTION(
            Collections.singletonList("missing_path_variable_exception_label")),
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION(
            Collections.singletonList("missing_servlet_request_parameter_exception_label")),
    SERVLET_REQUEST_BINDING_EXCEPTION(
            Collections.singletonList("servlet_request_binding_exception_label")),
    CONVERSION_NOT_SUPPORTED_EXCEPTION(
            Collections.singletonList("conversion_not_supported_exception_label")),
    TYPE_MISMATCH_EXCEPTION(Collections.singletonList("type_mismatch_exception_label")),
    HTTP_MESSAGE_NOT_READABLE_EXCEPTION(
            Collections.singletonList("http_message_not_readable_exception_label")),
    HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION(
            Collections.singletonList("http_message_not_writable_exception_label")),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION(
            Collections.singletonList("method_argument_not_valid_exception_label")),
    MISSING_SERVLET_REQUEST_PART_EXCEPTION(
            Collections.singletonList("missing_servlet_request_part_exception_label")),
    BIND_EXCEPTION(Collections.singletonList("bind_exception_label")),
    NO_HANDLER_FOUND_EXCEPTION(Collections.singletonList("no_handler_found_exception_label")),
    ASYNC_REQUEST_TIMEOUT_EXCEPTION(
            Collections.singletonList("async_request_timeout_exception_label")),
    INTERNAL_SERVER_ERROR(Collections.singletonList("internal_server_error_label"));

    private final List<String> label;

    public List<String> getLabel() {
        return this.label;
    }

    ErrorLabels(List<String> label) {
        this.label = label;
    }
}
