package kr.ac.kumoh.allimi.exception;

import kr.ac.kumoh.allimi.exception.user.UserAuthException;
import kr.ac.kumoh.allimi.exception.user.UserException;
import kr.ac.kumoh.allimi.exception.user.UserIdDuplicateException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DataAlreadyExistsException.class})
    protected ResponseEntity handleDataAlreadyExistsException(DataAlreadyExistsException e) {
        log.info("NHRAlreadyExistsException = {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler({DataAlreadyExistsException2.class})
    protected ResponseEntity handleDataAlreadyExistsException2(DataAlreadyExistsException2 e) {
        log.info("NHRAlreadyExistsException2 = {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @ExceptionHandler({IllegalArgumentException.class})
    protected ResponseEntity handleIllegalArgumentException(IllegalArgumentException e) {
        log.info("IllegalArgumentException = {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({InputException.class})
    protected ResponseEntity handleInputException(InputException e) {
        log.info("InputException = {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({NoSuchElementException.class})
    protected ResponseEntity handleNoSuchElementException(NoSuchElementException e) {
        log.info("NoSuchElementException = {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404
    }

    @ExceptionHandler({UserException.class})
    protected ResponseEntity handleUserException(UserException e) {
        log.info("UserException = {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler({UserIdDuplicateException.class})
    protected ResponseEntity handleUserDuplicateException(UserIdDuplicateException e) {
        log.info("UserIdDuplicateException = {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).build(); //409
    }

    @ExceptionHandler({UserAuthException.class})
    protected ResponseEntity handleUserAuthException(UserAuthException e) {
        log.info("UserAuthException = {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({FacilityException.class})
    protected ResponseEntity handleFacilityException(FacilityException e) {
        log.info("FacilityException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({AllNoticeException.class})
    protected ResponseEntity handleAllNoticeException(AllNoticeException e) {
        log.info("AllNoticeException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({InvitationException.class})
    protected ResponseEntity handleInvitationException(InvitationException e) {
        log.info("InvitationException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({LetterException.class})
    protected ResponseEntity handleLetterException(LetterException e) {
        log.info("LetterException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({NHResidentException.class})
    protected ResponseEntity handleNHResidentException(NHResidentException e) {
        log.info("NHResidentException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler({NoticeException.class})
    protected ResponseEntity handleNoticeException(NoticeException e) {
        log.info("NoticeException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({ScheduleException.class})
    protected ResponseEntity handleScheduleException(ScheduleException e) {
        log.info("ScheduleException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({VisitException.class})
    protected ResponseEntity handleVisitException(VisitException e) {
        log.info("VisitException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler({InternalException.class})
    protected ResponseEntity handleInternalException(InternalException e) {
        log.info("InternalExcpetion={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
    }

    @ExceptionHandler({FileSizeLimitExceededException.class, FileCountExceedException.class})
    protected ResponseEntity handleExceededException(Exception e) {
        log.info("ExceededException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).build(); // 413
    }

    @ExceptionHandler(LocationException.class)
    protected ResponseEntity handleLocationException(LocationException e) {
        log.info("LocationException={}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
